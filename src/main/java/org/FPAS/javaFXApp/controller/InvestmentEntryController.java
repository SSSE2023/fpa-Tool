package org.FPAS.javaFXApp.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import lombok.NoArgsConstructor;
import org.FPAS.javaFXApp.SharedData;
import org.FPAS.springApp.Repository.ClientRepository;
import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.model.Portfolio;
import org.FPAS.springApp.Repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.FPAS.javaFXApp.FXMLHandler.changeScene;


import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;



@NoArgsConstructor
@Controller
public class InvestmentEntryController implements Initializable {

    @FXML
    private Button dashboardButton;
    @FXML
    private Label usernameField;
    @FXML
    private Button Sign_out;
    @FXML
    private Button transactionButton;
    @FXML
    private Button investmentsButton;
    @FXML
    private TableView<Portfolio> portfolioTable;
    @FXML
    private TableColumn<Portfolio, String> symbol;

    @FXML
    private TableColumn<Portfolio, String> purchaseYear;

    @FXML
    private TableColumn<Portfolio, Integer> quantity;

    @FXML
    private TableColumn<Portfolio, Double> purchasePrice;

    @FXML
    private TableColumn<Portfolio, String> investmentType;

    public static ClientRepository clientRepository;
    public static PortfolioRepository portfolioRepository;
    @Autowired
    public InvestmentEntryController(ClientRepository clientRepository, PortfolioRepository portfolioRepository) {
        InvestmentEntryController.clientRepository = clientRepository;
        InvestmentEntryController.portfolioRepository = portfolioRepository;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dashboardButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene(event, "PortfolioView.fxml", null, null, PortfolioController.class);
            }
        });
        Sign_out.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene(event, "AuthenticationView2.fxml", null, null, authController.class);
            }
        });
        investmentsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene(event,"InvestmentEntryView.fxml", null, null, InvestmentEntryController.class);
            }
        });
        transactionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene(event, "TransactionRecordingView.fxml", null, null, PortfolioController.class);
            }
        });
        Optional<Client> userOptional = clientRepository.findByUsernameAndPassword(SharedData.getUsername(), SharedData.getPassword());
        userOptional.ifPresent(client -> {
            usernameField.setText(client.getName());
        });
        initializeTableView();
    }

    public void initializeTableView() {

           Optional<Client> client = clientRepository.findByUsernameAndPassword(SharedData.getUsername(),SharedData.getPassword());
           List<Portfolio> portfolioList = portfolioRepository.findByClient(client.get());

           symbol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSymbol()));
           purchaseYear.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPurchaseYear()));
           quantity.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getQuantity()).asObject());
           purchasePrice.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPurchasePrice()).asObject());
           investmentType.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getInvestmentType()));

           ObservableList<Portfolio> observableList = FXCollections.observableArrayList(portfolioList);
           portfolioTable.setItems(observableList);
        }

    }




