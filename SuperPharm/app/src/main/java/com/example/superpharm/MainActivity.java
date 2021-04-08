package com.example.superpharm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    private EditText etMail;
    private EditText etPass;
    private TextView txtLog;
    private Button btnLog;
    private TextView txSign;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMail = (EditText) findViewById(R.id.txEmail);
        etPass = (EditText) findViewById(R.id.txPass);
        btnLog = (Button) findViewById(R.id.btnDone);
        txtLog = (TextView) findViewById(R.id.txSignUp);
        txSign = findViewById(R.id.txSignUp);
        txSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignAct.class));
            }
        });
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null){
            startActivity(new Intent(MainActivity.this, MaiScreen.class));
        }
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(etMail.getText().toString(), etPass.getText().toString());
            }
        });
        txtLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(MainActivity.this, SignAct.class));

            }
        });
    }
    private void validate(String userName1, String passWord1){
        firebaseAuth.signInWithEmailAndPassword(userName1,passWord1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "LogIn Success!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MaiScreen.class));
                }
                else{
                    Toast.makeText(MainActivity.this, "Failed!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}