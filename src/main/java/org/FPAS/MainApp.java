package org.FPAS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.FPAS.model.*;

import java.util.List;
import java.util.ArrayList;


public class MainApp extends Application {
    @Override
    public void start(Stage stage) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/AuthenticationView.fxml"));
            Scene scene = new Scene(loader.load());
            stage.setTitle("Login Page");
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
        // Create instances of the User class using the constructor
        User user1 = new User("john_doe", "password123", 1, "john.doe@example.com", "user");
        User user2 = new User("admin", "admin_password", 2, "admin@example.com", "admin");

        // Create initial investments
        List<Investment> initialInvestments = new ArrayList<>();
        Investment investment1 = new Investment("Company A", "AAPL", 100, 150.0, "2023-09-30", "Stock");
        Investment investment2 = new Investment("Company B", "GOOGL", 50, 2500.0, "2023-09-30", "Stock");
        initialInvestments.add(investment1);
        initialInvestments.add(investment2);

        // Create initial transactions
        List<Transaction> initialTransactions = new ArrayList<>();
        Transaction transaction1 = new Transaction(1, investment1, "2023-09-30", "Buy", 5000.0);
        Transaction transaction2 = new Transaction(2, investment2, "2023-09-30", "Buy", 10000.0);
        initialTransactions.add(transaction1);
        initialTransactions.add(transaction2);

        // Create a portfolio with initial investments and transactions
        Portfolio portfolio = new Portfolio(initialInvestments, initialTransactions);

        // Calculate and print the portfolio value, investment value, and transaction history as before
        double portfolioValue = portfolio.calculatePortfolioValue();
        System.out.println("Portfolio Value: $" + portfolioValue);

        String symbolToCalculate = "AAPL";
        double investmentValue = portfolio.calculateInvestmentValue(symbolToCalculate);
        System.out.println("Investment Value for " + symbolToCalculate + ": $" + investmentValue);

        List<Transaction> transactionHistory = portfolio.getTransactionHistory(symbolToCalculate);
        System.out.println("Transaction History for " + symbolToCalculate + ":");
        for (Transaction transaction : transactionHistory) {
            System.out.println("Transaction ID: " + transaction.getTransactionID() +
                    ", Date: " + transaction.getTransactionDate() +
                    ", Type: " + transaction.getTransactionType() +
                    ", Amount: $" + transaction.getTransactionAmount());
        }
        // Create PerformanceMetrics object with the portfolio
        PerformanceMetrics performanceMetrics = new PerformanceMetrics(portfolio);

        // Calculate and print overall return
        double overallReturn = performanceMetrics.calculateOverallReturn();
        System.out.println("Overall Return: " + overallReturn + "%");

        // Calculate and print standard deviation
        double standardDeviation = performanceMetrics.calculateStandardDeviation();
        System.out.println("Standard Deviation: " + standardDeviation);


    }
}

