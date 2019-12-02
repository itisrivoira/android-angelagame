package com.example.angelagamefinale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Start extends AppCompatActivity {

    private ImageView imgDado=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button btnGioca=findViewById(R.id.btnGioca);
        Button btnRegole=findViewById(R.id.btnRegole);
        imgDado=findViewById(R.id.imgDado);
        rotateAnimation();
        btnGioca.setOnClickListener(new Listener(this));
        btnRegole.setOnClickListener(new Listener(this));
    }

    private void rotateAnimation() {
        Animation rotateAnimation=AnimationUtils.loadAnimation(this,R.anim.rotate);
        imgDado.startAnimation(rotateAnimation);
    }
}
