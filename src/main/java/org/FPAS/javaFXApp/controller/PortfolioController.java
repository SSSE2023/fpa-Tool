package org.FPAS.javaFXApp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import lombok.NoArgsConstructor;
import org.FPAS.javaFXApp.SharedData;
import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.model.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static org.FPAS.javaFXApp.Utils.changeScene;

@Controller
@NoArgsConstructor
@Component
@ComponentScan(basePackages = "org.FPAS.javaFXApp")
public class PortfolioController implements Initializable {

    @FXML
    private Button transactionButton;
    @FXML
    private Button investmentsButton;
    @FXML
    private Button loadDataButton;
    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private Label usernameField;
    @FXML
    private Button sign_out;

    public static ClientRepository clientRepository;
    @Autowired
    public PortfolioController(ClientRepository clientRepository) {
        PortfolioController.clientRepository = clientRepository;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transactionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene(event, "TransactionRecordingView.fxml", null, null, TransactionRecordingController.class);
            }
        });
        sign_out.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene(event, "AuthenticationView2.fxml", null, null, authController.class);
            }
        });

        investmentsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene(event, "InvestmentEntryView.fxml", null, null, InvestmentEntryController.class);
            }
        });
        loadDataButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CategoryAxis xLineAxis = new CategoryAxis();
                NumberAxis yLineAxis = new NumberAxis();
                XYChart.Series<String, Number> series = new XYChart.Series<>();
                series.getData().add(new XYChart.Data<>("January", 10000));
                series.getData().add(new XYChart.Data<>("February", 7500));
                series.getData().add(new XYChart.Data<>("March", 9000));
                series.getData().add(new XYChart.Data<>("April", 13000));
                lineChart.getData().add(series);
                lineChart.setLegendVisible(false);

                NumberAxis xChartAxis = new NumberAxis();
                NumberAxis yChartAxis = new NumberAxis();
                XYChart.Series<String, Number> barChart1 = new XYChart.Series<>();
                barChart1.getData().add(new XYChart.Data<>("2020", 2500));
                barChart1.getData().add(new XYChart.Data<>("2021", 10000));
                barChart1.getData().add(new XYChart.Data<>("2022", 15000));
                barChart1.getData().add(new XYChart.Data<>("2023", 13000));

                // Add the series to the chart
                barChart.getData().add(barChart1);
                barChart.setLegendVisible(false);
            }
        });

        Optional<Client> userOptional = clientRepository.findByUsernameAndPassword(SharedData.getUsername(), SharedData.getPassword());
                userOptional.ifPresent(client -> {usernameField.setText(client.getName());
        });
    }
    }

