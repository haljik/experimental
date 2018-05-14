package org.dddjava.simple;

import static java.util.stream.Collectors.toList;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

public class TargetType<T> {
    final Class<T> value;

    public TargetType(Class<T> value) {
        this.value = value;
    }

    public TargetConstructor<T> determineConstructor() throws NoSuchMethodException {
        List<Constructor<T>> constructors = Arrays.stream((Constructor<T>[]) value.getConstructors())
                .filter(constructor -> constructor.getParameterCount() == 1)
                .collect(toList());
        if (constructors.size() == 0) {
            throw new NoSuchMethodException();
        }
        if (constructors.size() == 1) {
            return new TargetConstructor<>(constructors.get(0));
        }

        return constructors.stream()
                .filter(constructor -> constructor.);
    }

    public TargetConstructor<T> determineConstructor(Class<?>...argumentTypes) {
        try {
            return new TargetConstructor<>(value.getConstructor(argumentTypes));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
