package org.dddjava.experimental;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;
import java.util.stream.Stream;

class DatabaseTest {

    Connection connection;

    @BeforeEach
    void beforeEach() throws SQLException {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:test;MODE=PostgreSQL");
        dataSource.setUser("sa");
        dataSource.setPassword("password");
        connection = dataSource.getConnection();
        execute("CREATE SCHEMA test");
        execute("CREATE TABLE test.test_users(name VARCHAR(100) PRIMARY KEY)");
        execute("INSERT INTO test.test_users(name) VALUES('taro')");
        execute("INSERT INTO test.test_users(name) VALUES('jiro')");
        execute("INSERT INTO test.test_users(name) VALUES('saburo')");
    }

    private void execute(String sql) throws SQLException {
        PreparedStatement test = connection.prepareStatement(sql);
        test.execute();
        test.close();
    }

    @Test
    void testResultSetStream() throws SQLException {

        Database jdbcStreamer = new Database(connection);
        try (Stream<ResultRow> stream = jdbcStreamer.query("SELECT * FROM test.test_users")) {
            Set<String> names = stream.map(row -> {
                try {
                    return row.getString("name");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }).collect(toSet());

            assertAll(
                    () -> assertTrue(names.size() == 3),
                    () -> assertTrue(names.contains("taro")),
                    () -> assertTrue(names.contains("jiro")),
                    () -> assertTrue(names.contains("saburo"))
            );
        }
    }


}
