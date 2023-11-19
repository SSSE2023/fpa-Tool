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
public class Portfolio {
    @Id
    @GeneratedValue
    private long investmentID;
    private String name;
    private String symbol;
    private int quantity;
    private double purchasePrice;
    private String purchaseYear;
    private String investmentType;
    private long client_id;


}
