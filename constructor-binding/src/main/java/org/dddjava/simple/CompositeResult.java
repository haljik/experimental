package org.dddjava.simple;

import java.lang.reflect.Constructor;

public class CompositeResult<T> implements Result {
    final TargetType<T> type;
    final Constructor<T> constructor;
    final ArgumentResolvers argumentResolvers;

    public CompositeResult(TargetType<T> type, Constructor<T> constructor, ArgumentResolvers argumentResolvers) {
        this.type = type;
        this.constructor = constructor;
        this.argumentResolvers = argumentResolvers;
    }

    @Override
    public TargetType<T> type() {
        return type;
    }

    public ArgumentResolver asArgumentResolver() {
        return source -> constructor.newInstance(argumentResolvers.resolve(source));
    }
}
