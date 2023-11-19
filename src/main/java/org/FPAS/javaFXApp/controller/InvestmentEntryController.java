package org.FPAS.javaFXApp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lombok.NoArgsConstructor;
import org.FPAS.javaFXApp.FXMLHandler;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import static org.FPAS.javaFXApp.FXMLHandler.changeScene;

@Controller
@NoArgsConstructor

public class InvestmentEntryController implements Initializable {
    @FXML
    private Button transactionButton;
    @FXML
    private Button dashboardButton;
    @FXML
    private Button Sign_out;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transactionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLHandler.changeScene(event, "TransactionRecordingView.fxml", null, null, TransactionRecordingController.class);
            }
        });
        dashboardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLHandler.changeScene(event, "PortfolioView.fxml", null, null, PortfolioController.class);
            }
        });
        Sign_out.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene(event, "AuthenticationView2.fxml", null, null, authController.class);
            }
        });


    }
}
