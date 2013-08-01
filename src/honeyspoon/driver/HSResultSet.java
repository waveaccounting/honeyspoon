package honeyspoon.driver;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

public class HSResultSet implements ResultSet {
    private ResultSet resultset;

    public HSResultSet(ResultSet resultset) {
        this.resultset = resultset;
    }

    public boolean next() throws SQLException {
        return resultset.next();
    }

    public void close() throws SQLException {
        resultset.close();
    }

    public boolean wasNull() throws SQLException {
        return resultset.wasNull();
    }

    public String getString(int columnIndex) throws SQLException {
        return resultset.getString(columnIndex);
    }

    public boolean getBoolean(int columnIndex) throws SQLException {
        return resultset.getBoolean(columnIndex);
    }

    public byte getByte(int columnIndex) throws SQLException {
        return resultset.getByte(columnIndex);
    }

    public short getShort(int columnIndex) throws SQLException {
        return resultset.getShort(columnIndex);
    }

    public int getInt(int columnIndex) throws SQLException {
        return resultset.getInt(columnIndex);
    }

    public long getLong(int columnIndex) throws SQLException {
        return resultset.getLong(columnIndex);
    }

    public float getFloat(int columnIndex) throws SQLException {
        return resultset.getFloat(columnIndex);
    }

    public double getDouble(int columnIndex) throws SQLException {
        return resultset.getDouble(columnIndex);
    }

    public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
        return resultset.getBigDecimal(columnIndex, scale);
    }

    public byte[] getBytes(int columnIndex) throws SQLException {
        return resultset.getBytes(columnIndex);
    }

    public Date getDate(int columnIndex) throws SQLException {
        return resultset.getDate(columnIndex);
    }

    public Time getTime(int columnIndex) throws SQLException {
        return resultset.getTime(columnIndex);
    }

    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        return resultset.getTimestamp(columnIndex);
    }

    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        return resultset.getAsciiStream(columnIndex);
    }

    public InputStream getUnicodeStream(int columnIndex) throws SQLException {
        return resultset.getUnicodeStream(columnIndex);
    }

    public InputStream getBinaryStream(int columnIndex) throws SQLException {
        return resultset.getBinaryStream(columnIndex);
    }

    public String getString(String columnLabel) throws SQLException {
        return resultset.getString(columnLabel);
    }

    public boolean getBoolean(String columnLabel) throws SQLException {
        return resultset.getBoolean(columnLabel);
    }

    public byte getByte(String columnLabel) throws SQLException {
        return resultset.getByte(columnLabel);
    }

    public short getShort(String columnLabel) throws SQLException {
        return resultset.getShort(columnLabel);
    }

    public int getInt(String columnLabel) throws SQLException {
        return resultset.getInt(columnLabel);
    }

    public long getLong(String columnLabel) throws SQLException {
        return resultset.getLong(columnLabel);
    }

    public float getFloat(String columnLabel) throws SQLException {
        return resultset.getFloat(columnLabel);
    }

    public double getDouble(String columnLabel) throws SQLException {
        return resultset.getDouble(columnLabel);
    }

    public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
        return resultset.getBigDecimal(columnLabel, scale);
    }

    public byte[] getBytes(String columnLabel) throws SQLException {
        return resultset.getBytes(columnLabel);
    }

    public Date getDate(String columnLabel) throws SQLException {
        return resultset.getDate(columnLabel);
    }

    public Time getTime(String columnLabel) throws SQLException {
        return resultset.getTime(columnLabel);
    }

    public Timestamp getTimestamp(String columnLabel) throws SQLException {
        return resultset.getTimestamp(columnLabel);
    }

    public InputStream getAsciiStream(String columnLabel) throws SQLException {
        return resultset.getAsciiStream(columnLabel);
    }

    public InputStream getUnicodeStream(String columnLabel) throws SQLException {
        return resultset.getUnicodeStream(columnLabel);
    }

    public InputStream getBinaryStream(String columnLabel) throws SQLException {
        return resultset.getBinaryStream(columnLabel);
    }

    public SQLWarning getWarnings() throws SQLException {
        return resultset.getWarnings();
    }

    public void clearWarnings() throws SQLException {
        resultset.clearWarnings();
    }

    public String getCursorName() throws SQLException {
        return resultset.getCursorName();
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        return new HSResultSetMetaData(resultset.getMetaData());
    }

    public Object getObject(int columnIndex) throws SQLException {
        return resultset.getObject(columnIndex);
    }

    public Object getObject(String columnLabel) throws SQLException {
        return resultset.getObject(columnLabel);
    }

    public int findColumn(String columnLabel) throws SQLException {
        return resultset.findColumn(columnLabel);
    }

    public Reader getCharacterStream(int columnIndex) throws SQLException {
        return resultset.getCharacterStream(columnIndex);
    }

    public Reader getCharacterStream(String columnLabel) throws SQLException {
        return resultset.getCharacterStream(columnLabel);
    }

    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        return resultset.getBigDecimal(columnIndex);
    }

    public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
        return resultset.getBigDecimal(columnLabel);
    }

    public boolean isBeforeFirst() throws SQLException {
        return resultset.isBeforeFirst();
    }

    public boolean isAfterLast() throws SQLException {
        return resultset.isAfterLast();
    }

    public boolean isFirst() throws SQLException {
        return resultset.isFirst();
    }

    public boolean isLast() throws SQLException {
        return resultset.isLast();
    }

    public void beforeFirst() throws SQLException {
        resultset.beforeFirst();
    }

    public void afterLast() throws SQLException {
        resultset.afterLast();
    }

    public boolean first() throws SQLException {
        return resultset.first();
    }

    public boolean last() throws SQLException {
        return resultset.last();
    }

    public int getRow() throws SQLException {
        return resultset.getRow();
    }

    public boolean absolute(int row) throws SQLException {
        return resultset.absolute(row);
    }

    public boolean relative(int rows) throws SQLException {
        return resultset.relative(rows);
    }

    public boolean previous() throws SQLException {
        return resultset.previous();
    }

    public void setFetchDirection(int direction) throws SQLException {
        resultset.setFetchDirection(direction);
    }

    public int getFetchDirection() throws SQLException {
        return resultset.getFetchDirection();
    }

    public void setFetchSize(int rows) throws SQLException {
        resultset.setFetchSize(rows);
    }

    public int getFetchSize() throws SQLException {
        return resultset.getFetchSize();
    }

    public int getType() throws SQLException {
        return resultset.getType();
    }

    public int getConcurrency() throws SQLException {
        return resultset.getConcurrency();
    }

    public boolean rowUpdated() throws SQLException {
        return resultset.rowUpdated();
    }

    public boolean rowInserted() throws SQLException {
        return resultset.rowInserted();
    }

    public boolean rowDeleted() throws SQLException {
        return resultset.rowDeleted();
    }

    public void updateNull(int columnIndex) throws SQLException {
        resultset.updateNull(columnIndex);
    }

    public void updateBoolean(int columnIndex, boolean x) throws SQLException {
        resultset.updateBoolean(columnIndex, x);
    }

    public void updateByte(int columnIndex, byte x) throws SQLException {
        resultset.updateByte(columnIndex, x);
    }

    public void updateShort(int columnIndex, short x) throws SQLException {
        resultset.updateShort(columnIndex, x);
    }

    public void updateInt(int columnIndex, int x) throws SQLException {
        resultset.updateInt(columnIndex, x);
    }

    public void updateLong(int columnIndex, long x) throws SQLException {
        resultset.updateLong(columnIndex, x);
    }

    public void updateFloat(int columnIndex, float x) throws SQLException {
        resultset.updateFloat(columnIndex, x);
    }

    public void updateDouble(int columnIndex, double x) throws SQLException {
        resultset.updateDouble(columnIndex, x);
    }

    public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
        resultset.updateBigDecimal(columnIndex, x);
    }

    public void updateString(int columnIndex, String x) throws SQLException {
        resultset.updateString(columnIndex, x);
    }

    public void updateBytes(int columnIndex, byte[] x) throws SQLException {
        resultset.updateBytes(columnIndex, x);
    }

    public void updateDate(int columnIndex, Date x) throws SQLException {
        resultset.updateDate(columnIndex, x);
    }

    public void updateTime(int columnIndex, Time x) throws SQLException {
        resultset.updateTime(columnIndex, x);
    }

    public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
        resultset.updateTimestamp(columnIndex, x);
    }

    public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
        resultset.updateAsciiStream(columnIndex, x, length);
    }

    public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
        resultset.updateBinaryStream(columnIndex, x, length);
    }

    public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
        resultset.updateCharacterStream(columnIndex, x, length);
    }

    public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
        resultset.updateObject(columnIndex, x, scaleOrLength);
    }

    public void updateObject(int columnIndex, Object x) throws SQLException {
        resultset.updateObject(columnIndex, x);
    }

    public void updateNull(String columnLabel) throws SQLException {
        resultset.updateNull(columnLabel);
    }

    public void updateBoolean(String columnLabel, boolean x) throws SQLException {
        resultset.updateBoolean(columnLabel, x);
    }

    public void updateByte(String columnLabel, byte x) throws SQLException {
        resultset.updateByte(columnLabel, x);
    }

    public void updateShort(String columnLabel, short x) throws SQLException {
        resultset.updateShort(columnLabel, x);
    }

    public void updateInt(String columnLabel, int x) throws SQLException {
        resultset.updateInt(columnLabel, x);
    }

    public void updateLong(String columnLabel, long x) throws SQLException {
        resultset.updateLong(columnLabel, x);
    }

    public void updateFloat(String columnLabel, float x) throws SQLException {
        resultset.updateFloat(columnLabel, x);
    }

    public void updateDouble(String columnLabel, double x) throws SQLException {
        resultset.updateDouble(columnLabel, x);
    }

    public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
        resultset.updateBigDecimal(columnLabel, x);
    }

    public void updateString(String columnLabel, String x) throws SQLException {
        resultset.updateString(columnLabel, x);
    }

    public void updateBytes(String columnLabel, byte[] x) throws SQLException {
        resultset.updateBytes(columnLabel, x);
    }

    public void updateDate(String columnLabel, Date x) throws SQLException {
        resultset.updateDate(columnLabel, x);
    }

    public void updateTime(String columnLabel, Time x) throws SQLException {
        resultset.updateTime(columnLabel, x);
    }

    public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
        resultset.updateTimestamp(columnLabel, x);
    }

    public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
        resultset.updateAsciiStream(columnLabel, x, length);
    }

    public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
        resultset.updateBinaryStream(columnLabel, x, length);
    }

    public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
        resultset.updateCharacterStream(columnLabel, reader, length);
    }

    public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
        resultset.updateObject(columnLabel, x, scaleOrLength);
    }

    public void updateObject(String columnLabel, Object x) throws SQLException {
        resultset.updateObject(columnLabel, x);
    }

    public void insertRow() throws SQLException {
        resultset.insertRow();
    }

    public void updateRow() throws SQLException {
        resultset.updateRow();
    }

    public void deleteRow() throws SQLException {
        resultset.deleteRow();
    }

    public void refreshRow() throws SQLException {
        resultset.refreshRow();
    }

    public void cancelRowUpdates() throws SQLException {
        resultset.cancelRowUpdates();
    }

    public void moveToInsertRow() throws SQLException {
        resultset.moveToInsertRow();
    }

    public void moveToCurrentRow() throws SQLException {
        resultset.moveToCurrentRow();
    }

    public Statement getStatement() throws SQLException {
        return resultset.getStatement();
    }

    public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
        return resultset.getObject(columnIndex, map);
    }

    public Ref getRef(int columnIndex) throws SQLException {
        return resultset.getRef(columnIndex);
    }

    public Blob getBlob(int columnIndex) throws SQLException {
        return resultset.getBlob(columnIndex);
    }

    public Clob getClob(int columnIndex) throws SQLException {
        return resultset.getClob(columnIndex);
    }

    public Array getArray(int columnIndex) throws SQLException {
        return resultset.getArray(columnIndex);
    }

    public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
        return resultset.getObject(columnLabel, map);
    }

    public Ref getRef(String columnLabel) throws SQLException {
        return resultset.getRef(columnLabel);
    }

    public Blob getBlob(String columnLabel) throws SQLException {
        return resultset.getBlob(columnLabel);
    }

    public Clob getClob(String columnLabel) throws SQLException {
        return resultset.getClob(columnLabel);
    }

    public Array getArray(String columnLabel) throws SQLException {
        return resultset.getArray(columnLabel);
    }

    public Date getDate(int columnIndex, Calendar cal) throws SQLException {
        return resultset.getDate(columnIndex, cal);
    }

    public Date getDate(String columnLabel, Calendar cal) throws SQLException {
        return resultset.getDate(columnLabel, cal);
    }

    public Time getTime(int columnIndex, Calendar cal) throws SQLException {
        return resultset.getTime(columnIndex, cal);
    }

    public Time getTime(String columnLabel, Calendar cal) throws SQLException {
        return resultset.getTime(columnLabel, cal);
    }

    public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
        return resultset.getTimestamp(columnIndex, cal);
    }

    public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
        return resultset.getTimestamp(columnLabel, cal);
    }

    public URL getURL(int columnIndex) throws SQLException {
        return resultset.getURL(columnIndex);
    }

    public URL getURL(String columnLabel) throws SQLException {
        return resultset.getURL(columnLabel);
    }

    public void updateRef(int columnIndex, Ref x) throws SQLException {
        resultset.updateRef(columnIndex, x);
    }

    public void updateRef(String columnLabel, Ref x) throws SQLException {
        resultset.updateRef(columnLabel, x);
    }

    public void updateBlob(int columnIndex, Blob x) throws SQLException {
        resultset.updateBlob(columnIndex, x);
    }

    public void updateBlob(String columnLabel, Blob x) throws SQLException {
        resultset.updateBlob(columnLabel, x);
    }

    public void updateClob(int columnIndex, Clob x) throws SQLException {
        resultset.updateClob(columnIndex, x);
    }

    public void updateClob(String columnLabel, Clob x) throws SQLException {
        resultset.updateClob(columnLabel, x);
    }

    public void updateArray(int columnIndex, Array x) throws SQLException {
        resultset.updateArray(columnIndex, x);
    }

    public void updateArray(String columnLabel, Array x) throws SQLException {
        resultset.updateArray(columnLabel, x);
    }

    public RowId getRowId(int columnIndex) throws SQLException {
        return resultset.getRowId(columnIndex);
    }

    public RowId getRowId(String columnLabel) throws SQLException {
        return resultset.getRowId(columnLabel);
    }

    public void updateRowId(int columnIndex, RowId x) throws SQLException {
        resultset.updateRowId(columnIndex, x);
    }

    public void updateRowId(String columnLabel, RowId x) throws SQLException {
        resultset.updateRowId(columnLabel, x);
    }

    public int getHoldability() throws SQLException {
        return resultset.getHoldability();
    }

    public boolean isClosed() throws SQLException {
        return resultset.isClosed();
    }

    public void updateNString(int columnIndex, String nString) throws SQLException {
        resultset.updateNString(columnIndex, nString);
    }

    public void updateNString(String columnLabel, String nString) throws SQLException {
        resultset.updateNString(columnLabel, nString);
    }

    public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
        resultset.updateNClob(columnIndex, nClob);
    }

    public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
        resultset.updateNClob(columnLabel, nClob);
    }

    public NClob getNClob(int columnIndex) throws SQLException {
        return resultset.getNClob(columnIndex);
    }

    public NClob getNClob(String columnLabel) throws SQLException {
        return resultset.getNClob(columnLabel);
    }

    public SQLXML getSQLXML(int columnIndex) throws SQLException {
        return resultset.getSQLXML(columnIndex);
    }

    public SQLXML getSQLXML(String columnLabel) throws SQLException {
        return resultset.getSQLXML(columnLabel);
    }

    public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
        resultset.updateSQLXML(columnIndex, xmlObject);
    }

    public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
        resultset.updateSQLXML(columnLabel, xmlObject);
    }

    public String getNString(int columnIndex) throws SQLException {
        return resultset.getNString(columnIndex);
    }

    public String getNString(String columnLabel) throws SQLException {
        return resultset.getNString(columnLabel);
    }

    public Reader getNCharacterStream(int columnIndex) throws SQLException {
        return resultset.getNCharacterStream(columnIndex);
    }

    public Reader getNCharacterStream(String columnLabel) throws SQLException {
        return resultset.getNCharacterStream(columnLabel);
    }

    public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        resultset.updateNCharacterStream(columnIndex, x, length);
    }

    public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        resultset.updateNCharacterStream(columnLabel, reader, length);
    }

    public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
        resultset.updateAsciiStream(columnIndex, x, length);
    }

    public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
        resultset.updateBinaryStream(columnIndex, x, length);
    }

    public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        resultset.updateCharacterStream(columnIndex, x, length);
    }

    public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
        resultset.updateAsciiStream(columnLabel, x, length);
    }

    public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
        resultset.updateBinaryStream(columnLabel, x, length);
    }

    public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        resultset.updateCharacterStream(columnLabel, reader, length);
    }

    public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
        resultset.updateBlob(columnIndex, inputStream, length);
    }

    public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
        resultset.updateBlob(columnLabel, inputStream, length);
    }

    public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
        resultset.updateClob(columnIndex, reader, length);
    }

    public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
        resultset.updateClob(columnLabel, reader, length);
    }

    public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
        resultset.updateNClob(columnIndex, reader, length);
    }

    public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
        resultset.updateNClob(columnLabel, reader, length);
    }

    public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
        resultset.updateNCharacterStream(columnIndex, x);
    }

    public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
        resultset.updateNCharacterStream(columnLabel, reader);
    }

    public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
        resultset.updateAsciiStream(columnIndex, x);
    }

    public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
        resultset.updateBinaryStream(columnIndex, x);
    }

    public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
        resultset.updateCharacterStream(columnIndex, x);
    }

    public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
        resultset.updateAsciiStream(columnLabel, x);
    }

    public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
        resultset.updateBinaryStream(columnLabel, x);
    }

    public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
        resultset.updateCharacterStream(columnLabel, reader);
    }

    public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
        resultset.updateBlob(columnIndex, inputStream);
    }

    public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
        resultset.updateBlob(columnLabel, inputStream);
    }

    public void updateClob(int columnIndex, Reader reader) throws SQLException {
        resultset.updateClob(columnIndex, reader);
    }

    public void updateClob(String columnLabel, Reader reader) throws SQLException {
        resultset.updateClob(columnLabel, reader);
    }

    public void updateNClob(int columnIndex, Reader reader) throws SQLException {
        resultset.updateNClob(columnIndex, reader);
    }

    public void updateNClob(String columnLabel, Reader reader) throws SQLException {
        resultset.updateNClob(columnLabel, reader);
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return resultset.unwrap(iface);
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return resultset.isWrapperFor(iface);
    }
}
