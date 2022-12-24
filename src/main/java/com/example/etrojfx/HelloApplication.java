//SP22-BCS-078 (ALI HAMZA) & SP22-BCS-081 (FAIZAN MEHMOOD)


package com.example.etrojfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        Image image =new Image("H:\\Second Semester\\OOP\\Etrojfx-master\\src\\main\\resources\\com\\example\\pic\\loooosisnovjNV.jpg");
        stage.getIcons().add(image);
        stage.setTitle("ETRO Clothing");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}