package org.dddjava.simple;

import java.lang.reflect.Constructor;

public class CollectSingle<ORIGINAL, ELEMENT, TARGET> implements Node {
    private final String expression;
    private Single<ORIGINAL, ELEMENT> single;
    private final TargetType<TARGET> targetType;

    public CollectSingle(String expression, Single<ORIGINAL, ELEMENT> single, Class<TARGET> targetType) {
        this.expression = expression;
        this.single = single;
        this.targetType = new TargetType<>(targetType);
    }

    @Override
    public Result analyze() {
        Result element = single.analyze();
        Constructor<TARGET> targetConstructor = targetType.determineListConstructor();
        return new CollectSingleResult<>(element, targetType,  targetConstructor, expression);
    }
}
