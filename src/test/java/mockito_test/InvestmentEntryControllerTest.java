package mockito_test;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.FPAS.javaFXApp.controller.InvestmentEntryController;
import org.FPAS.springApp.Repository.ClientRepository;
import org.FPAS.springApp.Repository.PortfolioRepository;
import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.model.Portfolio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testfx.framework.junit5.ApplicationTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class InvestmentEntryControllerTest extends ApplicationTest {

    @InjectMocks
    private InvestmentEntryController investmentEntryController;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private PortfolioRepository portfolioRepository;

    @Mock
    private TableView<Portfolio> portfolioTable;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Override
    public void start(Stage stage) {
        // No need to start the application in this test
    }

    @Test
    void initializeTableView() {
        // Mock data
        Client mockClient = new Client();
        mockClient.setUsername("testUser");
        mockClient.setPassword("testPassword");

        Portfolio mockPortfolio = new Portfolio();
        mockPortfolio.setSymbol("AAPL");
        mockPortfolio.setPurchaseYear("2022");
        mockPortfolio.setQuantity(10);
        mockPortfolio.setPurchasePrice(150.0);
        mockPortfolio.setInvestmentType("Stock");

        List<Portfolio> mockPortfolioList = new ArrayList<>();
        mockPortfolioList.add(mockPortfolio);

        // Mock behavior of repository methods
        when(clientRepository.findByUsernameAndPassword("testUser", "testPassword"))
                .thenReturn(Optional.ofNullable(mockClient));
        when(portfolioRepository.findByClient(any(Client.class)))
                .thenReturn(mockPortfolioList);

        // Run the test on the JavaFX Application Thread using TestFX
        Platform.runLater(() -> {
            // Initialize the controller
            investmentEntryController.initializeTableView();
        });

        // Sleep to wait for JavaFX Application Thread to complete
        sleep(1000); // Adjust this value as needed

        // Verify that the TableView is populated with the mock data
        verify(portfolioTable).setItems(any(ObservableList.class));
        verify(portfolioTable, times(1)).setItems(any());
    }
}
