package org.dddjava.simple;

import java.lang.reflect.Constructor;

public class CollectComposite<ELEMENT, COLLECTION> implements Node {
    private final String expression;
    private final Composite<ELEMENT> composite;
    private TargetType<COLLECTION> targetType;

    public CollectComposite(String expression, Composite<ELEMENT> composite, Class<COLLECTION> targetType) {
        this.expression = expression;
        this.composite = composite;
        this.targetType = new TargetType<>(targetType);
    }

    @Override
    public Result analyze() {
        CompositeResult<ELEMENT> element = composite.analyze();
        Constructor<COLLECTION> constructor = targetType.determineListConstructor();

        return new CollectCompositeResult<> (
                element,
                targetType,
                constructor,
                expression
        );
    }
}
