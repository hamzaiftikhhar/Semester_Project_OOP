package com.example.etrojfx.HelperFunctions;

import com.example.etrojfx.Globals.Global;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class Helpers {
    public static void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert Message");
        alert.setHeaderText(message);
        alert.showAndWait();
    }
    public  static  boolean WriteFile (String FilePath,String Content){
        try {
            FileWriter myWriter = new FileWriter("H:\\Second Semester\\OOP\\Etrojfx-master\\src\\main\\resources\\com\\example\\DataFiles\\Users.txt",true);
            myWriter.write(Content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return false;
        }
    }
}
