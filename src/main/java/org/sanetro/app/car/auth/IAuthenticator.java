package org.sanetro.app.car.auth;

import org.sanetro.app.car.model.User;

public interface IAuthenticator {
    void authenticate(User user);
}
