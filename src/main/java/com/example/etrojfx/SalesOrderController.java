package com.example.etrojfx;

import com.example.etrojfx.Globals.Global;
import com.example.etrojfx.HelperFunctions.Helpers;
import com.example.etrojfx.Models.Product;
import com.example.etrojfx.Models.SalesOrder;
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

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class SalesOrderController implements Initializable {
    public Button homeBtn;
    public Button warehouseBtn;
    public Button salesOrderBtn;
    public Button supplierBtn;
    public Button logoutBtn;
    public TableView salesOrderTable;
    public TableColumn itemNo;
    public TableColumn Size;
    public TableColumn Quantity;
    public TableColumn Price;
    public TableColumn Address;

    private ArrayList<SalesOrder> SalesOrderArray = new ArrayList<>(Arrays.asList(new SalesOrder("PK0900",12.0,14.0,4200,"New Abad,Kot Radha Kishen"),
            new SalesOrder("SR4343",36.0,5.0,2300,"DHA Phase 5,D-BLOCK,lahore"),
            new SalesOrder("PO8999",28.0,3.0,1900,"IQBAL TOWN,B-Block,Karachi")));
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
        stage.setTitle("ETRO Clothing");
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        FileOutputStream file = null;
        try {
            file = new FileOutputStream("H:\\Second Semester\\OOP\\Etrojfx-master\\src\\main\\resources\\com\\example\\DataFiles\\SalesOrder.txt",false);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(SalesOrderArray);
            out.flush();
            out.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        itemNo.setCellValueFactory(new PropertyValueFactory<>("ItemNo"));
        Size.setCellValueFactory(new PropertyValueFactory<>("Size"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        Price.setCellValueFactory(new PropertyValueFactory<>("Price"));
        Address.setCellValueFactory(new PropertyValueFactory<>("Address"));
        ArrayList<SalesOrder> orders = new ArrayList<>();
        ObservableList<SalesOrder> SalesOrderModel = FXCollections.observableArrayList();
        try {
            FileInputStream inputfile = new FileInputStream("H:\\Second Semester\\OOP\\Etrojfx-master\\src\\main\\resources\\com\\example\\DataFiles\\SalesOrder.txt");
            ObjectInputStream in = new ObjectInputStream(inputfile);
            orders = (ArrayList<SalesOrder>) in.readObject();
            SalesOrderModel = FXCollections.observableArrayList(orders);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        //setting the data in the rows
        salesOrderTable.setItems(SalesOrderModel);
    }

}
