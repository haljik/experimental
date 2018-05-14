package org.dddjava.simple;

import java.util.function.Function;

public class SingleCollection<ORIGINAL, ELEMENT, TARGET> implements Node {

    private final String expression;
    private final Class<ORIGINAL> originlType;
    private final Class<ELEMENT> elementType;
    private final Function<ELEMENT[], TARGET> finisher;

    public SingleCollection(String expression, Class<ORIGINAL> originlType, Class<ELEMENT> elementType, Function<ELEMENT[], TARGET> finisher) {
        this.expression = expression;
        this.originlType = originlType;
        this.elementType = elementType;
        this.finisher = finisher;
    }

    @Override
    public Result analyze() {
        return null;
    }
}
