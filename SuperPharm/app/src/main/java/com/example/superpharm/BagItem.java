package com.example.superpharm;

import android.graphics.Bitmap;

public class BagItem {
    private Bitmap bt;
    private String pc;

    public BagItem(Bitmap bt, String pc){
        this.bt = bt;
        this.pc = pc;
    }
    public Bitmap getBt(){
        return this.bt;
    }
    public void setBt(Bitmap bt){
        this.bt = bt;
    }
    public String getPc(){
        return this.pc;
    }
    public void setPc(String pc){
        this.pc = pc;
    }
}
