package org.dddjava.simple;

import org.dddjava.Source;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ArgumentResolvers {
    List<ArgumentResolver> values;

    public ArgumentResolvers(List<ArgumentResolver> values) {
        this.values = values;
    }


    public Object[] resolve(Source source) {
        return values.stream()
                .map(resolver -> {
                    try {
                        return resolver.resolve(source);
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                        //TODO: エラーを蓄積する仕組みが必要
                        throw new RuntimeException(e);
                    }
                })
                .toArray();
    }
}
