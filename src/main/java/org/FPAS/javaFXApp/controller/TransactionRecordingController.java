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

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
@NoArgsConstructor

public class TransactionRecordingController implements Initializable {
    @FXML
    private Button investmentsButton;
    @FXML
    private Button dashboardButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        investmentsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Utils.changeScene(event, "InvestmentEntryView.fxml", null, null, InvestmentEntryController.class);
            }
        });
        dashboardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Utils.changeScene(event, "PortfolioView.fxml", null, null, PortfolioController.class);
            }
        });

    }
}
