package com.example.angelagamefinale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class Sconfitta extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sconfitta);
        Button btnhome=findViewById(R.id.btnHome);
        ImageView imgIndietro=findViewById(R.id.imgIndietro);
        btnhome.setOnClickListener(new Listener(this));
        imgIndietro.setOnClickListener(new Listener(this));
    }
}
