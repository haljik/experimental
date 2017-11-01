package org.dddjava.fluent;

import java.util.function.Function;

public interface ChildrenSpecBuilder {

    <TO> ChildrenSpecBuilder mapping(String name, Class<TO> type, Function<ChildrenSpecBuilder, ChildrenSpec> collector);

    <FROM, TO> ChildrenSpecBuilder mapping(String name, Class<TO> toType, Class<FROM> fromType);

    <FROM, TO> ChildrenSpecBuilder mapping(String name, Function<FROM,TO>  mapper);

    <FROM, TO> ChildrenSpecBuilder collect(String name, Function<FROM[], TO> mapper);

    <ELEMENT, TO> ChildrenSpecBuilder collect(String namePrefixPattern, Class<TO> toType, Class<ELEMENT> elementType,
                                              Function<ChildrenSpecBuilder, ChildrenSpec> collector);

    ChildrenSpec build();

}
