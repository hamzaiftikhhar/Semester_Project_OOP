package com.example.etrojfx;

import com.example.etrojfx.Globals.Global;
import com.example.etrojfx.HelperFunctions.Helpers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class RegisterController {

    public Button SignupBtnAction;

    public TextField name;
    public PasswordField pass;
    public PasswordField cPass;
    public TextField email;


    @FXML
    protected void signupAction(ActionEvent event) throws IOException {

        String userName = name.getText();
        String Password = pass.getText();
        String Cpass = cPass.getText();
        if(userName.isEmpty() || Password.isEmpty()){
            Helpers.showAlert("Username or Password cannot be empty!");
            return;
        }
        else if(!Password.equals(Cpass)){
            Helpers.showAlert("Password and Confirm Password Doesn't match! ");
            return;
        }
        Helpers.WriteFile("H:\\Second Semester\\OOP\\Etrojfx-master\\src\\main\\resources\\com\\example\\DataFiles\\Users.txt",userName +" " + email.getText() + " "+ Password + "\n");

        Helpers.showAlert("User Successfully Created! ");


        FXMLLoader fxmlLoader = new FXMLLoader(RegisterController.class.getResource("Login.fxml"));
        Stage stage = (Stage) SignupBtnAction.getScene().getWindow();

        Scene scene = new Scene(fxmlLoader.load());
        //stage.setTitle("ETRO Clothing");
        stage.setScene(scene);
        stage.show();
    }
}
