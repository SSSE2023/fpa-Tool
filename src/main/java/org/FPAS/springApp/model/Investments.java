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
public class Investments {
    @Id
    private String symbol;
    private String name;
    private String investmentType;
    private int price_2022;
    private int price_2021;
    private int price_2020;
    private int price_2023_Q1;
    private int price_2023_Q2;
    private int price_2023_Q3;
    private int risk_rating;
}
