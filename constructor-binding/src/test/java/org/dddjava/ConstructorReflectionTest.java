package org.dddjava;

import org.dddjava.model.user.FavoriteFlutes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.List;


public class ConstructorReflectionTest {

    @Test
    void test() {
        Class<FavoriteFlutes> favoriteFlutesClass = FavoriteFlutes.class;
        try {
            Constructor<?> constructor = favoriteFlutesClass.getConstructor(List.class);
            Type parameterType = constructor.getGenericParameterTypes()[0];
            assertEquals(parameterType.getTypeName(), "java.util.List<org.dddjava.model.user.FavoriteFlute>");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
