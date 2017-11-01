package org.dddjava.fluent;

import java.util.function.Function;

public interface BindingSpecBuilder<FROM> {

    <TO> BindingSpec<FROM, TO> specify(Class<TO> targetType, Function<ChildrenSpecBuilder, ChildrenSpec> childrenSpecifier);
}
