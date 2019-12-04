package com.example.angelagamefinale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Listener implements View.OnClickListener{
    private Activity activity;
    private Utente utente=null;
    private P101 p101=null;
    private Button btn1=null;
    private Button btn2=null;
    private Button btn3=null;
    private Button btn4=null;
    private Button btn5=null;
    private Button btn6=null;
    private Button btnInvia=null;
    private EditText edtMeta=null;

    private int intGiocUtente;
    protected int intGiocP101;

    Listener(int intGiocUtente, int intGiocP101, Utente utente, P101 p101, Button btn1, Button btn2, Button btn3, Button btn4, Button btn5, Button btn6, Button btnInvia, EditText edtMeta, Activity activity){
        this.activity=activity;
        this.intGiocUtente=intGiocUtente;
        this.intGiocP101=intGiocP101;
        this.utente=utente;
        this.p101=p101;
        this.btn1=btn1;
        this.btn2=btn2;
        this.btn3=btn3;
        this.btn4=btn4;
        this.btn5=btn5;
        this.btn6=btn6;
        this.btnInvia=btnInvia;
        this.edtMeta=edtMeta;
    }

    Listener(Activity activity){
        this.activity=activity;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                intGiocUtente = 1;
                intGiocP101=p101.gioca(intGiocUtente);
                break;
            case R.id.btn2:
                intGiocUtente = 2;
                intGiocP101=p101.gioca(intGiocUtente);
                break;
            case R.id.btn3:
                intGiocUtente = 3;
                intGiocP101=p101.gioca(intGiocUtente);
                break;
            case R.id.btn4:
                intGiocUtente = 4;
                intGiocP101=p101.gioca(intGiocUtente);
                break;
            case R.id.btn5:
                intGiocUtente = 5;
                intGiocP101=p101.gioca(intGiocUtente);
                break;
            case R.id.btn6:
                intGiocUtente = 6;
                intGiocP101=p101.gioca(intGiocUtente);
                break;
            case R.id.btnGioca:
                Intent gioca=new Intent(activity.getApplicationContext(),Game.class);
                activity.startActivity(gioca);
                break;
            case R.id.btnRegole:
                Intent regole=new Intent(activity.getApplicationContext(),Regole.class);
                activity.startActivity(regole);
                break;
            case R.id.btnInvia:
                Integer intMeta=utente.inserisciMeta();
                if(intMeta==0){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(btnInvia.getContext(),R.style.AlertDialogStyle);
                    builder1.setTitle(R.string.Att);
                    builder1.setMessage(R.string.msgAtt);
                    builder1.setPositiveButton(R.string.reimpostaMeta, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    edtMeta.setFocusable(true);
                                    p101.reset();
                                }
                            });
                    builder1.setNegativeButton(R.string.apriRegole, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent regole=new Intent(activity.getApplicationContext(),Regole.class);
                                    activity.startActivity(regole);
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }else{
                    btnInvia.setEnabled(false);
                    edtMeta.setEnabled(false);
                    btn1.setEnabled(true);
                    btn2.setEnabled(true);
                    btn3.setEnabled(true);
                    btn4.setEnabled(true);
                    btn5.setEnabled(true);
                    btn6.setEnabled(true);
                    btn1.setBackgroundResource(R.drawable.pulsanti_start);
                    btn2.setBackgroundResource(R.drawable.pulsanti_start);
                    btn3.setBackgroundResource(R.drawable.pulsanti_start);
                    btn4.setBackgroundResource(R.drawable.pulsanti_start);
                    btn5.setBackgroundResource(R.drawable.pulsanti_start);
                    btn6.setBackgroundResource(R.drawable.pulsanti_start);
                }
                break;
            case R.id.btnHome:
                Intent home=new Intent(activity.getApplicationContext(),Start.class);
                home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                activity.startActivity(home);
                break;
            case R.id.imgIndietro:
                Intent gioca2=new Intent(activity.getApplicationContext(),Game.class);
                gioca2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                activity.startActivity(gioca2);
                break;
        }
    }
}
