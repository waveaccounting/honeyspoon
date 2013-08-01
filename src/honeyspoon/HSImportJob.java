package honeyspoon;

import com.cloudera.sqoop.SqoopOptions;
import com.cloudera.sqoop.config.ConfigurationHelper;
import com.cloudera.sqoop.lib.LargeObjectLoader;
import com.cloudera.sqoop.manager.ConnManager;
import com.cloudera.sqoop.manager.ImportJobContext;
import com.cloudera.sqoop.mapreduce.db.DBConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.mapreduce.Job;
import org.apache.sqoop.mapreduce.DBWritable;
import org.apache.sqoop.mapreduce.DataDrivenImportJob;

import java.io.IOException;
import java.sql.SQLException;

public class HSImportJob extends DataDrivenImportJob {
    public static final Log LOG = LogFactory.getLog(
            HSImportJob.class.getName());

    public HSImportJob(final SqoopOptions opts,
                       ImportJobContext context) {
        super(opts, HSDBInputFormat.class, context);
    }

    /*
    public void runImport(String tableName, String ormJarFile, String splitByCol,
                          Configuration conf) throws IOException, ImportException {
        if (null != tableName) {
            LOG.info("Beginning import of " + tableName);
        } else {
            LOG.info("Beginning query import.");
        }

        String tableClassName = new TableClassName(options).getClassForTable(tableName);
        loadJars(conf, ormJarFile, tableClassName);

        Job job = new Job(conf);
        try {
            // Set the external jar to use for the job.
            job.getConfiguration().set("mapred.jar", ormJarFile);
            if (options.getMapreduceJobName() != null) {
                job.setJobName(options.getMapreduceJobName());
            }

            propagateOptionsToJob(job);
            configureInputFormat(job, tableName, tableClassName, splitByCol);
            configureOutputFormat(job, tableName, tableClassName);
            configureMapper(job, tableName, tableClassName);
            configureNumTasks(job);
            cacheJars(job, getContext().getConnManager());

            jobSetup(job);
            setJob(job);
            boolean success = runJob(job);
            if (!success) {
                throw new ImportException("Import job failed!");
            }

            if (options.isValidationEnabled()) {
                validateImport(tableName, conf, job);
            }
        } catch (InterruptedException ie) {
            throw new IOException(ie);
        } catch (ClassNotFoundException cnfe) {
            throw new IOException(cnfe);
        } finally {
            unloadJars();
            jobTeardown(job);
        }
    }

    @Override
    protected void configureMapper(Job job, String tableName,
                                   String tableClassName) throws IOException {
        if (options.getFileLayout() == SqoopOptions.FileLayout.TextFile) {
            // For text files, specify these as the output types; for
            // other types, we just use the defaults.
            job.setOutputKeyClass(Text.class);
            job.setOutputValueClass(NullWritable.class);
        } else if (options.getFileLayout() == SqoopOptions.FileLayout.AvroDataFile) {
            ConnManager connManager = getContext().getConnManager();
            AvroSchemaGenerator generator = new AvroSchemaGenerator(options,
                    connManager, tableName);
            Schema schema = generator.generate();
            AvroJob.setMapOutputSchema(job.getConfiguration(), schema);
        }
        job.setMapperClass(getMapperClass());
    }

    @Override
    protected Class<? extends Mapper> getMapperClass() {
        if (options.getFileLayout() == SqoopOptions.FileLayout.TextFile) {
            return TextImportMapper.class;
        } else if (options.getFileLayout()
                == SqoopOptions.FileLayout.SequenceFile) {
            return SequenceFileImportMapper.class;
        } else if (options.getFileLayout()
                == SqoopOptions.FileLayout.AvroDataFile) {
            return AvroImportMapper.class;
        }
        return null;
    }

    @Override
    protected Class<? extends OutputFormat> getOutputFormatClass()
            throws ClassNotFoundException {
        if (options.getFileLayout() == SqoopOptions.FileLayout.TextFile) {
            return RawKeyTextOutputFormat.class;
        } else if (options.getFileLayout()
                == SqoopOptions.FileLayout.SequenceFile) {
            return SequenceFileOutputFormat.class;
        } else if (options.getFileLayout()
                == SqoopOptions.FileLayout.AvroDataFile) {
            return AvroOutputFormat.class;
        }
        return null;
    }
    */

    private String buildBoundaryQuery(String col, String query) {
        if (col == null || options.getNumMappers() == 1) {
            return "";
        }
        String alias = "t1";
        int dot = col.lastIndexOf('.');
        String qualifiedName = (dot == -1) ? col : alias + col.substring(dot);

        ConnManager mgr = getContext().getConnManager();
        String ret = mgr.getInputBoundsQuery(qualifiedName, query);
        if (ret != null) {
            return ret;
        }

        return "SELECT MIN(" + qualifiedName + "), MAX(" + qualifiedName + ") "
                + "FROM (" + query + ") " + alias;
    }


    @Override
    protected void configureInputFormat(Job job, String tableName,
                                        String tableClassName, String splitByCol) throws IOException {
        ConnManager mgr = getContext().getConnManager();
        try {
            String username = options.getUsername();
            if (null == username || username.length() == 0) {
                DBConfiguration.configureDB(job.getConfiguration(),
                        mgr.getDriverClass(), options.getConnectString(),
                        options.getFetchSize(), options.getConnectionParams());
            } else {
                DBConfiguration.configureDB(job.getConfiguration(),
                        mgr.getDriverClass(), options.getConnectString(),
                        username, options.getPassword(), options.getFetchSize(),
                        options.getConnectionParams());
            }

            if (null != tableName) {
                // Import a table.
                String[] colNames = options.getColumns();
                if (null == colNames) {
                    colNames = mgr.getColumnNames(tableName);
                }

                String[] sqlColNames = null;
                if (null != colNames) {
                    sqlColNames = new String[colNames.length];
                    for (int i = 0; i < colNames.length; i++) {
                        sqlColNames[i] = mgr.escapeColName(colNames[i]);
                    }
                }

                // It's ok if the where clause is null in DBInputFormat.setInput.
                String whereClause = options.getWhereClause();

                // We can't set the class properly in here, because we may not have the
                // jar loaded in this JVM. So we start by calling setInput() with
                // DBWritable and then overriding the string manually.
                HSDBInputFormat.setInput(job, DBWritable.class,
                        mgr.escapeTableName(tableName), whereClause,
                        mgr.escapeColName(splitByCol), sqlColNames);

                // If user specified boundary query on the command line propagate it to
                // the job
                if (options.getBoundaryQuery() != null) {
                    HSDBInputFormat.setBoundingQuery(job.getConfiguration(),
                            options.getBoundaryQuery());
                }
            } else {
                // Import a free-form query.
                String inputQuery = options.getSqlQuery();
                String sanitizedQuery = inputQuery.replace(
                        HSDBInputFormat.SUBSTITUTE_TOKEN, " (1 = 1) ");

                String inputBoundingQuery = options.getBoundaryQuery();
                if (inputBoundingQuery == null) {
                    inputBoundingQuery = buildBoundaryQuery(splitByCol, sanitizedQuery);
                }
                HSDBInputFormat.setInput(job, DBWritable.class,
                        inputQuery, inputBoundingQuery);
                new DBConfiguration(job.getConfiguration()).setInputOrderBy(
                        splitByCol);
            }

            LOG.debug("Using table class: " + tableClassName);
            job.getConfiguration().set(ConfigurationHelper.getDbInputClassProperty(),
                    tableClassName);

            job.getConfiguration().setLong(LargeObjectLoader.MAX_INLINE_LOB_LEN_KEY,
                    options.getInlineLobLimit());

            LOG.debug("Using InputFormat: " + inputFormatClass);
            job.setInputFormatClass(inputFormatClass);
        } finally {
            try {
                mgr.close();
            } catch (SQLException sqlE) {
                LOG.warn("Error closing connection: " + sqlE);
            }
        }
    }
}
