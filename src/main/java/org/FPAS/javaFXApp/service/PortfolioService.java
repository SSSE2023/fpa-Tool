package org.FPAS.javaFXApp.service;

import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import org.FPAS.javaFXApp.SharedData;
import org.FPAS.springApp.Repository.*;
import org.FPAS.springApp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PerformanceMetricsRepository performanceMetricsRepository;

    @Autowired
    private BenchmarkRepository benchmarkRepository;
    @Autowired
    private InvestmentsRepository investmentsRepository;


    public void loadLineChartData(XYChart<String, Number> lineChart) {
        Optional<Client> client = clientRepository.findByUsernameAndPassword(SharedData.getUsername(), SharedData.getPassword());
        List<PerformanceMetrics> performanceMetricsList = performanceMetricsRepository.findByClient(client.get());
        List<Benchmark> benchmark = benchmarkRepository.findAll();
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.Series<String, Number> series2 = new XYChart.Series<>();

        series.setName("Client Performance");
        series2.setName("Benchmark");

        for (PerformanceMetrics data : performanceMetricsList) {
            series.getData().add(new XYChart.Data<>("2020", data.getReturn_2020()));
            series.getData().add(new XYChart.Data<>("2021", data.getReturn_2021()));
            series.getData().add(new XYChart.Data<>("2022", data.getReturn_2022()));
            series.getData().add(new XYChart.Data<>("2023", data.getReturn_2023()));
        }

        for (Benchmark data : benchmark) {
            series2.getData().add(new XYChart.Data<>(Integer.toString(data.getAnnum()), data.getBenchmarkReturn()));
        }

        lineChart.setLegendVisible(true);
        lineChart.getData().addAll(series, series2);
    }

    public void loadBarChartData(XYChart<String, Number> barChart) {
        Optional<Client> client = clientRepository.findByUsernameAndPassword(SharedData.getUsername(), SharedData.getPassword());
        List<Portfolio> portfolioDataList = portfolioRepository.findByClient(client.get());

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        for (Portfolio data : portfolioDataList) {
            series.getData().add(new XYChart.Data<>(data.getSymbol(), data.getPurchasePrice() * data.getQuantity()));
        }
        barChart.getData().clear();
        barChart.getData().add(series);
        barChart.setLegendVisible(false);
    }
    public void loadPieChartData(PieChart pieChart) {
        Optional<Client> client = clientRepository.findByUsernameAndPassword(SharedData.getUsername(), SharedData.getPassword());
        List<Portfolio> portfolioDataList = portfolioRepository.findByClient(client.get());

        PieChart.Data[] data = new PieChart.Data[portfolioDataList.size()];

        double totalValue = 0;

        for (int i = 0; i < portfolioDataList.size(); i++) {
            Portfolio portfolio = portfolioDataList.get(i);
            data[i] = new PieChart.Data(portfolio.getSymbol(), portfolio.getPurchasePrice() * portfolio.getQuantity());
            totalValue += data[i].getPieValue();
        }

        pieChart.getData().setAll(data);
        pieChart.setLegendVisible(false);

    }

    public double calculateRiskRating() {
        Optional<Client> client = clientRepository.findByUsernameAndPassword(SharedData.getUsername(), SharedData.getPassword());
        List<Portfolio> portfolioDataList = portfolioRepository.findByClient(client.get());
        double riskRating = 0;
        int totalElements = 0;
        for (Portfolio data : portfolioDataList) {
            String symbol = data.getSymbol();
            List<Investments> investmentsDataList = investmentsRepository.findBySymbol(symbol);
            for (Investments data2 : investmentsDataList) {
                riskRating += data2.getRisk_rating();
                totalElements++;
            }
        }
        if (totalElements == 0) {
            return 0;
        }
        riskRating = riskRating/totalElements ;

        return riskRating;
    }

    public double totalPortfolioValue() {
        Optional<Client> client = clientRepository.findByUsernameAndPassword(SharedData.getUsername(), SharedData.getPassword());
        List<Portfolio> portfolioDataList = portfolioRepository.findByClient(client.get());
        double totalPortfolioValue = 0;
        for (Portfolio data : portfolioDataList) {
            totalPortfolioValue += data.getPurchasePrice() * data.getQuantity();
        }
        return totalPortfolioValue;
    }
}
