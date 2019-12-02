package com.example.angelagamefinale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Regole extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regole);
        Button btnHome=findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new Listener(this));
    }
}
