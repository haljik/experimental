package org.dddjava.simple;

import java.lang.reflect.Constructor;

public class Root<T> {
    final TargetType<T> type;
    final Nodes children;

    public Root(Class<T> type, Node... nodes) {
        this.type = new TargetType<>(type);
        this.children = new Nodes(nodes);
    }

    public RootResult<T> analyze() {
        Results results = this.children.analyze();
        Constructor<T> constructor = type.determineConstructor(results);
        ArgumentResolvers argumentResolvers = results.argumentResolvers();
        return new RootResult<>(type, constructor, argumentResolvers);
    }
}
