package org.dddjava.fluent;

import java.util.function.Function;

public class HttpRequestBindingSpecBuilder implements BindingSpecBuilder<HttpServletRequest> {

    @Override
    public <TO> BindingSpec<HttpServletRequest, TO> specify(Class<TO> targetType, Function<ChildrenSpecBuilder, ChildrenSpec> childrenSpecifier) {
        return null;
    }
}
