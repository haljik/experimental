package org.dddjava.model.user;

public class User {
    final Profile profile;
    final Point point;

    public User(Profile profile, Point point) {
        this.profile = profile;
        this.point = point;
    }
}
