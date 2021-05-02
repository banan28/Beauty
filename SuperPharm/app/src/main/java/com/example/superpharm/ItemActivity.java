package com.example.superpharm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {
    private TextView txtName;
    private TextView txtType;
    private TextView txtPrice;
    private TextView txtColor;
    private Button btnBuy;
    private Button btnAdd;
    private ImageView img;
    private Intent intent;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        btnBuy = findViewById(R.id.btnBuy);
        btnAdd = findViewById(R.id.btnAddToBag);
        byte[] byteArray = getIntent().getByteArrayExtra("Image");
        txtName =findViewById(R.id.txtNameItem);
        txtColor = findViewById(R.id.txtColorItem);
        txtType = findViewById(R.id.txtTypeItem);
        txtPrice = findViewById(R.id.txtPriceItem);
        btnBuy = findViewById(R.id.btnBuy);
        btnAdd = findViewById(R.id.btnAddToBag);
        img = findViewById(R.id.imgItem);
        img.setImageBitmap(BitmapFactory.decodeByteArray(byteArray,0,byteArray.length));
        intent= getIntent();
        txtName.setText(intent.getStringExtra("Name"));
        txtColor.setText(intent.getStringExtra("Color"));
        txtPrice.setText(intent.getStringExtra("Price"));
        txtType.setText(intent.getStringExtra("Type"));
        type = intent.getStringExtra("Type");
        btnBuy.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent(ItemActivity.this, Payment.class);
            @Override
            public void onClick(View view) {
                switch (type){
                    case "eye":
                        intent.putExtra("Price",eyesPage.eye.getPrice());
                        intent.putExtra("Name",eyesPage.eye.nameOf);
                        break;
                    case "face":
                         intent.putExtra("Price",facePge.face.price);
                        intent.putExtra("Name",facePge.face.nameOf);
                         break;
                    case "lip":
                        intent.putExtra("Price",lipPage.lip.price);
                        intent.putExtra("Name",lipPage.lip.nameOf);
                        break;
                    default:

                     }
                     startActivity(intent);
                }

        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //add objects to a static arraylist in the cart class
                //save the list in sharedpreferences
            }
        });
    }
}