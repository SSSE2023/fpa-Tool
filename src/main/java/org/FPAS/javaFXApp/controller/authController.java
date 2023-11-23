package org.FPAS.javaFXApp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lombok.NoArgsConstructor;
import org.FPAS.javaFXApp.SharedData;
import org.FPAS.javaFXApp.FXMLHandler;
import org.FPAS.javaFXApp.service.ClientService;
import org.FPAS.springApp.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;
@Controller
@NoArgsConstructor

public class authController implements Initializable {
    @FXML
    public Button loginButton;
    @FXML
    public Button signUpButton;
    @FXML
    public TextField login_username;
    @FXML
    public TextField login_password;
    @Autowired
    ClientRepository clientRepository;

    public authController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!login_username.getText().trim().isEmpty() && !login_password.getText().trim().isEmpty()) {
                    SharedData.setCredentials(login_username.getText(), login_password.getText());
                    ClientService.loginUser(event, login_username.getText(), login_password.getText());
                }
                else{
                    System.out.println("Invalid Information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Fill all information");
                    alert.show();
                }
                loginButton.setText("Logging in...");
            }
        });
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLHandler.changeScene(event, "signUpView.fxml", null, null, signUpController.class);
            }
        });
    }

}