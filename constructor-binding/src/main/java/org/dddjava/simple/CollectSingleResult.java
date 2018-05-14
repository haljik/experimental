package org.dddjava.simple;

import org.dddjava.Source;

import java.lang.reflect.Constructor;
import java.util.List;

public class CollectSingleResult<ELEMENT,COLLECTION> implements Result {

    final Result element;
    final TargetType<COLLECTION> type;
    final Constructor<COLLECTION> constructor;
    final String expression;

    public CollectSingleResult(Result element,
                               TargetType<COLLECTION> type,
                               Constructor<COLLECTION> constructor,
                               String expression) {
        this.element = element;
        this.type = type;
        this.constructor = constructor;
        this.expression = expression;
    }

    @Override
    public TargetType<COLLECTION> type() {
        return type;
    }

    @Override
    public ArgumentResolver asArgumentResolver() {
        return source -> {
            String[] strings = source.matchedExpressions(expression);
            ArgumentResolver argumentResolver = element.asArgumentResolverWith(expression);
            Object resolve = argumentResolver.resolve(source);
            return constructor.newInstance(resolve);
        };
    }

    @Override
    public ArgumentResolver asArgumentResolverWith(String expression) {
        return source -> {
            Source withContext = source.withContextExpression(expression);
            List<?> elements = withContext.listOf(element.type().value, this.expression);
            return constructor.newInstance(elements);
        };
    }
}
