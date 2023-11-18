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
import org.FPAS.springApp.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.*;

import static org.FPAS.javaFXApp.Utils.changeScene;

@Controller
@NoArgsConstructor
public class PortfolioController implements Initializable {

    @FXML
    private Button transactionButton;
    @FXML
    private Button investmentsButton;
    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private Label usernameField;
    @FXML
    private Button sign_out;
    public static PortfolioRepository portfolioRepository;
    public static BenchmarkRepository benchmarkRepository;
    public static ClientRepository clientRepository;
    public static InvestmentsRepository investmentsRepository;
    //public static PerformanceMetricsRepository performanceMetricsRepository;

    @Autowired
    public PortfolioController( ClientRepository clientRepository, PortfolioRepository portfolioRepository, BenchmarkRepository benchmarkRepository, InvestmentsRepository investmentsRepository){//,PerformanceMetricsRepository performanceMetricsRepository) {
        PortfolioController.clientRepository = clientRepository;
        PortfolioController.benchmarkRepository = benchmarkRepository;
        PortfolioController.portfolioRepository = portfolioRepository;
        PortfolioController.investmentsRepository = investmentsRepository;
        //PortfolioController.performanceMetricsRepository = performanceMetricsRepository;
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

      // loadLineChartData();
        loadBarChartData();


        Optional<Client> userOptional = clientRepository.findByUsernameAndPassword(SharedData.getUsername(), SharedData.getPassword());
        userOptional.ifPresent(client -> {
            usernameField.setText(client.getName());
        });
    }
/*
    private void loadLineChartData() {
        Optional<Client> client = clientRepository.findByUsernameAndPassword(SharedData.getUsername(),SharedData.getPassword());
        long id= client.get().getuID();
        List<PerformanceMetrics> performanceMetricsList = PerformanceMetricsRepository.findByClientId(id);
        List<Benchmark> benchmark = benchmarkRepository.findAll();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();

        for (PerformanceMetrics data : performanceMetricsList) {
            series.getData().add(new XYChart.Data<>("2020", data.getReturn_2020()));
            series.getData().add(new XYChart.Data<>("2021", data.getReturn_2021()));
            series.getData().add(new XYChart.Data<>("2022", data.getReturn_2022()));
            series.getData().add(new XYChart.Data<>("2023", data.getReturn_2023()));
        }
        for(Benchmark data: benchmark){
            series2.getData().add(new XYChart.Data<>(Integer.toString(data.getAnnum()), data.getBenchmarkReturn()));
        }
        List<XYChart.Series<String, Number>> seriesList = new ArrayList<>();
        seriesList.add(series);
        seriesList.add(series2);

        lineChart.getData().addAll(seriesList);
    }


*/


    private void loadBarChartData () {
        // Fetch the client based on username and password
        Optional<Client> client = clientRepository.findByUsernameAndPassword(SharedData.getUsername(),SharedData.getPassword());

        // Get the uID of the client
        long id= client.get().getuID();

        // Fetch the portfolio data for the client using the uID
        List<Portfolio> portfolioDataList = portfolioRepository.findByClientId(id);

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        // Loop through the portfolio data and add it to the series
        for (Portfolio data : portfolioDataList) {
            series.getData().add(new XYChart.Data<>(data.getSymbol(), data.getPurchasePrice() * data.getQuantity()));
        }

        // Clear the old data from the chart and add the new series
        barChart.getData().clear();
        barChart.getData().add(series);
        barChart.setLegendVisible(true);
    }


}

