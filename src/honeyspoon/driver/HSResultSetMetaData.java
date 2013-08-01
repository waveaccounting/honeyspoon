package honeyspoon.driver;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class HSResultSetMetaData implements ResultSetMetaData {
    private ResultSetMetaData metadata;

    public HSResultSetMetaData(ResultSetMetaData metadata) {
        this.metadata = metadata;
    }

    public int getColumnCount() throws SQLException {
        return metadata.getColumnCount();
    }

    public boolean isAutoIncrement(int column) throws SQLException {
        return metadata.isAutoIncrement(column);
    }

    public boolean isCaseSensitive(int column) throws SQLException {
        return metadata.isCaseSensitive(column);
    }

    public boolean isSearchable(int column) throws SQLException {
        return metadata.isSearchable(column);
    }

    public boolean isCurrency(int column) throws SQLException {
        return metadata.isCurrency(column);
    }

    public int isNullable(int column) throws SQLException {
        return metadata.isNullable(column);
    }

    public boolean isSigned(int column) throws SQLException {
        return true; //metadata.isSigned(column);
    }

    public int getColumnDisplaySize(int column) throws SQLException {
        return metadata.getColumnDisplaySize(column);
    }

    public String getColumnLabel(int column) throws SQLException {
        return metadata.getColumnLabel(column);
    }

    public String getColumnName(int column) throws SQLException {
        return metadata.getColumnName(column);
    }

    public String getSchemaName(int column) throws SQLException {
        return metadata.getSchemaName(column);
    }

    public int getPrecision(int column) throws SQLException {
        return metadata.getPrecision(column);
    }

    public int getScale(int column) throws SQLException {
        return metadata.getScale(column);
    }

    public String getTableName(int column) throws SQLException {
        return metadata.getTableName(column);
    }

    public String getCatalogName(int column) throws SQLException {
        return metadata.getCatalogName(column);
    }

    public int getColumnType(int column) throws SQLException {
        return metadata.getColumnType(column);
    }

    public String getColumnTypeName(int column) throws SQLException {
        return metadata.getColumnTypeName(column);
    }

    public boolean isReadOnly(int column) throws SQLException {
        return metadata.isReadOnly(column);
    }

    public boolean isWritable(int column) throws SQLException {
        return metadata.isWritable(column);
    }

    public boolean isDefinitelyWritable(int column) throws SQLException {
        return metadata.isDefinitelyWritable(column);
    }

    public String getColumnClassName(int column) throws SQLException {
        return metadata.getColumnClassName(column);
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return metadata.unwrap(iface);
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return metadata.isWrapperFor(iface);
    }
}
