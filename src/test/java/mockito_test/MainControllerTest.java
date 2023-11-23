package mockito_test;

import javafx.application.Platform;
import javafx.scene.control.Button;
import org.FPAS.javaFXApp.FXMLHandler;
import org.FPAS.javaFXApp.controller.mainController;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

class MainControllerTest {

    @InjectMocks
    private mainController MainController;

    @Mock
    private FXMLHandler fxmlHandler;

    @Mock
    private Button signUpButton;

    @BeforeAll
    public static void initJfx() {
        // Initialize JavaFX Toolkit
        Platform.startup(() -> {});
    }

    @AfterAll
    public static void cleanupJfx() {
        // Shutdown JavaFX Toolkit
        Platform.exit();
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testHandleSignUpButtonAction() {
        Platform.runLater(() -> {
            MainController.initialize(null, null);
            verify(signUpButton).setOnAction(any());
        });
    }
}
