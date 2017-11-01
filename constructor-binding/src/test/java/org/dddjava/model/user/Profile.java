package org.dddjava.model.user;

public class Profile {
    final MailAddress mailAddress;
    final Name name;

    public Profile(MailAddress mailAddress, Name name) {
        this.mailAddress = mailAddress;
        this.name = name;
    }
}
