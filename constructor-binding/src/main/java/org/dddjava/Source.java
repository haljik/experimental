package org.dddjava;

import java.util.List;

public interface Source {
    Source withContextExpression(String expression);

    <T> T find(Class<T> originalType, String expression);

    <T> List<T> listOf(Class<T> elementType, String expression);

    String[] matchedExpressions(String expressionPattern);
}
