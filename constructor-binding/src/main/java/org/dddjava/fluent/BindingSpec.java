package org.dddjava.fluent;

public interface BindingSpec<FROM_TYPE, TO_TYPE> {
    BindingResult<TO_TYPE> bind(FROM_TYPE source);
}
