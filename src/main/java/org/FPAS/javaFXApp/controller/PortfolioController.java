package org.FPAS.javaFXApp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transactionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Utils.changeScene(event, "TransactionRecordingView.fxml", null, null, TransactionRecordingController.class);
            }
        });
        investmentsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Utils.changeScene(event, "InvestmentEntryView.fxml", null, null, InvestmentEntryController.class);
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
     }
    };


