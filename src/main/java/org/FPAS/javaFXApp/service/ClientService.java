package org.FPAS.javaFXApp.service;

import javafx.event.ActionEvent;
import org.FPAS.javaFXApp.controller.PortfolioController;
import org.FPAS.javaFXApp.controller.authController;
import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.FPAS.javaFXApp.FXMLHandler.changeScene;

@Service
public class ClientService {

    public static ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public static void signUpUser(ActionEvent event, String name, String username, String password,String email) {
        try {
            clientRepository.save(Client.builder()
                    .name(name)
                    .username(username)
                    .password(password)
                    .email(email)
                    .build());
        } catch (DataIntegrityViolationException e) {
            System.out.println("Username already exists.");
        }

        changeScene(event, "AuthenticationView2.fxml", username, password, authController.class);
    }

    public Optional<Client> loginUser(String username, String password) {
        return clientRepository.findByUsernameAndPassword(username, password);
    }
    public static void loginUser(ActionEvent event, String username, String password) {
        Optional<Client> userOptional = clientRepository.findByUsernameAndPassword(username, password);

        if (userOptional.isPresent()) {
            System.out.println("Login successful for user: " + username);
            changeScene(event, "PortfolioView.fxml", username, password, PortfolioController.class);
        } else {
            System.out.println("Invalid credentials for user: " + username);
        }
    }

}

