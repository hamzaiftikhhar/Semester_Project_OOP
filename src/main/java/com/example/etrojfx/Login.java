package com.example.etrojfx;

import com.example.etrojfx.Globals.Global;
import com.example.etrojfx.HelperFunctions.Helpers;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.ArrayList;

public class Login {
    public TextField tfName;
    public PasswordField pass;
    public Button Login;
    public Button CreateNowBtn;
    private Stage stage;
    @FXML
    protected void loginBtnAction(ActionEvent event) throws IOException {
        String userName = tfName.getText();
        String Password = pass.getText();

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader( "H:\\Second Semester\\OOP\\Etrojfx-master\\src\\main\\resources\\com\\example\\DataFiles\\Users.txt"));
            String line = br.readLine();
            boolean flag = false;
            while (line != null) {
                String[] users = line.split(" ");
                if(userName.equals(users[1]) && Password.equals(users[2])){
                    flag = true;
                }
                line = br.readLine();
            }
            if(!flag){
                Helpers.showAlert("username or password is incorrect! ");
                return;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("Home.fxml"));
        stage = (Stage) Login.getScene().getWindow();

        Scene scene = new Scene(fxmlLoader.load());
        //stage.setTitle("ETRO Clothing");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void CreateNowBtn(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("Register.fxml"));
        stage = (Stage) CreateNowBtn.getScene().getWindow();

        Scene scene = new Scene(fxmlLoader.load());
        //stage.setTitle("ETRO Clothing");
        stage.setScene(scene);
        stage.show();

       //welcomeText.setText("Welcome to JavaFX Application!");
    }
}
