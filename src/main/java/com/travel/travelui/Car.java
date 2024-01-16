package com.travel.travelui;

public class Car {
    String name;
    String size;
    int price;
    Car(String name, String size, int price){
        this.name = name;
        this.size = size;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public String getSize() {
        return size;
    }
    public int getPrice() {
        return price;
    }
}
