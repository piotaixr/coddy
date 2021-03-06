package org.crunchytorch.coddy.user.data.security;

import org.crunchytorch.coddy.user.data.IUser;

import java.security.Principal;
import java.util.Date;
import java.util.List;

public class JWTPrincipal implements Principal, IUser {

    private final String login;
    private final String firstName;
    private final String lastName;
    private final List<String> permissions;
    private final Date beginActivationSession;

    public JWTPrincipal(
            final String login,
            final String firstName,
            final String lastName,
            final List<String> permissions,
            final Date beginActivationSession) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.permissions = permissions;
        this.beginActivationSession = beginActivationSession != null ? (Date) beginActivationSession.clone() : null;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public List<String> getPermissions() {
        return this.permissions;
    }

    public Date getBeginActivationSession() {
        return this.beginActivationSession != null ? (Date) this.beginActivationSession.clone() : null;
    }
}
