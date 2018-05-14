package org.dddjava.simple;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;

public class Nodes {
    private Node[] nodes;

    public Nodes(Node[] nodes) {
        this.nodes = nodes;
    }


    public Results analyze() {
        return new Results(
                Arrays.stream(nodes)
                        .map(Node::analyze)
                        .collect(toList())
        );
    }
}
