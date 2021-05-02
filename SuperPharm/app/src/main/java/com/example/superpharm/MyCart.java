package com.example.superpharm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class MyCart extends AppCompatActivity {
    public static ListView lstC;
    public static List ll;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart);
        lstC = findViewById(R.id.listItems);
        bt = findViewById(R.id.btnGet);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent it = new Intent(MyCart.this,Payment.class);

            }
        });
    }
}