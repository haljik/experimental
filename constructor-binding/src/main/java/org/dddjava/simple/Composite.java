package org.dddjava.simple;


import java.lang.reflect.Constructor;

public class Composite<T> implements Node {
    private final TargetType<T> type;
    private final Nodes nodes;

    public Composite(Class<T> type, Node...nodes) {
        this.type = new TargetType<>(type);
        this.nodes = new Nodes(nodes);
    }

    @Override
    public CompositeResult<T> analyze() {
        Results results = nodes.analyze();
        Constructor<T> constructor = type.determineConstructor(results);
        return new CompositeResult<>(type, constructor, results.argumentResolvers());
    }
}
