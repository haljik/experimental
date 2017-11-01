package org.dddjava.model.user.job;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class JobHistories {
    final List<JobHistory> values;

    public JobHistories(List<JobHistory> values) {
        this.values = values;
    }

    public JobHistories(JobHistory[] values) {
        this(Arrays.stream(values).collect(toList()));
    }
}
