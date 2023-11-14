package org.FPAS.javaFXApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.NoArgsConstructor;
import org.FPAS.javaFXApp.controller.PerformanceAnalysisController;
import org.FPAS.javaFXApp.controller.authController;
import org.FPAS.javaFXApp.controller.mainController;
import org.FPAS.springApp.SpringManager;
import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.model.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
@NoArgsConstructor
@Component
@ComponentScan(basePackages = "org.FPAS.javaFXApp")
public class Utils {
    private static ClientRepository personRepository;

    @Autowired
    public Utils(ClientRepository personRepository) {
        Utils.personRepository = personRepository;
    }

    public static URL getResource(String fxmlFile) {
        return Utils.class.getResource(fxmlFile);
    }
    public static void changeScene(ActionEvent event, String fxmlFile, String username, String password, Class<?> controllerClass) {
        try {
            String path = "/view/" + fxmlFile;
            URL resourceUrl = Utils.class.getResource(path);

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

    public static void signUpUser(ActionEvent event, String name, String username, String password) {
        try {
            personRepository.save(Client.builder()
                .name(name)
                .username(username)
                .password(password)
                .build());
        } catch (DataIntegrityViolationException e) {
            System.out.println("Username already exists.");
        }

        changeScene(event, "AuthenticationView2.fxml", username, password, authController.class);
    }


    public static void loginUser(ActionEvent event, String username, String password) {
        Optional<Client> userOptional = personRepository.findByUsernameAndPassword(username, password);

        if (userOptional.isPresent()) {
            System.out.println("Login successful for user: " + username);
        } else {
            System.out.println("Invalid credentials for user: " + username);
        }
        changeScene(event, "PerformanceAnalysisView.fxml", username, password, PerformanceAnalysisController.class);
    }

}
