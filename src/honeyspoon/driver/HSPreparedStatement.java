package honeyspoon.driver;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

public class HSPreparedStatement implements PreparedStatement {
    private PreparedStatement statement;

    public HSPreparedStatement(PreparedStatement statement) {
        this.statement = statement;
    }

    public ResultSet executeQuery() throws SQLException {
        return new HSResultSet(statement.executeQuery());
    }

    public int executeUpdate() throws SQLException {
        return statement.executeUpdate();
    }

    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        statement.setNull(parameterIndex, sqlType);
    }

    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
        statement.setBoolean(parameterIndex, x);
    }

    public void setByte(int parameterIndex, byte x) throws SQLException {
        statement.setByte(parameterIndex, x);
    }

    public void setShort(int parameterIndex, short x) throws SQLException {
        statement.setShort(parameterIndex, x);
    }

    public void setInt(int parameterIndex, int x) throws SQLException {
        statement.setInt(parameterIndex, x);
    }

    public void setLong(int parameterIndex, long x) throws SQLException {
        statement.setLong(parameterIndex, x);
    }

    public void setFloat(int parameterIndex, float x) throws SQLException {
        statement.setFloat(parameterIndex, x);
    }

    public void setDouble(int parameterIndex, double x) throws SQLException {
        statement.setDouble(parameterIndex, x);
    }

    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
        statement.setBigDecimal(parameterIndex, x);
    }

    public void setString(int parameterIndex, String x) throws SQLException {
        statement.setString(parameterIndex, x);
    }

    public void setBytes(int parameterIndex, byte[] x) throws SQLException {
        statement.setBytes(parameterIndex, x);
    }

    public void setDate(int parameterIndex, Date x) throws SQLException {
        statement.setDate(parameterIndex, x);
    }

    public void setTime(int parameterIndex, Time x) throws SQLException {
        statement.setTime(parameterIndex, x);
    }

    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
        statement.setTimestamp(parameterIndex, x);
    }

    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
        statement.setAsciiStream(parameterIndex, x, length);
    }

    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
        statement.setUnicodeStream(parameterIndex, x, length);
    }

    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
        statement.setBinaryStream(parameterIndex, x, length);
    }

    public void clearParameters() throws SQLException {
        statement.clearParameters();
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
        statement.setObject(parameterIndex, x, targetSqlType);
    }

    public void setObject(int parameterIndex, Object x) throws SQLException {
        statement.setObject(parameterIndex, x);
    }

    public boolean execute() throws SQLException {
        return statement.execute();
    }

    public void addBatch() throws SQLException {
        statement.addBatch();
    }

    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
        statement.setCharacterStream(parameterIndex, reader, length);
    }

    public void setRef(int parameterIndex, Ref x) throws SQLException {
        statement.setRef(parameterIndex, x);
    }

    public void setBlob(int parameterIndex, Blob x) throws SQLException {
        statement.setBlob(parameterIndex, x);
    }

    public void setClob(int parameterIndex, Clob x) throws SQLException {
        statement.setClob(parameterIndex, x);
    }

    public void setArray(int parameterIndex, Array x) throws SQLException {
        statement.setArray(parameterIndex, x);
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        return new HSResultSetMetaData(statement.getMetaData());
    }

    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
        statement.setDate(parameterIndex, x, cal);
    }

    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
        statement.setTime(parameterIndex, x, cal);
    }

    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
        statement.setTimestamp(parameterIndex, x, cal);
    }

    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
        statement.setNull(parameterIndex, sqlType, typeName);
    }

    public void setURL(int parameterIndex, URL x) throws SQLException {
        statement.setURL(parameterIndex, x);
    }

    public ParameterMetaData getParameterMetaData() throws SQLException {
        return statement.getParameterMetaData();
    }

    public void setRowId(int parameterIndex, RowId x) throws SQLException {
        statement.setRowId(parameterIndex, x);
    }

    public void setNString(int parameterIndex, String value) throws SQLException {
        statement.setNString(parameterIndex, value);
    }

    public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
        statement.setNCharacterStream(parameterIndex, value, length);
    }

    public void setNClob(int parameterIndex, NClob value) throws SQLException {
        statement.setNClob(parameterIndex, value);
    }

    public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
        statement.setClob(parameterIndex, reader, length);
    }

    public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
        statement.setBlob(parameterIndex, inputStream, length);
    }

    public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
        statement.setNClob(parameterIndex, reader, length);
    }

    public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
        statement.setSQLXML(parameterIndex, xmlObject);
    }

    public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) throws SQLException {
        statement.setObject(parameterIndex, x, targetSqlType, scaleOrLength);
    }

    public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
        statement.setAsciiStream(parameterIndex, x, length);
    }

    public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
        statement.setBinaryStream(parameterIndex, x, length);
    }

    public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
        statement.setCharacterStream(parameterIndex, reader, length);
    }

    public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
        statement.setAsciiStream(parameterIndex, x);
    }

    public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
        statement.setBinaryStream(parameterIndex, x);
    }

    public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
        statement.setCharacterStream(parameterIndex, reader);
    }

    public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
        statement.setNCharacterStream(parameterIndex, value);
    }

    public void setClob(int parameterIndex, Reader reader) throws SQLException {
        statement.setClob(parameterIndex, reader);
    }

    public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
        statement.setBlob(parameterIndex, inputStream);
    }

    public void setNClob(int parameterIndex, Reader reader) throws SQLException {
        statement.setNClob(parameterIndex, reader);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        return new HSResultSet(statement.executeQuery(sql));
    }

    public int executeUpdate(String sql) throws SQLException {
        return statement.executeUpdate(sql);
    }

    public void close() throws SQLException {
        statement.close();
    }

    public int getMaxFieldSize() throws SQLException {
        return statement.getMaxFieldSize();
    }

    public void setMaxFieldSize(int max) throws SQLException {
        statement.setMaxFieldSize(max);
    }

    public int getMaxRows() throws SQLException {
        return statement.getMaxRows();
    }

    public void setMaxRows(int max) throws SQLException {
        statement.setMaxRows(max);
    }

    public void setEscapeProcessing(boolean enable) throws SQLException {
        statement.setEscapeProcessing(enable);
    }

    public int getQueryTimeout() throws SQLException {
        return statement.getQueryTimeout();
    }

    public void setQueryTimeout(int seconds) throws SQLException {
        statement.setQueryTimeout(seconds);
    }

    public void cancel() throws SQLException {
        statement.cancel();
    }

    public SQLWarning getWarnings() throws SQLException {
        return statement.getWarnings();
    }

    public void clearWarnings() throws SQLException {
        statement.clearWarnings();
    }

    public void setCursorName(String name) throws SQLException {
        statement.setCursorName(name);
    }

    public boolean execute(String sql) throws SQLException {
        return statement.execute(sql);
    }

    public ResultSet getResultSet() throws SQLException {
        return new HSResultSet(statement.getResultSet());
    }

    public int getUpdateCount() throws SQLException {
        return statement.getUpdateCount();
    }

    public boolean getMoreResults() throws SQLException {
        return statement.getMoreResults();
    }

    public void setFetchDirection(int direction) throws SQLException {
        statement.setFetchDirection(direction);
    }

    public int getFetchDirection() throws SQLException {
        return statement.getFetchDirection();
    }

    public void setFetchSize(int rows) throws SQLException {
        //pass
    }

    public int getFetchSize() throws SQLException {
        return statement.getFetchSize();
    }

    public int getResultSetConcurrency() throws SQLException {
        return statement.getResultSetConcurrency();
    }

    public int getResultSetType() throws SQLException {
        return statement.getResultSetType();
    }

    public void addBatch(String sql) throws SQLException {
        statement.addBatch(sql);
    }

    public void clearBatch() throws SQLException {
        statement.clearBatch();
    }

    public int[] executeBatch() throws SQLException {
        return statement.executeBatch();
    }

    public Connection getConnection() throws SQLException {
        return statement.getConnection();
    }

    public boolean getMoreResults(int current) throws SQLException {
        return statement.getMoreResults(current);
    }

    public ResultSet getGeneratedKeys() throws SQLException {
        return new HSResultSet(statement.getGeneratedKeys());
    }

    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        return statement.executeUpdate(sql, autoGeneratedKeys);
    }

    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        return statement.executeUpdate(sql, columnIndexes);
    }

    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        return statement.executeUpdate(sql, columnNames);
    }

    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        return statement.execute(sql, autoGeneratedKeys);
    }

    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        return statement.execute(sql, columnIndexes);
    }

    public boolean execute(String sql, String[] columnNames) throws SQLException {
        return statement.execute(sql, columnNames);
    }

    public int getResultSetHoldability() throws SQLException {
        return statement.getResultSetHoldability();
    }

    public boolean isClosed() throws SQLException {
        return statement.isClosed();
    }

    public void setPoolable(boolean poolable) throws SQLException {
        statement.setPoolable(poolable);
    }

    public boolean isPoolable() throws SQLException {
        return statement.isPoolable();
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return statement.unwrap(iface);
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return statement.isWrapperFor(iface);
    }
}
