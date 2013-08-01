package honeyspoon;

import com.cloudera.sqoop.mapreduce.db.DBConfiguration;
import com.cloudera.sqoop.mapreduce.db.DBInputFormat;
import com.cloudera.sqoop.mapreduce.db.DataDrivenDBInputFormat;
import org.apache.hadoop.conf.Configurable;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.sqoop.mapreduce.DBWritable;

import java.io.IOException;
import java.sql.SQLException;

public class HSDBInputFormat<T extends DBWritable>
        extends DataDrivenDBInputFormat<T> implements Configurable {

    @Override
    protected RecordReader<LongWritable, T> createDBRecordReader(
            DBInputSplit split, Configuration conf) throws IOException {
        DBConfiguration dbConf = getDBConf();
        @SuppressWarnings("unchecked")
        Class<T> inputClass = (Class<T>) (dbConf.getInputClass());

        try {
            return new HSDBRecordReader<T>(split, inputClass,
                    conf, getConnection(), dbConf, dbConf.getInputConditions(),
                    dbConf.getInputFieldNames(), dbConf.getInputTableName());
        } catch (SQLException ex) {
            throw new IOException(ex);
        }
    }

    public static void setInput(Job job,
                                Class<? extends DBWritable> inputClass,
                                String inputQuery, String inputBoundingQuery) {
        DBInputFormat.setInput(job, inputClass, inputQuery, "");
        job.getConfiguration().set(DBConfiguration.INPUT_BOUNDING_QUERY,
                inputBoundingQuery);
        job.setInputFormatClass(HSDBInputFormat.class);
    }

    /*
    protected DBSplitter getSplitter(int sqlDataType) {
        switch (sqlDataType) {
            case Types.NUMERIC:
            case Types.DECIMAL:
                return new BigDecimalSplitter();

            case Types.BIT:
            case Types.BOOLEAN:
                return new BooleanSplitter();

            case Types.INTEGER:
            case Types.TINYINT:
            case Types.SMALLINT:
            case Types.BIGINT:
                return new IntegerSplitter();

            case Types.REAL:
            case Types.FLOAT:
            case Types.DOUBLE:
                return new FloatSplitter();

            case Types.CHAR:
            case Types.VARCHAR:
            case Types.LONGVARCHAR:
                return new TextSplitter();

            case Types.DATE:
            case Types.TIME:
            case Types.TIMESTAMP:
                return new DateSplitter();

            default:
                // TODO: Support BINARY, VARBINARY, LONGVARBINARY, DISTINCT, CLOB,
                // BLOB, ARRAY, STRUCT, REF, DATALINK, and JAVA_OBJECT.
                return null;
        }
    }
    */
}
