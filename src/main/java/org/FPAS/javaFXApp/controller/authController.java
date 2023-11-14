package org.FPAS.javaFXApp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.NoArgsConstructor;
import org.FPAS.javaFXApp.Utils;
import org.FPAS.springApp.model.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;
@Controller
@NoArgsConstructor

public class authController implements Initializable {
    @FXML
    private Button loginButton;
    @FXML
    private Button signUpButton;
    @FXML
    private TextField login_username;
    @FXML
    private TextField login_password;
    @Autowired
    ClientRepository personRepository;

    public authController(ClientRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!login_username.getText().trim().isEmpty() && !login_password.getText().trim().isEmpty()) {
                    Utils.loginUser(event, login_username.getText(), login_password.getText());
                }
                else{
                    System.out.println("Invalid Information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Fill all information");
                    alert.show();
                }
            }
        });
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Utils.changeScene(event, "signUpView.fxml", null, null, signUpController.class);
            }
        });
    }

}