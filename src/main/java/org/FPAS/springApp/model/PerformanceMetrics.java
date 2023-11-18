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

    private int client_id;
    private double overallReturn;
    private double return_2020;
    private double return_2021;
    private double return_2022;
    private double return_2023;
    private double standardDeviation;
}
