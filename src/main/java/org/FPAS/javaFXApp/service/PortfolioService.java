package org.FPAS.javaFXApp.service;

import javafx.scene.chart.XYChart;
import org.FPAS.javaFXApp.SharedData;
import org.FPAS.springApp.Repository.*;
import org.FPAS.springApp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Portfolio> getPortfoliosByClient(Client client) {
        return portfolioRepository.findByClient(client);
    }

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

    public int calculateRiskRating() {
        Optional<Client> client = clientRepository.findByUsernameAndPassword(SharedData.getUsername(), SharedData.getPassword());
        List<Portfolio> portfolioDataList = portfolioRepository.findByClient(client.get());
        int riskRating = 0;
        for (Portfolio data : portfolioDataList) {
            String symbol = data.getSymbol();
            List<Investments> investmentsDataList = investmentsRepository.findBySymbol(symbol);
            for (Investments data2 : investmentsDataList) {
                riskRating += data2.getRisk_rating();
            }
        }
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
