package com.example.superpharm;

import android.graphics.Bitmap;

public class Face extends  MainProduct{
    public Face(String type, String skinTone, Double size, Bitmap bt, int price, int qt, String t, String nn) {
        this.type = type;
        this.skinTone = skinTone;
        this.size = size;
        this.bt = bt;
        this.price = price;
        this.quantity =qt;
        this.tType = t;
        this.nameOf = nn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;

    public String getSkinTone() {
        return skinTone;
    }

    public void setSkinTone(String skinTone) {
        this.skinTone = skinTone;
    }

    String skinTone;

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    Double size;
}
