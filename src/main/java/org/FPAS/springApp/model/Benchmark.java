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
public class Benchmark {
    @Id
    @GeneratedValue
    private long benchmarkID;
    private String name;
    private double benchmarkReturn;
    private int annum;

    // Add any other necessary fields
}
