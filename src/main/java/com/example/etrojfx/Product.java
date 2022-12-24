package com.example.etrojfx;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.net.URL;
import java.util.ResourceBundle;

public class Product {
    private SimpleStringProperty ItemNo;
    private SimpleStringProperty Manufacturer;

    private SimpleDoubleProperty Size;
    private SimpleDoubleProperty CostPerItem;
    private SimpleDoubleProperty StockQty;
    private SimpleDoubleProperty InventryValue;

    public Product(String itemNo, String manufacturer, double size, double costPerItem, double stockQty, double inventryValue) {
        ItemNo = new SimpleStringProperty(itemNo);
        Manufacturer =new SimpleStringProperty(manufacturer);
        Size = new SimpleDoubleProperty(size);
        CostPerItem = new SimpleDoubleProperty(costPerItem);
        StockQty = new SimpleDoubleProperty(stockQty);
        InventryValue = new SimpleDoubleProperty(inventryValue);
    }

    public String getItemNo() {
        return ItemNo.get();
    }


    public void setItemNo(String itemNo) {
        this.ItemNo.set(itemNo);
    }

    public String getManufacturer() {
        return Manufacturer.get();
    }



    public void setManufacturer(String manufacturer) {
        this.Manufacturer.set(manufacturer);
    }

    public double getSize() {
        return Size.get();
    }

    public void setSize(double size) {
        this.Size.set(size);
    }

    public double getCostPerItem() {
        return CostPerItem.get();
    }


    public void setCostPerItem(double costPerItem) {
        this.CostPerItem.set(costPerItem);
    }

    public double getStockQty() {
        return StockQty.get();
    }


    public void setStockQty(double stockQty) {
        this.StockQty.set(stockQty);
    }

    public double getInventryValue() {
        return InventryValue.get();
    }

    public void setInventryValue(double inventryValue) {
        this.InventryValue.set(inventryValue);
    }
}
