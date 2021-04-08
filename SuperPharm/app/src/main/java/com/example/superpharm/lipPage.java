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

public class lipPage extends AppCompatActivity {
    private ListView products;
    private List<Lip> lipList;
    public static Lip lip;
    private Bitmap bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lip_page);

        products = findViewById(R.id.lipList);
        lipList = new ArrayList<Lip>();
        Lip lp = new Lip("waterproof","red", 10.00, BitmapFactory.decodeResource(getResources(),R.drawable.lp1),10);
        lipList.add(lp);
        Lip lp1 = new Lip("waterproof","red", 10.00, BitmapFactory.decodeResource(getResources(),R.drawable.lp2),10);
        lipList.add(lp1);
        //Lip lp2 = new Lip("waterproof","red", 10.00, BitmapFactory.decodeResource(getResources(),R.drawable.lp3),10);
        //lipList.add(lp2);
        LipList adapter = new LipList(lipPage.this, lipList);
        products.setAdapter(adapter);
        products.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                lip = (Lip) adapterView.getAdapter().getItem(i);
                NameOfRunnable.run();

            }
        });
    }
    public Runnable NameOfRunnable = new Runnable()
    {

        @Override
        public void run()
        {
            while (true)
            {
                // TODO add code to refresh in background
                try
                {

                    Thread.sleep(100);// sleeps 1 second

                    Intent intent = new Intent(lipPage.this,ItemActivity.class);
                    bt = lip.getBt();
                    ByteArrayOutputStream bstream = new ByteArrayOutputStream();
                    bt.compress(Bitmap.CompressFormat.PNG,100,bstream);
                    byte[] byteArray = bstream.toByteArray();
                    String type = lip.getType();
                    String name = lip.name;
                    String size = lip.getSize().toString();
                    String color = lip.getColor();
                    String price = String.valueOf(lip.price);
                    intent.putExtra("Type",type);
                    intent.putExtra("Size",size);
                    intent.putExtra("Color",color);
                    intent.putExtra("Name",name);
                    intent.putExtra("Price",price);
                    intent.putExtra("Image",byteArray);
                    startActivity(intent);
                    Thread.sleep(100);// sleeps 1 second
                } catch (InterruptedException e){
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        }
    };

    }
