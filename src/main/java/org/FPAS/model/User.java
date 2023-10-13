package org.FPAS.model;

import javax.persistence.*;

@Entity
public class User {
    private String username;
    private String password;
    @Id
    private int userID;
    private String email;
    private String role;

    public User() {

    }

    @Basic
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String username, String password, int userID, String email, String role) {
        this.username = username;
        this.password = password;
        this.userID = userID;
        this.email = email;
        this.role = role;
    }


}
