package org.sanetro.app.car.repositories;

import org.sanetro.app.car.model.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> getUserByLogin(String login);
}