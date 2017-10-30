package org.dddjava.experimental;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

public class ResultRow {
    private final ResultSet resultSet;

    public ResultRow(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public boolean wasNull() throws SQLException {
        return resultSet.wasNull();
    }

    public String getString(int columnIndex) throws SQLException {
        return resultSet.getString(columnIndex);
    }

    public boolean getBoolean(int columnIndex) throws SQLException {
        return resultSet.getBoolean(columnIndex);
    }

    public byte getByte(int columnIndex) throws SQLException {
        return resultSet.getByte(columnIndex);
    }

    public short getShort(int columnIndex) throws SQLException {
        return resultSet.getShort(columnIndex);
    }

    public int getInt(int columnIndex) throws SQLException {
        return resultSet.getInt(columnIndex);
    }

    public long getLong(int columnIndex) throws SQLException {
        return resultSet.getLong(columnIndex);
    }

    public float getFloat(int columnIndex) throws SQLException {
        return resultSet.getFloat(columnIndex);
    }

    public double getDouble(int columnIndex) throws SQLException {
        return resultSet.getDouble(columnIndex);
    }

    public byte[] getBytes(int columnIndex) throws SQLException {
        return resultSet.getBytes(columnIndex);
    }

    public Date getDate(int columnIndex) throws SQLException {
        return resultSet.getDate(columnIndex);
    }

    public Time getTime(int columnIndex) throws SQLException {
        return resultSet.getTime(columnIndex);
    }

    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        return resultSet.getTimestamp(columnIndex);
    }

    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        return resultSet.getAsciiStream(columnIndex);
    }

    public InputStream getBinaryStream(int columnIndex) throws SQLException {
        return resultSet.getBinaryStream(columnIndex);
    }

    public String getString(String columnLabel) throws SQLException {
        return resultSet.getString(columnLabel);
    }

    public boolean getBoolean(String columnLabel) throws SQLException {
        return resultSet.getBoolean(columnLabel);
    }

    public byte getByte(String columnLabel) throws SQLException {
        return resultSet.getByte(columnLabel);
    }

    public short getShort(String columnLabel) throws SQLException {
        return resultSet.getShort(columnLabel);
    }

    public int getInt(String columnLabel) throws SQLException {
        return resultSet.getInt(columnLabel);
    }

    public long getLong(String columnLabel) throws SQLException {
        return resultSet.getLong(columnLabel);
    }

    public float getFloat(String columnLabel) throws SQLException {
        return resultSet.getFloat(columnLabel);
    }

    public double getDouble(String columnLabel) throws SQLException {
        return resultSet.getDouble(columnLabel);
    }

    public byte[] getBytes(String columnLabel) throws SQLException {
        return resultSet.getBytes(columnLabel);
    }

    public Date getDate(String columnLabel) throws SQLException {
        return resultSet.getDate(columnLabel);
    }

    public Time getTime(String columnLabel) throws SQLException {
        return resultSet.getTime(columnLabel);
    }

    public Timestamp getTimestamp(String columnLabel) throws SQLException {
        return resultSet.getTimestamp(columnLabel);
    }

    public InputStream getAsciiStream(String columnLabel) throws SQLException {
        return resultSet.getAsciiStream(columnLabel);
    }

    public InputStream getBinaryStream(String columnLabel) throws SQLException {
        return resultSet.getBinaryStream(columnLabel);
    }

    public SQLWarning getWarnings() throws SQLException {
        return resultSet.getWarnings();
    }

    public void clearWarnings() throws SQLException {
        resultSet.clearWarnings();
    }

    public String getCursorName() throws SQLException {
        return resultSet.getCursorName();
    }

    public ResultSetMetaData getMetaData() throws SQLException {
        return resultSet.getMetaData();
    }

    public Object getObject(int columnIndex) throws SQLException {
        return resultSet.getObject(columnIndex);
    }

    public Object getObject(String columnLabel) throws SQLException {
        return resultSet.getObject(columnLabel);
    }

    public int findColumn(String columnLabel) throws SQLException {
        return resultSet.findColumn(columnLabel);
    }

    public Reader getCharacterStream(int columnIndex) throws SQLException {
        return resultSet.getCharacterStream(columnIndex);
    }

    public Reader getCharacterStream(String columnLabel) throws SQLException {
        return resultSet.getCharacterStream(columnLabel);
    }

    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        return resultSet.getBigDecimal(columnIndex);
    }

    public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
        return resultSet.getBigDecimal(columnLabel);
    }

    public boolean isBeforeFirst() throws SQLException {
        return resultSet.isBeforeFirst();
    }

    public boolean isAfterLast() throws SQLException {
        return resultSet.isAfterLast();
    }

    public boolean isFirst() throws SQLException {
        return resultSet.isFirst();
    }

    public boolean isLast() throws SQLException {
        return resultSet.isLast();
    }

    public int getRow() throws SQLException {
        return resultSet.getRow();
    }


    public int getFetchDirection() throws SQLException {
        return resultSet.getFetchDirection();
    }

    public int getFetchSize() throws SQLException {
        return resultSet.getFetchSize();
    }

    public int getType() throws SQLException {
        return resultSet.getType();
    }

    public int getConcurrency() throws SQLException {
        return resultSet.getConcurrency();
    }

    public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
        return resultSet.getObject(columnIndex, map);
    }

    public Ref getRef(int columnIndex) throws SQLException {
        return resultSet.getRef(columnIndex);
    }

    public Blob getBlob(int columnIndex) throws SQLException {
        return resultSet.getBlob(columnIndex);
    }

    public Clob getClob(int columnIndex) throws SQLException {
        return resultSet.getClob(columnIndex);
    }

    public Array getArray(int columnIndex) throws SQLException {
        return resultSet.getArray(columnIndex);
    }

    public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
        return resultSet.getObject(columnLabel, map);
    }

    public Ref getRef(String columnLabel) throws SQLException {
        return resultSet.getRef(columnLabel);
    }

    public Blob getBlob(String columnLabel) throws SQLException {
        return resultSet.getBlob(columnLabel);
    }

    public Clob getClob(String columnLabel) throws SQLException {
        return resultSet.getClob(columnLabel);
    }

    public Array getArray(String columnLabel) throws SQLException {
        return resultSet.getArray(columnLabel);
    }

    public Date getDate(int columnIndex, Calendar cal) throws SQLException {
        return resultSet.getDate(columnIndex, cal);
    }

    public Date getDate(String columnLabel, Calendar cal) throws SQLException {
        return resultSet.getDate(columnLabel, cal);
    }

    public Time getTime(int columnIndex, Calendar cal) throws SQLException {
        return resultSet.getTime(columnIndex, cal);
    }

    public Time getTime(String columnLabel, Calendar cal) throws SQLException {
        return resultSet.getTime(columnLabel, cal);
    }

    public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
        return resultSet.getTimestamp(columnIndex, cal);
    }

    public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
        return resultSet.getTimestamp(columnLabel, cal);
    }

    public URL getURL(int columnIndex) throws SQLException {
        return resultSet.getURL(columnIndex);
    }

    public URL getURL(String columnLabel) throws SQLException {
        return resultSet.getURL(columnLabel);
    }

    public void updateRef(int columnIndex, Ref x) throws SQLException {
        resultSet.updateRef(columnIndex, x);
    }

    public void updateRef(String columnLabel, Ref x) throws SQLException {
        resultSet.updateRef(columnLabel, x);
    }

    public void updateBlob(int columnIndex, Blob x) throws SQLException {
        resultSet.updateBlob(columnIndex, x);
    }

    public void updateBlob(String columnLabel, Blob x) throws SQLException {
        resultSet.updateBlob(columnLabel, x);
    }

    public void updateClob(int columnIndex, Clob x) throws SQLException {
        resultSet.updateClob(columnIndex, x);
    }

    public void updateClob(String columnLabel, Clob x) throws SQLException {
        resultSet.updateClob(columnLabel, x);
    }

    public void updateArray(int columnIndex, Array x) throws SQLException {
        resultSet.updateArray(columnIndex, x);
    }

    public void updateArray(String columnLabel, Array x) throws SQLException {
        resultSet.updateArray(columnLabel, x);
    }

    public RowId getRowId(int columnIndex) throws SQLException {
        return resultSet.getRowId(columnIndex);
    }

    public RowId getRowId(String columnLabel) throws SQLException {
        return resultSet.getRowId(columnLabel);
    }

    public void updateRowId(int columnIndex, RowId x) throws SQLException {
        resultSet.updateRowId(columnIndex, x);
    }

    public void updateRowId(String columnLabel, RowId x) throws SQLException {
        resultSet.updateRowId(columnLabel, x);
    }

    public int getHoldability() throws SQLException {
        return resultSet.getHoldability();
    }

    public boolean isClosed() throws SQLException {
        return resultSet.isClosed();
    }

    public void updateNString(int columnIndex, String nString) throws SQLException {
        resultSet.updateNString(columnIndex, nString);
    }

    public void updateNString(String columnLabel, String nString) throws SQLException {
        resultSet.updateNString(columnLabel, nString);
    }

    public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
        resultSet.updateNClob(columnIndex, nClob);
    }

    public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
        resultSet.updateNClob(columnLabel, nClob);
    }

    public NClob getNClob(int columnIndex) throws SQLException {
        return resultSet.getNClob(columnIndex);
    }

    public NClob getNClob(String columnLabel) throws SQLException {
        return resultSet.getNClob(columnLabel);
    }

    public SQLXML getSQLXML(int columnIndex) throws SQLException {
        return resultSet.getSQLXML(columnIndex);
    }

    public SQLXML getSQLXML(String columnLabel) throws SQLException {
        return resultSet.getSQLXML(columnLabel);
    }

    public String getNString(int columnIndex) throws SQLException {
        return resultSet.getNString(columnIndex);
    }

    public String getNString(String columnLabel) throws SQLException {
        return resultSet.getNString(columnLabel);
    }

    public Reader getNCharacterStream(int columnIndex) throws SQLException {
        return resultSet.getNCharacterStream(columnIndex);
    }

    public Reader getNCharacterStream(String columnLabel) throws SQLException {
        return resultSet.getNCharacterStream(columnLabel);
    }

}
