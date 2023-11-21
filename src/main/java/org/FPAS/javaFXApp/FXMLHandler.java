package org.FPAS.javaFXApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.NoArgsConstructor;
import org.FPAS.javaFXApp.controller.mainController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
@NoArgsConstructor
@Component
@ComponentScan(basePackages = "org.FPAS.javaFXApp")
public class FXMLHandler {

    public static URL getResource(String fxmlFile) {
        return FXMLHandler.class.getResource(fxmlFile);
    }
    public static void changeScene(ActionEvent event, String fxmlFile, String username, String password, Class<?> controllerClass) {

        try {
            String path = "/view/" + fxmlFile;
            URL resourceUrl = FXMLHandler.class.getResource(path);

            if (resourceUrl == null) {
                System.err.println("FXML file not found: " + path);
                return;
            }

            FXMLLoader loader = new FXMLLoader(resourceUrl);
            Parent root = loader.load();

            if (username != null && mainController.class.isAssignableFrom(controllerClass)) {
                mainController controller = loader.getController();
                controller.setUserInformation(username);
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading FXML file: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }



}
