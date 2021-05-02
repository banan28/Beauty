package com.example.superpharm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class Payment extends AppCompatActivity {
    private TextView txPrice;
    private EditText txNum;
    private EditText cvv;
    private EditText exp;
    private EditText adr;
    private Button btn;
    private String type;
    private Button bagBtn;
    private List lst;
    private MainAdapter adapter;
    private String name;
    String address;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private FirebaseFirestore firestore;
    private DocumentReference documentReference;
    static final String KEY_AD = "Address";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        txPrice = findViewById(R.id.txtPrice);
        txNum = findViewById(R.id.edtNum);
        bagBtn = findViewById(R.id.btnAddToBag);
        cvv = findViewById(R.id.edtCvv);
        exp = findViewById(R.id.edtDate);
        adr = findViewById(R.id.edtAddress);
        btn = findViewById(R.id.btnPay);
        firebaseAuth = FirebaseAuth.getInstance();
        firestore = FirebaseFirestore.getInstance();
        user= firebaseAuth.getCurrentUser();
        documentReference = firestore.document("users/"+user.getUid().toString());
        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                             address = documentSnapshot.getString(KEY_AD);
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    DialogClass dd = new DialogClass("success","order completed /n" +
                                            "will be shipped to the following address /n" +
                                            address ,"ok");
                                    dd.show(getSupportFragmentManager(), "Success");
                                }
                            });
                        } else {
                            // Toast.makeText(MainActivity.this, "Document does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //  Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                        //Log.d(TAG, e.toString());
                    }
                });
        Intent it = getIntent();
        txPrice.setText(String.valueOf(it.getStringExtra("Price")));
        type = it.getStringExtra("Type");
        bagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}