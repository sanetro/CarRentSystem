package org.sanetro.app.car.repositories;

import org.sanetro.app.car.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository implements IUserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        this.users.add(new User("teo", "teo"));
        this.users.add(new User("mike", "mike"));
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return this.users.stream().filter(u -> u.getLogin().equals(login)).findFirst();
    }
}
