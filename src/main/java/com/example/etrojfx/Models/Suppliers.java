package com.example.etrojfx.Models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Suppliers {
    private String ItemNo;
    private String Name;
    private String Contact;
    private String Address;

    public Suppliers(String itemNo, String name, String contact, String address) {
        ItemNo = itemNo;
        Name = name;
        Contact = contact;
        Address = address;
    }

    public String getItemNo() {
        return ItemNo;
    }

    public void setItemNo(String itemNo) {
        ItemNo = itemNo;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
