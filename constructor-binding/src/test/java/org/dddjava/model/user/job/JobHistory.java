package org.dddjava.model.user.job;

public class JobHistory {
    final CompanyName companyName;
    final PositionName positionName;

    public JobHistory(CompanyName companyName, PositionName positionName) {
        this.companyName = companyName;
        this.positionName = positionName;
    }
}
