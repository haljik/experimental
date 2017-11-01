package org.dddjava.model.user;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class FavoriteFlutes {
    final List<FavoriteFlute> values;

    public FavoriteFlutes(List<FavoriteFlute> values) {
        this.values = values;
    }

    public FavoriteFlutes(String[] values) {
        this(
                Arrays.stream(values)
                        .map(FavoriteFlute::new)
                        .collect(toList())
        );
    }
}
