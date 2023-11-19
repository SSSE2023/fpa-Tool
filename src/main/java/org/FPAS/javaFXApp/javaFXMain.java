package org.FPAS.javaFXApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.FPAS.springApp.SpringManager;

public class javaFXMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(javaFXMain.class.getResource("/view/authenticationView2.fxml"));
        SpringManager.
                startSpringApp();

        Scene scene = new Scene(loader.load());
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.setOnCloseRequest(event ->{
            javafx.application.Platform.exit();
            SpringManager.stopSpringApp();
        });

    }


}
