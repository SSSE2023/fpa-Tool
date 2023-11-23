package org.FPAS.javaFXApp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import lombok.NoArgsConstructor;
import org.FPAS.javaFXApp.FXMLHandler;
import org.FPAS.javaFXApp.SharedData;
import org.FPAS.javaFXApp.service.PortfolioService;
import org.FPAS.springApp.Repository.*;
import org.FPAS.springApp.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.*;

import static org.FPAS.javaFXApp.FXMLHandler.changeScene;

@Controller
@NoArgsConstructor
public class PortfolioController implements Initializable {

    @FXML
    public Button transactionButton;
    @FXML
    public Button investmentsButton;
    @FXML
    public LineChart<String, Number> lineChart;
    @FXML
    public BarChart<String, Number> barChart;
    public org.FPAS.javaFXApp.FXMLHandler FXMLHandler;
    @FXML
    private Label usernameField;
    @FXML
    public Button sign_out;
    @FXML
    public Label riskRatingLabel;
    @FXML
    public Label portfolioLabel;
    @FXML
    public PieChart pieChart;
    @FXML
    public Label sumLabel;

    public static PortfolioRepository portfolioRepository;
    public static BenchmarkRepository benchmarkRepository;
    public static ClientRepository clientRepository;
    public static InvestmentsRepository investmentsRepository;
    public static PerformanceMetricsRepository performanceMetricsRepository;
    private static PortfolioService portfolioService;


    @Autowired
    public PortfolioController( ClientRepository clientRepository, PortfolioRepository portfolioRepository, BenchmarkRepository benchmarkRepository, InvestmentsRepository investmentsRepository,PerformanceMetricsRepository performanceMetricsRepository, PortfolioService portfolioService) {
        PortfolioController.clientRepository = clientRepository;
        PortfolioController.benchmarkRepository = benchmarkRepository;
        PortfolioController.portfolioRepository = portfolioRepository;
        PortfolioController.investmentsRepository = investmentsRepository;
        PortfolioController.performanceMetricsRepository = performanceMetricsRepository;
        PortfolioController.portfolioService = portfolioService;
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

        loadLineChartData();
        loadBarChartData();
        loadPieChartData();

        double riskRating = portfolioService.calculateRiskRating();
        double totalPortfolioValue = portfolioService.totalPortfolioValue();

        String riskRatingSentence = "The portfolio's risk rating currently stands at %.2f.";
        riskRatingLabel.setText(String.format(riskRatingSentence, riskRating));

        String portfolioValueSentence = "$%.2f";
        portfolioLabel.setText(String.format(portfolioValueSentence, totalPortfolioValue));

        Optional<Client> userOptional = clientRepository.findByUsernameAndPassword(SharedData.getUsername(), SharedData.getPassword());
        userOptional.ifPresent(client -> {
            usernameField.setText(client.getName());
        });
    }

    private void loadLineChartData() {
        portfolioService.loadLineChartData(lineChart);
    }

    private void loadBarChartData() {
        portfolioService.loadBarChartData(barChart);
    }
    private void loadPieChartData(){portfolioService.loadPieChartData(pieChart);}
}
