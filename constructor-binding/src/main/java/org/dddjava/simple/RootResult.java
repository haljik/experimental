package org.dddjava.simple;

import org.dddjava.Source;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RootResult<T> {

    final TargetType<T> targetType;
    final Constructor<T> constructor;
    final ArgumentResolvers argumentResolvers;

    public RootResult(TargetType<T> targetType, Constructor<T> constructor, ArgumentResolvers argumentResolvers) {
        this.targetType = targetType;
        this.constructor = constructor;
        this.argumentResolvers = argumentResolvers;
    }


    public T buildFrom(Source source) {
        Object[] resolved = argumentResolvers.resolve(source);
        try {
            return constructor.newInstance(resolved);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            //TODO: なんらかのエラー蓄積
            throw new RuntimeException(e);
        }
    }
}
