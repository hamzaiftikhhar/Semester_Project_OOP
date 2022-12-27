//SP22-BCS-078 (ALI HAMZA) & SP22-BCS-081 (FAIZAN MEHMOOD)


package com.example.etrojfx;

import com.example.etrojfx.Models.FileHandling;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

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
//        launch();

        FileHandling.writeToFile(new Product("S39","Local",32.00,1200.00,12.0,32000.0));
        FileHandling.writeToFile(new Product("H56","International",42.00,3200.00,12.0,4900.0));

        System.out.println(FileHandling.readFromFile());


        ArrayList<Product> products = FileHandling.readFromFile();
        for (Product p :
                products) {
            System.out.println(p);
        }
    }
}