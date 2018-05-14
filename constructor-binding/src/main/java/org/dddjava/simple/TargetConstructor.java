package org.dddjava.simple;

import java.lang.reflect.Constructor;

public class TargetConstructor<TARGETTYPE> {
    final Constructor<TARGETTYPE> constructor;

    TargetConstructor(Constructor<TARGETTYPE> constructor) {
        this.constructor = constructor;
    }
}
