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
public class PerformanceMetrics {
    @Id
    @GeneratedValue
    private long metricsID;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private double overallReturn;
    private double standardDeviation;

    // Add any other necessary fields or methods
}
