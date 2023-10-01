package org.FPAS.model;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    private List<Investment> investments;
    private List<Transaction> transactions;

    public Portfolio(List<Investment> investments, List<Transaction> transactions) {
        this.investments = investments;
        this.transactions = transactions;
    }

    // Add a new investment to the portfolio
    public void addInvestment(Investment investment) {
        investments.add(investment);
    }

    // Update an existing investment in the portfolio
    public void updateInvestment(Investment updatedInvestment) {
        for (Investment investment : investments) {
            if (investment.getSymbol().equals(updatedInvestment.getSymbol())) {
                // Update investment details (e.g., quantity, purchase price)
                investment.setQuantity(updatedInvestment.getQuantity());
                investment.setPurchasePrice(updatedInvestment.getPurchasePrice());
                investment.setPurchaseDate(updatedInvestment.getPurchaseDate());
                investment.setInvestmentType(updatedInvestment.getInvestmentType());
                break;
            }
        }
    }

    // Get transaction history for a specific investment
    public List<Transaction> getTransactionHistory(String symbol) {
        List<Transaction> history = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getInvestment().getSymbol().equals(symbol)) {
                history.add(transaction);
            }
        }
        return history;
    }

    // Remove an investment from the portfolio
    public void removeInvestment(String symbol) {
        investments.removeIf(investment -> investment.getSymbol().equals(symbol));
    }

    // Get a list of all investments in the portfolio
    public List<Investment> getAllInvestments() {
        return investments;
    }
    // Add a new transaction to the transaction history
    public  void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }


    // Calculate the total portfolio value
    public double calculatePortfolioValue() {
        double totalValue = 0.0;
        for (Investment investment : investments) {
            totalValue += investment.getQuantity() * investment.getPurchasePrice();
        }
        return totalValue;
    }
    // Calculate the total investment value for a specific investment
    public double calculateInvestmentValue(String symbol) {
        double totalValue = 0.0;
        for (Investment investment : investments) {
            if (investment.getSymbol().equals(symbol)) {
                totalValue += investment.getQuantity() * investment.getPurchasePrice();
            }
        }
        return totalValue;
    }


}
