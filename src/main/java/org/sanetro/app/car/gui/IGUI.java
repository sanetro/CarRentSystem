package org.sanetro.app.car.gui;

import org.sanetro.app.car.model.User;

public interface IGUI {
    User readLoginData();
    String menu();
    void listCars();
    String readPlate();
}
