package com.example.etrojfx.Models;

import java.io.Serializable;

public class SalesOrder implements Serializable {
    public String itemNo;
    public double Size;
    public double Quantity;
    public double Price;
    public String Address;

    public SalesOrder(String itemNo, double size, double quantity, double price, String address) {
        this.itemNo = itemNo;
        Size = size;
        Quantity = quantity;
        Price = price;
        Address = address;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public double getSize() {
        return Size;
    }

    public void setSize(double size) {
        Size = size;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getAddress() {return Address;}

    public void setAddress(String address) {
        Address = address;
    }
}
