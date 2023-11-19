package org.FPAS.javaFXApp;

import lombok.Getter;

public class SharedData {
    @Getter
    private static String username;
    @Getter
    private static String password;

    public static void setCredentials(String newUsername, String newPassword) {
        username = newUsername;
        password = newPassword;
    }
}
