package org.dddjava.simple;

import org.dddjava.Source;
import org.dddjava.model.user.*;
import org.dddjava.model.user.job.CompanyName;
import org.dddjava.model.user.job.JobHistories;
import org.dddjava.model.user.job.JobHistory;
import org.dddjava.model.user.job.PositionName;
import org.junit.jupiter.api.Test;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;


public class BindingSpecTest {

    @Test
    void objectStructureEdition() {
        Root<User> root = new Root<>(User.class,
                new Composite<>(Profile.class,
                        new Single<>("profile.mailAddress", MailAddress.class),
                        new Single<>("profile.name", Name.class)
                ),
                new Single<>("point", Point.class),
                new SingleCollection<>(
                        "favoriteFlutes", FavoriteFlutes.class, FavoriteFlute.class
                ),
                new CompositeCollection<>(
                        "jobHistories.values[*]", JobHistories.class, JobHistory.class,
                        new Single<>("companyName", CompanyName.class),
                        new Single<>("positionName", PositionName.class)
                )
        );

        RootResult<User> analyzed = root.analyze();

        analyzed.buildFrom(new DummySource(""));
    }

    public static class DummySource implements Source {

        final String baseExpression;

        public DummySource(String baseExpression) {
            this.baseExpression = baseExpression;
        }

        @Override
        public Source withContextExpression(String expression) {
            return new DummySource(expression);
        }

        @Override
        public <T> T find(Class<T> originalType, String expression) {
            if (String.class.isAssignableFrom(originalType)) {
                return originalType.cast("value of " + expression);
            }

            if (Long.class.isAssignableFrom(originalType)) {
                return originalType.cast(Long.valueOf(0));
            }

            throw new IllegalArgumentException();
        }

        @Override
        public <T> List<T> listOf(Class<T> elementType, String expression) {
            return IntStream.range(0, 10)
                    .mapToObj(i -> {
                        if (String.class.isAssignableFrom(elementType)) {
                            return elementType.cast("value of " + expression);
                        }

                        if (Long.class.isAssignableFrom(elementType)) {
                            return elementType.cast(Long.valueOf(0));
                        }
                        System.out.println(elementType);
                        throw new IllegalArgumentException();
                    })
                    .collect(toList());
        }

        @Override
        public String[] matchedExpressions(String expressionPattern) {
            return new String[0];
        }
    }

}
