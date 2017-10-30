package org.dddjava.experimental;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Database {
    final Connection connection;

    public Database(Connection connection) {
        this.connection = connection;
    }

    public Stream<ResultRow> query(String sql) {
        PreparedStatement preparedStatement = prepareStatement(sql);
        ResultSet resultSet = execute(preparedStatement);
        Stream<ResultRow> stream = null;
        try {
            ResultSetSpliterator resultSetSpliterator = new ResultSetSpliterator(resultSet);
            stream = StreamSupport.stream(resultSetSpliterator, false);
        } finally {
            if (stream != null) {
                stream.onClose(() -> {
                    try {
                        resultSet.close();
                        preparedStatement.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        }

        return stream;
    }

    private PreparedStatement prepareStatement(String sql) {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ResultSet execute(PreparedStatement preparedStatement) {
        try {
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
