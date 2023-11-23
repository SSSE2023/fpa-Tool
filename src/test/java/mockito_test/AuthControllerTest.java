package mockito_test;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.FPAS.javaFXApp.controller.authController;
import org.FPAS.springApp.Repository.ClientRepository;
import org.FPAS.javaFXApp.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testfx.api.FxToolkit;
import org.testfx.util.WaitForAsyncUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthControllerTest {

    @Mock
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private authController authController;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        FxToolkit.registerPrimaryStage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AuthenticationView2.fxml"));
        Parent root = loader.load();
        authController = loader.getController();

        Platform.runLater(() -> {
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        waitForFX();
    }

    @Test
    public void testAuthControllerInitialization() {
        assertNotNull(authController);
        assertNotNull(authController.loginButton);
        assertNotNull(authController.signUpButton);
        assertNotNull(authController.login_username);
        assertNotNull(authController.login_password);
    }

    @Test
    public void testButtonClick() {
        Platform.runLater(() -> {
            authController.loginButton.fire();
            waitForFX();
            assertEquals("Logging in...", authController.loginButton.getText());
        });
    }

    private void waitForFX() {
        WaitForAsyncUtils.waitForFxEvents();
    }
}
