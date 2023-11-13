package org.FPAS.javaFXApp.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.FPAS.javaFXApp.javaFXMain;
import org.FPAS.springApp.SpringManager;
import javafx.event.ActionEvent;

import java.awt.*;
import java.io.IOException;

public class authController {

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
