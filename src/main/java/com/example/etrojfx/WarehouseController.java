
package com.example.etrojfx;

import com.example.etrojfx.HelperFunctions.Helpers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class WarehouseController implements Initializable {
    public TableView<Product> table;
    public TableColumn itemNo;
    public TableColumn Manufacturer;
    public TableColumn Size;
    public TableColumn Cost;
    public TableColumn Stock;
    public TableColumn Inventry;

    public Button homeBtn;
    public Button warehouseBtn;
    public Button salesOrderBtn;
    public Button supplierBtn;
    public Button logoutBtn;
    public TextField  userField8;
   // public TextField EditInfo(String s){
public void AddInfo(){
    Stage stage = new Stage();
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(30));
    Image image =new Image("H:\\Second Semester\\OOP\\Etrojfx-master\\src\\main\\resources\\com\\example\\pic\\loooosisnovjNV.jpg");
    stage.getIcons().add(image);
    stage.setTitle("Ware House");
    grid.setHgap(15);
    grid.setVgap(10);
    grid.setAlignment(Pos.BASELINE_LEFT);


    //On the Layout
    Text heading = new Text("Ware House Entries");
    heading.setFont(Font.font(10));


    heading.setFont(Font.font(18));
    grid.add(heading, 0,0,2,1);

    Label userLabel = new Label("Item No ");
    grid.add(userLabel, 0,2);

    TextField userField = new TextField();
    grid.add(userField, 1,2);

    Label genderLabel = new Label("Manufacturer");
    grid.add(genderLabel,0,3);
    TextField userField1 = new TextField();
    grid.add(userField1, 1,3);
    Label userLabel2 = new Label("Size");
    grid.add(userLabel2, 0,4);
    TextField userField2 = new TextField();
    grid.add(userField2, 1,4);
    Label userLabel3 = new Label("Cost");
    grid.add(userLabel3, 0,5);
    TextField userField3 = new TextField();
    grid.add(userField3, 1,5);
    Label userLabel4 = new Label("Stock");
    grid.add(userLabel4, 0,6);

    TextField userField4 = new TextField();
    grid.add(userField4, 1,6);
    Label userLabel5 = new Label("Inventry");
    grid.add(userLabel5, 0,7);

    TextField userField5 = new TextField();
    grid.add(userField5, 1,7);

    /////////////////////////////////////


    Button btn2 = new Button("Add");
    grid.add(btn2,1,8);


//ArrayList<TextField> addition = new ArrayList<>(Arrays.asList(new TextField(userField,userField1,userField2)));

    Scene scene = new Scene(grid,300,400);
    stage.setScene(scene);
    stage.show();
    btn2.setOnAction(e ->{
            userField.getText();
            userField1.getText();
            userField2.getText();


            }
    );
   // return userField;

}

    private ArrayList<Product> productsArray = new ArrayList<>(Arrays.asList(new Product("B24","Local",12.00,2200.00,6.0,12000.00),
                    new Product("S78","International",24.00,4000.00,3.0,96000.00),
                    new Product("H12","Local",42.00,3500.00,6.0,375000.00) ));




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
    public void initialize(URL url, ResourceBundle resourceBundle)  {
        FileOutputStream file = null;
        try {
            file = new FileOutputStream("H:\\Second Semester\\OOP\\Etrojfx-master\\src\\main\\resources\\com\\example\\DataFiles\\Warehouse.txt",false);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(productsArray);
            out.flush();
            out.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        itemNo.setCellValueFactory(new PropertyValueFactory<>("ItemNo"));
        Manufacturer.setCellValueFactory(new PropertyValueFactory<>("Manufacturer"));
        Size.setCellValueFactory(new PropertyValueFactory<>("Size"));
        Cost.setCellValueFactory(new PropertyValueFactory<>("CostPerItem"));
        Stock.setCellValueFactory(new PropertyValueFactory<>("StockQty"));
        Inventry.setCellValueFactory(new PropertyValueFactory<>("InventryValue"));
        ArrayList<Product> products = new ArrayList<>();
        ObservableList<Product> ProductModel = FXCollections.observableArrayList();
        try {
            FileInputStream inputfile = new FileInputStream("H:\\Second Semester\\OOP\\Etrojfx-master\\src\\main\\resources\\com\\example\\DataFiles\\Warehouse.txt");
            ObjectInputStream in = new ObjectInputStream(inputfile);
            products = (ArrayList<Product>) in.readObject();
            ProductModel = FXCollections.observableArrayList(products);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        // Method for deserialization of object
        table.setItems(ProductModel);
    }

    public void editableView(){
        Product editProduct = table.getSelectionModel().getSelectedItem();


    }

//    public void EditInfo(ActionEvent actionEvent) throws IOException {
////        Stage stage = new Stage();
////
////        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Delete.fxml"));
////
////        Scene scene = new Scene(fxmlLoader.load());
////        Image image =new Image("H:\\Second Semester\\OOP\\Etrojfx-master\\src\\main\\resources\\com\\example\\pic\\loooosisnovjNV.jpg");
////        stage.getIcons().add(image);
////        stage.setTitle("ETRO Clothing");
////        stage.setScene(scene);
////        stage.show();
//
//        Stage stage = new Stage();
//        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(30));
//        Image image =new Image("H:\\Second Semester\\OOP\\Etrojfx-master\\src\\main\\resources\\com\\example\\pic\\loooosisnovjNV.jpg");
//        stage.getIcons().add(image);
//        stage.setTitle("Ware House");
//        grid.setHgap(15);
//        grid.setVgap(10);
//        grid.setAlignment(Pos.BASELINE_LEFT);
//
//
//        //On the Layout
//        Text heading = new Text("Enter Item No To Delete ");
//        heading.setFont(Font.font(10));
//
//
//        heading.setFont(Font.font(18));
//        grid.add(heading, 0,0,2,1);
//
//        Label userLabel = new Label("Item No ");
//        grid.add(userLabel, 0,2);
//
//        TextField userField = new TextField();
//        grid.add(userField, 1,2);
//        Button btn2 = new Button("Delete");
//        grid.add(btn2,1,3);
//        String deleteField = null;
//        btn2.setOnAction(e->   userField.getText()
//        );
//
//        Scene scene = new Scene(grid,300,400);
//        stage.setScene(scene);
//        stage.show();
//  //      int selectedId = table.getVisibleLeafIndex(Product);
//
//
//
//    }


    public void deleteItem(ActionEvent actionEvent) {

    }
}
