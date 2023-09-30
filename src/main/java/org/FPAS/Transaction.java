package org.FPAS;
import java.util.List;
import java.util.ArrayList;

public class Transaction {
    private int transactionID;
    private Investment investment;
    private String transactionDate;
    private String transactionType;
    private double transactionAmount;


    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Transaction(int transactionID, Investment investment, String transactionDate, String transactionType, double transactionAmount) {
        this.transactionID = transactionID;
        this.investment = investment;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    // Add a new transaction to the transaction history
    public void addTransactionToPortfolio(Portfolio portfolio, Transaction transaction) {
        portfolio.addTransaction(transaction);
    }

}
