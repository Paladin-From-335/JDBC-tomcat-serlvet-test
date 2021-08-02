package com.github.books.configs;

import com.github.books.controller.ControllerImpl;

public class ControllerConfig {

    private static final ControllerImpl controller = new ControllerImpl(DatabaseConfig.getService());

    public static ControllerImpl getController() {
        return controller;
    }
}
