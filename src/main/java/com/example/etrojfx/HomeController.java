package com.example.etrojfx;


import com.example.etrojfx.HelperFunctions.Helpers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController {

    public Button homeBtn;
    public Button warehouseBtn;
    public Button salesOrderBtn;
    public Button supplierBtn;
    public Button logoutBtn;


    @FXML
    protected void NavigateToWarehouse(ActionEvent event) throws IOException {
        Stage stage = null;
        Parent myNewScene = null;

        if (event.getSource() == homeBtn){
            stage = (Stage) homeBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("Home.fxml"));

        } else if (event.getSource() == warehouseBtn){
            stage = (Stage) warehouseBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("Warehouse.fxml"));

        } else if (event.getSource() == salesOrderBtn) {
            stage=(Stage) salesOrderBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("SalesOrder.fxml"));

        }
        else if (event.getSource() == supplierBtn) {
            stage=(Stage) supplierBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("SupplierContact.fxml"));


        }
        else if (event.getSource() == logoutBtn) {
            Helpers.showAlert("Are you really want to exit?");
            stage = (Stage) logoutBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("Login.fxml"));

        }


        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);

        stage.setTitle("ETRO Clothing");

        stage.show();   

    }
}
