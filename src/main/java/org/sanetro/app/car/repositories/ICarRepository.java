package org.sanetro.app.car.repositories;

import org.sanetro.app.car.model.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> getCars();
    void rentCar(String plate);
}