package org.FPAS.springApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue
    private long transactionID;

    @ManyToOne
    @JoinColumn(name = "investment_id")  // Adjust the column name based on your database schema
    private Investment investment;

    private String transactionDate;
    private String transactionType; // Buy or sell
    private double transactionAmount;

    // Add any other necessary fields
}
