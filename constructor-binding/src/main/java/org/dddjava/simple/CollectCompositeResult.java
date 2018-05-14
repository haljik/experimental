package org.dddjava.simple;

import org.dddjava.Source;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class CollectCompositeResult<ELEMENT, COLLECTION> implements Result {
    final CompositeResult<ELEMENT> element;
    final TargetType<COLLECTION> targetType;
    final Constructor<COLLECTION> constructor;
    final String expressionPattern;

    public CollectCompositeResult(CompositeResult<ELEMENT> element, TargetType<COLLECTION> targetType, Constructor<COLLECTION> constructor, String expressionPattern) {
        this.element = element;
        this.targetType = targetType;
        this.constructor = constructor;
        this.expressionPattern = expressionPattern;
    }

    @Override
    public TargetType<?> type() {
        return targetType;
    }

    @Override
    public ArgumentResolver asArgumentResolver() {
        return this::resolveArgument;
    }


    @Override
    public ArgumentResolver asArgumentResolverWith(String expression) {
        return source -> resolveArgument(source.withContextExpression(expression));

    }

    private Object resolveArgument(Source source) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        String[] matchedExpressions = source.matchedExpressions(expressionPattern);
        Object[] objects = Arrays.stream(matchedExpressions)
                .map(element::asArgumentResolverWith)
                .map(resolver -> {
                    try {
                        return resolver.resolve(source);
                    } catch (InstantiationException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        //TODO: エラー蓄積の仕組み
                        throw new RuntimeException(e);
                    }
                })
                .toArray();
        return constructor.newInstance(objects);
    }
}
