package org.FPAS.springApp.model;

import jakarta.persistence.*;
import lombok.*;
import org.FPAS.javaFXApp.controller.PortfolioController;

import java.util.List;

import static jakarta.persistence.CascadeType.*;


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


    public long getuID() {
        return uID;
    }

    public void setuID(long uID) {
        this.uID = uID;
    }
}