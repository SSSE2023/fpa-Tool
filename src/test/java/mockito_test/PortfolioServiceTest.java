package mockito_test;

import javafx.embed.swing.JFXPanel;
import javafx.scene.chart.*;
import org.FPAS.springApp.Repository.*;
import org.FPAS.springApp.model.*;
import org.FPAS.javaFXApp.service.PortfolioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PortfolioServiceTest {

    @InjectMocks
    private PortfolioService portfolioService;

    @Mock
    private PortfolioRepository portfolioRepository;
    @Mock
    private ClientRepository clientRepository;
    @Mock
    private PerformanceMetricsRepository performanceMetricsRepository;
    @Mock
    private BenchmarkRepository benchmarkRepository;
    @Mock
    private InvestmentsRepository investmentsRepository;
    @Mock
    private InflationBenchmarkRepository inflationBenchmarkRepository;  // Add this mock

    @BeforeEach
    void setUp() {
        new JFXPanel();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoadLineChartData() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<String, Number> lineChart = new LineChart<>(xAxis, yAxis);

        Client client = new Client();
        when(clientRepository.findByUsernameAndPassword(any(), any())).thenReturn(Optional.of(client));

        List<PerformanceMetrics> performanceMetricsList = Arrays.asList(new PerformanceMetrics());
        when(performanceMetricsRepository.findByClient(client)).thenReturn(performanceMetricsList);

        List<Benchmark> benchmarkList = Arrays.asList(new Benchmark());
        when(benchmarkRepository.findAll()).thenReturn(benchmarkList);

        // Add this line to mock inflationBenchmarkRepository
        when(inflationBenchmarkRepository.findAll()).thenReturn(Arrays.asList(new InflationBenchmark()));

        portfolioService.loadLineChartData(lineChart);
    }


    @Test
    void testLoadBarChartData() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        Client client = new Client();
        when(clientRepository.findByUsernameAndPassword(any(), any())).thenReturn(Optional.of(client));

        List<Portfolio> portfolioDataList = Arrays.asList(new Portfolio());
        when(portfolioRepository.findByClient(client)).thenReturn(portfolioDataList);

        portfolioService.loadBarChartData(barChart);
    }


    @Test
    void testLoadPieChartData() {
        PieChart pieChart = new PieChart();
        Client client = new Client();
        when(clientRepository.findByUsernameAndPassword(any(), any())).thenReturn(Optional.of(client));
        List<Portfolio> portfolioDataList = Arrays.asList(new Portfolio());
        when(portfolioRepository.findByClient(client)).thenReturn(portfolioDataList);

        portfolioService.loadPieChartData(pieChart);
    }

    @Test
    void testCalculateRiskRating() {
        Client client = new Client();
        when(clientRepository.findByUsernameAndPassword(any(), any())).thenReturn(Optional.of(client));
        List<Portfolio> portfolioDataList = Arrays.asList(new Portfolio());
        when(portfolioRepository.findByClient(client)).thenReturn(portfolioDataList);
        when(investmentsRepository.findBySymbol(any())).thenReturn(Arrays.asList(new Investments()));

        portfolioService.calculateRiskRating();
    }

    @Test
    void testTotalPortfolioValue() {
        Client client = new Client();
        when(clientRepository.findByUsernameAndPassword(any(), any())).thenReturn(Optional.of(client));
        List<Portfolio> portfolioDataList = Arrays.asList(new Portfolio());
        when(portfolioRepository.findByClient(client)).thenReturn(portfolioDataList);

        portfolioService.totalPortfolioValue();
    }
}