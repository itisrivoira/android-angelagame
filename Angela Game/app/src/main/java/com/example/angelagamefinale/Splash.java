package com.example.angelagamefinale;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        int SPLASH_TIME = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mySuperIntent = new Intent(Splash.this,Start.class);
                startActivity(mySuperIntent);
                finish();
            }
        }, SPLASH_TIME);
    }
}
