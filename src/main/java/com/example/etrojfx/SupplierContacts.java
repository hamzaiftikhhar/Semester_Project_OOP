package com.example.etrojfx;

import com.example.etrojfx.HelperFunctions.Helpers;
import com.example.etrojfx.Models.Suppliers;
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

public class SupplierContacts implements Initializable {
    public TableView<Suppliers> table;
    public TableColumn ItemNo;
    public TableColumn Name;
    public TableColumn Contact;
    public TableColumn Address;
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
            System.out.println("home");
        } else if (event.getSource() == warehouseBtn){
            stage = (Stage) warehouseBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("Warehouse.fxml"));
            System.out.println("warehouse");
        } else if (event.getSource() == salesOrderBtn) {
            stage=(Stage) salesOrderBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("SalesOrder.fxml"));
            System.out.println("saleorder");
        }
        else if (event.getSource() == supplierBtn) {
            stage=(Stage) supplierBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("SupplierContact.fxml"));
            System.out.println("supplier");
        }
        else if (event.getSource() == logoutBtn) {
            Helpers.showAlert("Are you really want to exit?");
            stage = (Stage) logoutBtn.getScene().getWindow();
            myNewScene = FXMLLoader.load(getClass().getResource("Login.fxml"));
            System.out.println("Logout");
        }

        Scene scene = new Scene(myNewScene);
        stage.setScene(scene);
        stage.setTitle("My New Scene");
        stage.show();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ItemNo.setCellValueFactory(new PropertyValueFactory<>("ItemNo"));
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Contact.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        table.setItems(SupplierContactsModel);
    }


    private ObservableList<Suppliers> SupplierContactsModel = FXCollections.observableArrayList(
            new Suppliers("B24","Mukhtar","03114564233","New Abadi,Kot Radha Kishen"),new Suppliers("L78","Ahmed","03334567899","Bahria Town,Lahore"),
            new Suppliers("H12","WasayCh","035556565734","DHA Phase 3,Lahore"));
}

