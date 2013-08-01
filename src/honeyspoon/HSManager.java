package honeyspoon;

import com.cloudera.sqoop.SqoopOptions;
import com.cloudera.sqoop.mapreduce.ImportJobBase;
import com.cloudera.sqoop.util.ImportException;
import honeyspoon.driver.HSConnection;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.sqoop.manager.GenericJdbcManager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("deprecation")
public class HSManager extends GenericJdbcManager {
    public static final Log LOG = LogFactory.getLog(
            HSManager.class.getName());

    private static final String DRIVER_CLASS = "honeyspoon.driver.HSDriver";

    public HSManager(final SqoopOptions opts) {
        super(DRIVER_CLASS, opts);
    }

    public HSManager(final String driverClass, final SqoopOptions opts) {
        super(driverClass, opts);
    }

    @Override
    protected String getColNamesQuery(String tableName) {
        return "SELECT t.* FROM " + escapeTableName(tableName) + " t WHERE 1=0";
    }

    @Override
    protected java.sql.Connection makeConnection() throws SQLException {
        java.sql.Connection conn = super.makeConnection();
        return new HSConnection(conn);
    }

    @Override
    public ResultSet readTable(String tableName, String[] columns)
            throws SQLException {
        if (columns == null) {
            columns = getColumnNames(tableName);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        boolean first = true;
        for (String col : columns) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(escapeColName(col));
            first = false;
        }
        sb.append(" FROM ");
        sb.append(escapeTableName(tableName));
        sb.append(" ");
        sb.append(escapeTableName(tableName));

        String sqlCmd = sb.toString();
        LOG.debug("Reading table with command: " + sqlCmd);
        return execute(sqlCmd);
    }

    public void importTable(com.cloudera.sqoop.manager.ImportJobContext context)
            throws IOException, ImportException {
        String tableName = context.getTableName();
        String jarFile = context.getJarFile();
        SqoopOptions opts = context.getOptions();
        context.setConnManager(this);
        context.setInputFormat(HSDBInputFormat.class);
        ImportJobBase importer = new HSImportJob(opts, context);
        checkTableImportOptions(context);
        String splitCol = getSplitColumn(opts, tableName);
        importer.runImport(tableName, jarFile, splitCol, opts.getConf());
    }

    public void importQuery(com.cloudera.sqoop.manager.ImportJobContext context)
            throws IOException, ImportException {
        String jarFile = context.getJarFile();
        SqoopOptions opts = context.getOptions();
        context.setConnManager(this);
        context.setInputFormat(HSDBInputFormat.class);
        ImportJobBase importer = new HSImportJob(opts, context);
        String splitCol = getSplitColumn(opts, null);
        if (splitCol == null) {
            String boundaryQuery = opts.getBoundaryQuery();
            if (opts.getNumMappers() > 1) {
                // Can't infer a primary key.
                throw new ImportException("A split-by column must be specified for "
                        + "parallel free-form query imports. Please specify one with "
                        + "--split-by or perform a sequential import with '-m 1'.");
            } else if (boundaryQuery != null && !boundaryQuery.isEmpty()) {
                // Query import with boundary query and no split column specified
                throw new ImportException("Using a boundary query for a query based "
                        + "import requires specifying the split by column as well. Please "
                        + "specify a column name using --split-by and try again.");
            }
        }
        importer.runImport(null, jarFile, splitCol, opts.getConf());
    }

    @Override
    public String getInputBoundsQuery(String splitByCol, String sanitizedQuery) {
        return "SELECT MIN(" + splitByCol + "), MAX(" + splitByCol + ") FROM ("
                + sanitizedQuery + ") t1";
    }
}
