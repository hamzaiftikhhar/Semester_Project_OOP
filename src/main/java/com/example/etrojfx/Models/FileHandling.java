package com.example.etrojfx.Models;

import com.example.etrojfx.Product;

import java.io.*;
import java.util.ArrayList;

public class FileHandling {
    public static void writeToFile(Product product){
        FileOutputStream file = null;
        try {
            file = new FileOutputStream("src/main/resources/com/example/DataFiles/Warehouse.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(product);
            out.flush();
            out.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Product> readFromFile(){
        ArrayList<Product> arrayList = new ArrayList<>();

        FileInputStream file = null;
        try {
            file = new FileInputStream("src/main/resources/com/example/DataFiles/Warehouse.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            while(in.readObject() != null) {
               arrayList.add((Product) in.readObject());
           }

            in.close();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        return arrayList;
    }
}
