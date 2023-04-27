package org.example;

public class Product {
    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private  String name;
    private  int ID;
    private double price;
    public Product(String name, int ID, double price) {
        this.name = name;
        this.ID = ID;
        this.price = price;
    }

    public int getId() {

        return ID;
    }
}
