package org.dddjava.simple;

import java.util.Collection;
import java.util.function.Function;

public class CompositeCollection<ELEMENT, TARGET> {
    private final String expression;
    private final Function<? extends Collection<ELEMENT>, TARGET> mapper;
    private final Node[] nodes;

    public CompositeCollection(String expression,
                               Function<? extends Collection<ELEMENT>, TARGET> mapper,
                               Node...nodes) {
        this.expression = expression;
        this.mapper = mapper;
        this.nodes = nodes;
    }
}
