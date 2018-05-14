package org.dddjava.simple;

import java.lang.reflect.Constructor;

public class SingleResult<T, R> implements Result {
    final Class<T> originalType;
    final TargetType<R> type;
    final Constructor<R> constructor;
    final String expression;

    public SingleResult(Class<T> originalType, TargetType<R> type, Constructor<R> constructor, String expression) {
        this.originalType = originalType;
        this.type = type;
        this.constructor = constructor;
        this.expression = expression;
    }

    @Override
    public TargetType<R> type() {
        return type;
    }

    @Override
    public ArgumentResolver asArgumentResolver() {
        return source -> constructor.newInstance(source.find(originalType, expression));
    }

    @Override
    public ArgumentResolver asArgumentResolverWith(String parentExpression) {
        return source -> constructor.newInstance(source.find(originalType, parentExpression + "." + this.expression));
    }
}
