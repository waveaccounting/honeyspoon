package honeyspoon;

import com.cloudera.sqoop.mapreduce.db.DBConfiguration;
import com.cloudera.sqoop.mapreduce.db.DBInputFormat;
import com.cloudera.sqoop.mapreduce.db.DataDrivenDBRecordReader;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.sqoop.mapreduce.DBWritable;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class HSDBRecordReader<T extends DBWritable>
        extends DataDrivenDBRecordReader<T> {

    private static final Log LOG = LogFactory.getLog(HSDBRecordReader.class);

    public HSDBRecordReader(DBInputFormat.DBInputSplit split,
                            Class<T> inputClass, Configuration conf, Connection conn,
                            DBConfiguration dbConfig, String cond, String[] fields,
                            String table) throws SQLException {
        super(split, inputClass, conf, conn, dbConfig, cond, fields, table, "HONEYSPOON");
    }

    protected String getSelectQuery() {
        StringBuilder query = new StringBuilder();
        DBConfiguration dbConf = getDBConf();
        String conditions = getConditions();
        String tableName = getTableName();
        String[] fieldNames = getFieldNames();
        DBInputFormat.DBInputSplit split = getSplit();

        if (dbConf.getInputQuery() == null) {
            query.append("SELECT ");

            for (int i = 0; i < fieldNames.length; i++) {
                query.append(fieldNames[i]);
                if (i != fieldNames.length - 1) {
                    query.append(", ");
                }
            }

            query.append(" FROM ").append(tableName);
            query.append(" t ");
            if (conditions != null && conditions.length() > 0) {
                query.append(" WHERE (").append(conditions).append(")");
            }

            String orderBy = dbConf.getInputOrderBy();
            if (orderBy != null && orderBy.length() > 0) {
                query.append(" ORDER BY ").append(orderBy);
            }
        } else {
            query.append(dbConf.getInputQuery());
        }

        try {
            if (split.getLength() > 0 || split.getStart() > 0) {
                throw new IllegalArgumentException("Start/Length based splits are not supported.");
            }
        } catch (IOException ex) {
            LOG.error(ex.toString());
        }

        return query.toString();
    }
}
