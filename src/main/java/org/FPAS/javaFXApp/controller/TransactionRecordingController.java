package org.FPAS.javaFXApp.controller;


import javafx.beans.property.SimpleDoubleProperty;
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
import org.FPAS.springApp.Repository.TransactionRepository;
import org.FPAS.springApp.model.Client;
import org.FPAS.springApp.Repository.PortfolioRepository;
import org.FPAS.springApp.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import static org.FPAS.javaFXApp.FXMLHandler.changeScene;



import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


@Controller
@NoArgsConstructor

public class TransactionRecordingController implements Initializable {
    @FXML
    private Button investmentsButton;
    @FXML
    private Button dashboardButton;
    @FXML
    private Label usernameField;
    @FXML
    private Button Sign_out;
    @FXML
    private TableView<Transaction> investmentTable;
    @FXML
    private TableColumn<Transaction, String> transactionT;

    @FXML
    private TableColumn<Transaction, Double> transactionA;

    @FXML
    private TableColumn<Transaction, String> type;

    public static ClientRepository clientRepository;
    public static PortfolioRepository portfolioRepository;
    public static TransactionRepository transactionRepository;
    @Autowired
    public TransactionRecordingController(ClientRepository clientRepository, PortfolioRepository portfolioRepository, TransactionRepository transactionRepository) {
        TransactionRecordingController.clientRepository = clientRepository;
        TransactionRecordingController.portfolioRepository = portfolioRepository;
        TransactionRecordingController.transactionRepository = transactionRepository;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        investmentsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeScene(event, "InvestmentEntryView.fxml", null, null, InvestmentEntryController.class);
            }
        });
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
        Optional<Client> userOptional = clientRepository.findByUsernameAndPassword(SharedData.getUsername(), SharedData.getPassword());
        userOptional.ifPresent(client -> {usernameField.setText(client.getName());
        });
       initializeTableView();
    }
    private void initializeTableView() {

        Optional<Client> client = clientRepository.findByUsernameAndPassword(SharedData.getUsername(),SharedData.getPassword());
        List<Transaction> TransactionList = transactionRepository.findByClient(client.get());

        transactionT.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTransaction_year()));
        transactionA.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTransaction_amount()).asObject());
        type.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTransaction_type()));

        ObservableList<Transaction> observableList = FXCollections.observableArrayList(TransactionList);
        investmentTable.setItems(observableList);
    }


}
