package mockito_test;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import org.FPAS.javaFXApp.javaFXMain;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JavaFXMainTest {

    @BeforeAll
    public static void initJFX() {
        new JFXPanel();
    }

    @AfterAll
    public static void cleanUp() {
        Platform.exit();
    }

    @Test
    public void testStart() {
        Platform.runLater(() -> {
            try {
                javaFXMain application = new javaFXMain();
                Stage stage = new Stage();
                application.start(stage);

                assertNotNull(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
