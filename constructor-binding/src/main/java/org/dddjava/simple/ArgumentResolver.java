package org.dddjava.simple;

import org.dddjava.Source;

import java.lang.reflect.InvocationTargetException;

public interface ArgumentResolver {
    Object resolve(Source source) throws InstantiationException, IllegalAccessException, InvocationTargetException;
}
