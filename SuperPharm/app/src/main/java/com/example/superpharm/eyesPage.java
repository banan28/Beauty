package com.example.superpharm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class eyesPage extends AppCompatActivity {
    private ListView products;
    private List<Eyes> eyesList;
    public static Eyes eye;
    private Bitmap bt;
    private Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eyes_page);
        btnBuy = findViewById(R.id.btnBuy);
        products = findViewById(R.id.eyesList);
        eyesList = new ArrayList<Eyes>();
        Eyes ey = new Eyes("eye","black",10.00, BitmapFactory.decodeResource(getResources(),R.drawable.fr1),12.00);
        eyesList.add(ey);
        Eyes ey1 = new Eyes("eye","black",10.00, BitmapFactory.decodeResource(getResources(),R.drawable.fr2),20.00);
        eyesList.add(ey1);
        Eyes ey2 = new Eyes("eye","black",10.00, BitmapFactory.decodeResource(getResources(),R.drawable.fr3),20.00);
        eyesList.add(ey2);
        final EyesList adapter = new EyesList(eyesPage.this, eyesList);
        products.setAdapter(adapter);
        products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                eye = (Eyes) adapterView.getAdapter().getItem(i);
                Intent intent = new Intent(eyesPage.this,ItemActivity.class);
                bt = eye.getBt();
                ByteArrayOutputStream bstream = new ByteArrayOutputStream();
                bt.compress(Bitmap.CompressFormat.PNG,100,bstream);
                byte[] byteArray = bstream.toByteArray();
                String type = eye.getType();
                String name = eye.name;
                String size = eye.getSize().toString();
                String color = eye.getColor();
                String price = String.valueOf(eye.getPrice());
                intent.putExtra("Type",type);
                intent.putExtra("Size",size);
                intent.putExtra("Color",color);
                intent.putExtra("Name",name);
                intent.putExtra("Price",price);
                intent.putExtra("Image",byteArray);
                startActivity(intent);
            }
        });

    }
}