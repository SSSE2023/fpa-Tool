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
public class InflationBenchmark {
    @Id
    @GeneratedValue
    private long inflationID;
    private String name;
    private double return_2020;
    private double return_2021;
    private double return_2022;
    private double return_2023;
    // Add any other necessary fields

    public double getAdjustedReturn(String year) {
        switch (year) {
            case "2020":
                return return_2020 + 0.03; // Adjusted return for 2020
            case "2021":
                return return_2021 + 0.04; // Adjusted return for 2021
            case "2022":
                return return_2022 + 0.05; // Adjusted return for 2022
            case "2023":
                return return_2023 + 0.06; // Adjusted return for 2023
            default:
                return 0.0;
        }
    }

}
