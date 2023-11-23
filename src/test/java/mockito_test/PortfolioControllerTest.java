/*package mockito_test;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.FPAS.javaFXApp.controller.PortfolioController;
import org.FPAS.javaFXApp.service.PortfolioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testfx.framework.junit5.ApplicationTest;
import org.FPAS.javaFXApp.controller.authController;
import org.FPAS.javaFXApp.controller.TransactionRecordingController;
import org.FPAS.javaFXApp.controller.InvestmentEntryController;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class PortfolioControllerTest extends ApplicationTest {

    @Mock
    private PortfolioService portfolioService;

    @InjectMocks
    private PortfolioController portfolioController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Override
    public void start(Stage stage) {
        // Initialize JavaFX components
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/PortfolioView.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        portfolioController = loader.getController(); // Use the injected controller

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Test
    public void testPortfolioControllerInitialization() {
        assertNotNull(PortfolioController.sign_out);
        assertNotNull(PortfolioController.transactionButton);
        assertNotNull(PortfolioController.usernameField);
        assertNotNull(PortfolioController.pieChart);
    }

    @Test
    void testTransactionButtonAction() {
        // Simulate button click
        clickOn("#transactionButton");

        // Verify that the changeScene method was called with the expected arguments
        verify(portfolioController, times(1)).FXMLHandler.changeScene(any(), eq("TransactionRecordingView.fxml"), isNull(), isNull(), eq(TransactionRecordingController.class));
    }

    @Test
    void testSignOutButtonAction() {
        // Simulate button click
        clickOn("#sign_out");

        // Verify that the changeScene method was called with the expected arguments
        verify(portfolioController, times(1)).FXMLHandler.changeScene(any(), eq("AuthenticationView2.fxml"), isNull(), isNull(), eq(authController.class));
    }

    @Test
    void testInvestmentsButtonAction() {
        // Simulate button click
        clickOn("#investmentsButton");

        // Verify that the changeScene method was called with the expected arguments
        verify(portfolioController, times(1)).FXMLHandler.changeScene(any(), eq("InvestmentEntryView.fxml"), isNull(), isNull(), eq(InvestmentEntryController.class));
    }

    // Add more tests as needed for other actions and methods in PortfolioController
}
*/