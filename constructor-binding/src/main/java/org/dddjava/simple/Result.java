package org.dddjava.simple;

public interface Result {

    TargetType<?> type();

    ArgumentResolver asArgumentResolver();
}
