package com.example.angelagamefinale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;

public class Game extends AppCompatActivity{

    protected Utente utente;
    protected P101 p101;
    protected Listener listener;
    protected ScrollListener scrollListener;

    protected Button btnInvia=null;
    protected Button btn1=null;
    protected Button btn2=null;
    protected Button btn3=null;
    protected Button btn4=null;
    protected Button btn5=null;
    protected Button btn6=null;
    protected EditText edtMeta=null;
    protected TextView txtSomma=null;
    protected TextView txtGiocUtente=null;
    protected TextView txtGiocP101=null;
    protected ImageView btnHome=null;
    protected ScrollView scroll1=null;
    protected ScrollView scroll2=null;
    protected ScrollView scroll3=null;

    private ArrayList<String> giocUtente=new ArrayList<>();
    private ArrayList<String> giocP101=new ArrayList<>();
    private ArrayList<String> somme=new ArrayList<>();

    protected Integer intGiocUtente=0;
    protected Integer intGiocP101=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        edtMeta=findViewById(R.id.edtMeta);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btnInvia=findViewById(R.id.btnInvia);
        txtSomma=findViewById(R.id.txtSomma1);
        txtGiocUtente=findViewById(R.id.txtGiocUtente1);
        txtGiocP101=findViewById(R.id.txtGiocP101_2);
        scroll1=findViewById(R.id.scroll1);
        scroll2=findViewById(R.id.scroll2);
        scroll3=findViewById(R.id.scroll3);
        btnHome=findViewById(R.id.btnHome);
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);

        utente=new Utente(edtMeta,btn1,btn2,btn3,btn4,btn5,btn6,btnInvia);
        p101=new P101(giocUtente,giocP101,somme,intGiocP101,edtMeta,txtGiocP101,txtGiocUtente,txtSomma,utente,this,scroll1,scroll2,scroll3);
        listener=new Listener(intGiocUtente,intGiocP101,utente,p101,btn1,btn2,btn3,btn4,btn5,btn6,btnInvia,edtMeta,this);
        scrollListener=new ScrollListener(scroll1,scroll2,scroll3);

        btnInvia.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btnHome.setOnClickListener(new Listener(this));
        scroll1.setOnScrollChangeListener(scrollListener);
        scroll2.setOnScrollChangeListener(scrollListener);
        scroll3.setOnScrollChangeListener(scrollListener);
    }
}
