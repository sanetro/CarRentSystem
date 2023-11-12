package org.sanetro.app.car.core;

import org.sanetro.app.car.auth.IAuthenticator;
import org.sanetro.app.car.exceptions.CarAlreadyRentException;
import org.sanetro.app.car.exceptions.CarNotFoundException;
import org.sanetro.app.car.exceptions.IncorrectPasswordException;
import org.sanetro.app.car.exceptions.UserNotFoundException;
import org.sanetro.app.car.gui.IGUI;
import org.sanetro.app.car.model.User;
import org.sanetro.app.car.repositories.ICarRepository;
import org.springframework.stereotype.Component;


@Component
public class Core {

    private ICarRepository carRepository;
    private IAuthenticator authenticator;
    private IGUI gui;

    public Core(ICarRepository carRepository, IAuthenticator authenticator, IGUI gui) {
        this.carRepository = carRepository;
        this.authenticator = authenticator;
        this.gui = gui;
    }

    public void start() {
        User user = gui.readLoginData();
        try {
            authenticator.authenticate(user);
        } catch (UserNotFoundException | IncorrectPasswordException e) {
            System.out.println("Incorrect authentication");
            return;
        }

        mainLoop: while(true) {
            switch(gui.menu()) {
                case "1":
                    gui.listCars();
                    break;
                case "2":
                    String plate = gui.readPlate();
                    try {
                        carRepository.rentCar(plate);
                    } catch (CarNotFoundException e) {
                        System.out.println("Car not found");
                    } catch (CarAlreadyRentException e) {
                        System.out.println("Car already rent");
                    }
                    break;
                case "3":
                    break mainLoop;
                default:
                    System.out.println("Incorrect choose !!");
            }
        }
    }
}
