package mockito_test;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.FPAS.javaFXApp.FXMLHandler;
import org.FPAS.javaFXApp.controller.mainController;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class FXMLHandlerTest {

    @Test
    void changeSceneShouldLoadFXMLAndSetUserInformation() throws Exception {
        // Initialize JavaFX
        JFXPanel jfxPanel = new JFXPanel();

        // Run JavaFX-related code on the JavaFX application thread
        Platform.runLater(() -> {
            FXMLHandler fxmlHandler = new FXMLHandler();
            ActionEvent actionEvent = mock(ActionEvent.class);
            Node sourceNode = mock(Node.class);
            Stage stage = mock(Stage.class);
            mainController controller = mock(mainController.class);

            when(actionEvent.getSource()).thenReturn(sourceNode);
            when(sourceNode.getScene()).thenReturn(new Scene(new javafx.scene.layout.VBox()));
            when(sourceNode.getScene().getWindow()).thenReturn(stage);

            fxmlHandler.changeScene(actionEvent, "YourFXMLFile.fxml", "TestUser", "TestPassword", mainController.class);

            verify(stage, times(1)).setScene(any(Scene.class));
            verify(stage, times(1)).show();
            verify(controller, times(1)).setUserInformation("TestUser");
        });
    }
}
