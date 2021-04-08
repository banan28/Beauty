package com.example.superpharm;

import android.graphics.Bitmap;

public class Lip extends MainProduct {
    public Lip(String type, String color, Double size, Bitmap bt, int price) {
        this.type = type;
        this.color = color;
        this.size = size;
        this.bt = bt;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    String color;

    public Bitmap getBt() {
        return bt;
    }

    public void setBt(Bitmap bt) {
        this.bt = bt;
    }

    Bitmap bt;

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    Double size;
}
