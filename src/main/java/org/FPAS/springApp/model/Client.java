package org.FPAS.springApp.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Client {
    @Id
    @GeneratedValue
    private long uID;
    private String name;
    private String username;
    private String password;
    private String email;


}