package com.example.superpharm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class facePge extends AppCompatActivity {
    private ListView products;
    private List<Face> faceList;
    public static Face face;
    private Bitmap bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lip_page);
        products = findViewById(R.id.lipList);
        faceList = new ArrayList<Face>();
        Face fc = new Face("waterproof","red", 10.00, BitmapFactory.decodeResource(getResources(),R.drawable.fd1),15);
        faceList.add(fc);
        Face fc1 = new Face("waterproof","red", 10.00, BitmapFactory.decodeResource(getResources(),R.drawable.fd2),15);
        faceList.add(fc1);
        Face fc2 = new Face("waterproof","red", 10.00, BitmapFactory.decodeResource(getResources(),R.drawable.fd3),15);
        faceList.add(fc2);
        FaceList adapter = new FaceList(facePge.this,faceList);
        products.setAdapter(adapter);
        products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                face = (Face) adapterView.getAdapter().getItem(i);
                Intent intent = new Intent(facePge.this,ItemActivity.class);
                bt = face.bt;
                ByteArrayOutputStream bstream = new ByteArrayOutputStream();
                bt.compress(Bitmap.CompressFormat.PNG,100,bstream);
                byte[] byteArray = bstream.toByteArray();
                String type = face.getType();
                String name = face.name;
                String size = face.getSize().toString();
                String color = face.getSkinTone();
                String price = String.valueOf(face.price);
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