package com.example.superpharm;

import android.graphics.Bitmap;

public class Eyes extends MainProduct {
    public Eyes(String type, String color, Double size, Bitmap bt, Double price, int qt, String t, String nn) {
        this.type = type;
        this.color = color;
        this.size = size;
        this.bt = bt;
        this.price = price;
        this.quantity = qt;
        this.tType = t;
        this.nameOf = nn;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    Double price;
    String type;
    String color;

    public Bitmap getBt() {
        return bt;
    }

    public void setBt(Bitmap bt) {
        this.bt = bt;
    }

    Bitmap bt;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    Double size;
}
