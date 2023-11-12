package org.sanetro.app.car.auth;

import org.sanetro.app.car.exceptions.IncorrectPasswordException;
import org.sanetro.app.car.exceptions.UserNotFoundException;
import org.sanetro.app.car.model.User;
import org.sanetro.app.car.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;


public class Authenticator implements IAuthenticator {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public void authenticate(User user) {
        Optional<User> userFromDb = this.userRepository.getUserByLogin(user.getLogin());
        if(userFromDb.isEmpty()) {
            throw new UserNotFoundException();
        }

        if(!userFromDb.get().getPassword().equals(user.getPassword())) {
            throw new IncorrectPasswordException();
        }
    }
}
