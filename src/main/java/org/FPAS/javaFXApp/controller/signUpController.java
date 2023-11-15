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

import static org.FPAS.javaFXApp.Utils.changeScene;

@Controller
@NoArgsConstructor
public class signUpController implements Initializable {
    @FXML
    private Button signUpButton;
    @FXML
    private TextField name;
    @FXML
    private TextField sign_username;
    @FXML
    private TextField sign_password;
    @FXML
    private TextField Emails;
    @FXML
    private Button login;
    @Autowired
    ClientRepository clientRepository;

    public signUpController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        signUpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!sign_username.getText().trim().isEmpty() && !sign_password.getText().trim().isEmpty()
                        && !name.getText().trim().isEmpty() && !Emails.getText().trim().isEmpty()) {
                    Utils.signUpUser(event, name.getText(), sign_username.getText(), sign_password.getText(), Emails.getText());
                } else {
                    System.out.println("Invalid Information");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Fill all information");
                    alert.show();
                }
            }
        });
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene(event, "AuthenticationView2.fxml", null, null, authController.class);
            }
        });
    }
}
