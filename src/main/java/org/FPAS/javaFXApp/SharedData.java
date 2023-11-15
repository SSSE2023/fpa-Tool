package org.FPAS.javaFXApp;

public class SharedData {
    private static String username;
    private static String password;

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setCredentials(String newUsername, String newPassword) {
        username = newUsername;
        password = newPassword;
    }
}
