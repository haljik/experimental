package org.dddjava.fluent;

import org.dddjava.model.user.*;
import org.dddjava.model.user.job.CompanyName;
import org.dddjava.model.user.job.JobHistories;
import org.dddjava.model.user.job.JobHistory;
import org.dddjava.model.user.job.PositionName;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class BindingSpecTest {

    @Disabled("書き方の試行のみ")
    @Test
    void test() {
        BindingSpecBuilder<HttpServletRequest> builder = new HttpRequestBindingSpecBuilder();

        BindingSpec<HttpServletRequest, User> spec = builder
                .specify(User.class, userChildren -> userChildren
                        .mapping("profile", Profile.class, profileChildren -> profileChildren
                                .mapping("mailAddress", MailAddress.class, String.class)
                                .mapping("name", Name.class, String.class)
                                .build()
                        )
                        .mapping("point", Point.class, Long.class)
                        .collect("favoriteFlutes", (String[] flutes) -> new FavoriteFlutes(flutes)) //Binding Array Parameter
                        .collect("jobHistories.values[*]",  JobHistories.class, JobHistory.class,
                                jobHistoryChildren -> jobHistoryChildren //Binding Indexed Property Parameter ex. jobHistories.values[0].*
                                        .mapping("companyName", CompanyName.class, String.class)
                                        .mapping("positionName", PositionName.class, String.class)
                                        .build()
                        )
                        .build()
                );

        BindingResult<User> result = spec.bind(null);
    }
}
