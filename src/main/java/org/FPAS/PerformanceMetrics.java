package org.FPAS;
import java.util.List;
import java.util.ArrayList;

public class PerformanceMetrics {
    private Portfolio portfolio;

    public PerformanceMetrics(Portfolio portfolio) {
        this.portfolio = portfolio;
    }
    /* To-do Methods for calculating performance metrics */
    // Calculate the overall return of the portfolio
    public double calculateOverallReturn() {
        double initialInvestment = 0.0;
        double currentPortfolioValue = portfolio.calculatePortfolioValue();
        for (Transaction transaction : portfolio.getAllTransactions()) {
            if (transaction.getTransactionType().equals("buy")) {
                initialInvestment += transaction.getTransactionAmount();
            }
        }

        if (initialInvestment == 0.0) {
            return 0.0; // No initial investment, return is zero
        }

        return ((currentPortfolioValue - initialInvestment) / initialInvestment) * 100;
    }

    // Calculate the standard deviation of returns for the portfolio
    public double calculateStandardDeviation() {
        // Implement standard deviation calculation based on historical returns
        //  will need to retrieve historical returns data from your transactions
        // and perform the necessary calculations.
        List<Double> returns = new ArrayList<>();
        for (Transaction transaction : portfolio.getAllTransactions()) {
            if (transaction.getTransactionType().equals("buy")) {
                // Calculate returns based on changes in investment value
                double initialInvestmentValue = transaction.getTransactionAmount();
                double currentInvestmentValue = portfolio.calculateInvestmentValue(transaction.getInvestment().getSymbol());
                double returnPercentage = ((currentInvestmentValue - initialInvestmentValue) / initialInvestmentValue) * 100;
                returns.add(returnPercentage);
            }
        }

        if (returns.isEmpty()) {
            return 0.0; // No returns data available
        }

        // Calculate standard deviation from returns data
        double mean = calculateMean(returns);
        double sumOfSquaredDifferences = 0.0;

        for (double returnPercentage : returns) {
            sumOfSquaredDifferences += Math.pow(returnPercentage - mean, 2);
        }

        double variance = sumOfSquaredDifferences / returns.size();
        return Math.sqrt(variance);
    }

    // Calculate the mean (average) of a list of values
    private double calculateMean(List<Double> values) {
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }

}
