package com.example.superpharm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MaiScreen extends AppCompatActivity {
    private Button btnFace;
    private Button btnEyes;
    private Button btnLip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mai_screen);
        btnFace = findViewById(R.id.btnFace);
        btnEyes = findViewById(R.id.btnEyes);
        btnLip = findViewById(R.id.btnLip);
        btnFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MaiScreen.this,facePge.class));
            }
        });
        btnEyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MaiScreen.this,eyesPage.class));
            }
        });
        btnLip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MaiScreen.this,lipPage.class));
            }
        });
    }
}