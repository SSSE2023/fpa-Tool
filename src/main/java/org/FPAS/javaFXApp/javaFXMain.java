package org.FPAS.javaFXApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class javaFXMain extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(javaFXMain.class.getResource("/view/AuthenticationView2.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }
}
