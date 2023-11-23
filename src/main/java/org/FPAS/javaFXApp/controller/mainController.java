package org.FPAS.javaFXApp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.FPAS.javaFXApp.FXMLHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class mainController implements Initializable {

    @FXML
    private Button loginButton;

    @FXML
    public Button signUpButton;

    private final FXMLHandler fxmlHandler;

    @Autowired
    public mainController(FXMLHandler fxmlHandler) {
        this.fxmlHandler = fxmlHandler;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (signUpButton != null) {
            signUpButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    fxmlHandler.changeScene(event, "signUpView.fxml", null, null, signUpController.class);
                }
            });
        } else {
            System.err.println("signUpButton is null in initialize method.");
        }
    }

    public static void setUserInformation(String username) {
        System.out.println(username);
    }
}
