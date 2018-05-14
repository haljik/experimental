package org.dddjava.simple;

import static java.util.stream.Collectors.toList;

import java.util.List;

public class Results {
    private final List<Result> values;

    public Results(List<Result> values) {
        this.values = values;
    }

    public Class<?>[] types() {
        return values.stream()
                .map(Result::type)
                .map(targetType -> targetType.value)
                .toArray(Class<?>[]::new);
    }


    public ArgumentResolvers argumentResolvers() {
        return new ArgumentResolvers(
            values.stream()
                .map(Result::asArgumentResolver)
                .collect(toList())
        );
    }

    public ArgumentResolvers argumentResolvers(String expression) {
        return new ArgumentResolvers(
                values.stream()
                        .map(result -> result.asArgumentResolverWith(expression))
                        .collect(toList())
        );
    }
}
