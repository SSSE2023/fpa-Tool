package org.FPAS;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.FPAS.model.*;
import org.h2.tools.Server;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
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

    public static void main(String[] args) throws SQLException {
        startDatabase();
        launch(args);
        // Create instances of the User class using the constructor
        User user1 = new User("john_doe123", "password123", 189, "john.doe@example.com", "user");
        User user2 = new User("admin", "admin_password", 122, "admin@example.com", "admin");
        User user3 = new User("lea_smith96", "br%646#472hfg", 398, "lea.smith96@example.com", "user");
        User user4 = new User("robert_brown85", "4&89bgu31t9", 405, "robert.brown85@example.com", "user");
        User user5 = new User("aasya_lee001", "r$bi5bi33ui@i", 215, "aasya.lee01@example.com", "user");

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

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.fredericci.pu");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.persist(user4);
        entityManager.persist(user5);
        entityManager.getTransaction().commit();
        stopDatabase();

    }
    private static Server s = new Server();
    private static void startDatabase() throws SQLException {
        s.runTool("-tcp", "-web", "-ifNotExists");
    }

    private static void stopDatabase()  {
        s.shutdown();
    }
}

