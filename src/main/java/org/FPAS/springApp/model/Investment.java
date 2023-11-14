package org.FPAS.springApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Investment {
    @Id
    @GeneratedValue
    private long investmentID;
    private String name;
    private String symbol; //AAPL , TSL
    private int quantity;
    private double purchasePrice;
    private String purchaseDate;
    private String investmentType;

    // Add any other necessary fields - Easwar your job
}
