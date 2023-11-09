package org.FPAS.javaFXApp.controller;

import org.FPAS.springApp.SpringManager;
import javafx.event.ActionEvent;

public class mainController {

    public void handleClick(ActionEvent actionEvent) {
        System.out.println("Starting Spring app");
        SpringManager.startSpringApp();
    }

    public void handleStopClick(ActionEvent actionEvent) {
        System.out.println("Shutting down Spring app");
        SpringManager.stopSpringApp();
    }

    public void printAll(ActionEvent actionEvent) {
        SpringManager.getSpringApp().printAll();
    }
}
