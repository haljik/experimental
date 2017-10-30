package org.dddjava.experimental;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

public class ResultSetSpliterator extends Spliterators.AbstractSpliterator<ResultRow> {
    final ResultSet resultSet;

    public ResultSetSpliterator(ResultSet resultSet) {
        super(Long.MAX_VALUE, Spliterator.CONCURRENT & Spliterator.IMMUTABLE & Spliterator.ORDERED);
        try {
            if (resultSet.isClosed()) throw new IllegalStateException("result set is closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.resultSet = resultSet;
    }


    @Override
    public boolean tryAdvance(Consumer<? super ResultRow> action) {
        try {
            if (!resultSet.next()) {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        action.accept(new ResultRow(resultSet));
        return true;
    }


}
