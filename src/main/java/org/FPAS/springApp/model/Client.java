package org.FPAS.springApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class Client {
    @Id
    @GeneratedValue
    private long uID;
    private String name;
    private String username;
    private String password;
    private String email;
}