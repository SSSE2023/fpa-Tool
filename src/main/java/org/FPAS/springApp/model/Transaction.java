package org.FPAS.springApp.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Transaction {
    @Id
    @GeneratedValue
    private long transactionID;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
    private String transaction_year;
    private String transaction_type;
    private double transaction_amount;

}