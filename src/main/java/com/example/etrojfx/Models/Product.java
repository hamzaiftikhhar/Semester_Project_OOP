package com.example.etrojfx.Models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;
import java.net.URL;
import java.util.ResourceBundle;

public class Product implements Serializable {
    private String ItemNo;
    private String Manufacturer;
    private Double Size;
    private Double CostPerItem;
    private Double StockQty;
    private Double InventryValue;

    public Product(String itemNo, String manufacturer, Double size, Double costPerItem, Double stockQty, Double inventryValue) {
        ItemNo = itemNo;
        Manufacturer = manufacturer;
        Size = size;
        CostPerItem = costPerItem;
        StockQty = stockQty;
        InventryValue = inventryValue;
    }

    public String getItemNo() {
        return ItemNo;
    }

    public void setItemNo(String itemNo) {
        ItemNo = itemNo;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        Manufacturer = manufacturer;
    }

    public Double getSize() {
        return Size;
    }

    public void setSize(Double size) {
        Size = size;
    }

    public Double getCostPerItem() {
        return CostPerItem;
    }

    public void setCostPerItem(Double costPerItem) {
        CostPerItem = costPerItem;
    }

    public Double getStockQty() {
        return StockQty;
    }

    public void setStockQty(Double stockQty) {
        StockQty = stockQty;
    }

    public Double getInventryValue() {
        return InventryValue;
    }

    public void setInventryValue(Double inventryValue) {
        InventryValue = inventryValue;
    }
}
