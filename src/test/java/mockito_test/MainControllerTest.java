package mockito_test;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.FPAS.javaFXApp.FXMLHandler;
import org.FPAS.javaFXApp.controller.mainController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class MainControllerTest {

    private static FXMLHandler mockFXMLHandler;

    @BeforeAll
    public static void initJFX() {
        // Initialize JavaFX for the test
        new JFXPanel();
        Platform.runLater(() -> {
            mockFXMLHandler = mock(FXMLHandler.class);
        });
    }

    @Test
    public void testSignUpButtonClicked() {
        // Create an instance of the controller
        mainController maincontroller = new mainController(mockFXMLHandler);

        // Simulate the initialization of the controller (similar to what JavaFX would do)
        Platform.runLater(() -> {
            try {
                maincontroller.initialize(null, null);

                // Simulate a button click
                maincontroller.signUpButton.fire();

                // Verify that the changeScene method was called with the expected parameters
                // (You need to implement proper verification based on your FXMLHandler behavior)
                // Example using Mockito:
                // verify(mockFXMLHandler).changeScene(any(ActionEvent.class), eq("signUpView.fxml"), eq(null), eq(null), eq(SignUpController.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void testSetUserInformation() {
        // Create an instance of the controller
        mainController maincontroller = new mainController(mockFXMLHandler);

        // Simulate the initialization of the controller (similar to what JavaFX would do)
        Platform.runLater(() -> {
            try {
                maincontroller.initialize(null, null);

                // Call the setUserInformation method
                maincontroller.setUserInformation("testUsername");

                // Verify that the information is printed to the console (you may need to capture the output for testing)
                // Example using Mockito:
                // verify(mockFXMLHandler).changeScene(any(ActionEvent.class), eq("signUpView.fxml"), eq(null), eq(null), eq(SignUpController.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
