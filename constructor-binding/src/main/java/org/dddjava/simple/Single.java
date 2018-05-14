package org.dddjava.simple;

import java.lang.reflect.Constructor;

public class Single<TARGET> implements Node {
    private final String expression;
    private final TargetType<TARGET> targetType;

    public Single(String expression, Class<TARGET> targetType) {
        this.expression = expression;
        this.targetType = new TargetType<>(targetType);
    }


    @Override
    public Result analyze() {
        Constructor<TARGET> constructor = targetType.determineConstructor();
        return new SingleResult<>(
                originalType,
                targetType,
                constructor,
                expression
        );
    }
}
