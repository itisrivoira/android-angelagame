package com.example.angelagamefinale;

import android.widget.Button;
import android.widget.EditText;

class Utente {

    private EditText edtMeta;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btnInvia;

    Utente(EditText edtMeta,Button btn1,Button btn2,Button btn3,Button btn4,Button btn5,Button btn6,Button btnInvia) {
        this.edtMeta = edtMeta;
        this.btn1=btn1;
        this.btn2=btn2;
        this.btn3=btn3;
        this.btn4=btn4;
        this.btn5=btn5;
        this.btn6=btn6;
        this.btnInvia=btnInvia;
    }

    Integer inserisciMeta() {
        String met = edtMeta.getText().toString();
        if (!met.isEmpty()) {
            Integer num = Integer.parseInt(met);
            if (num >= 30 && num <= 100) {
                return num;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }

    void controlloGiocata(int giocata){
        if (giocata==1||giocata==6){
            btn1.setEnabled(false);
            btn2.setEnabled(true);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(true);
            btn6.setEnabled(false);
            btn1.setBackgroundResource(R.drawable.pulsanti_grigi);
            btn2.setBackgroundResource(R.drawable.pulsanti_start);
            btn3.setBackgroundResource(R.drawable.pulsanti_start);
            btn4.setBackgroundResource(R.drawable.pulsanti_start);
            btn5.setBackgroundResource(R.drawable.pulsanti_start);
            btn6.setBackgroundResource(R.drawable.pulsanti_grigi);
        }
        if (giocata==2||giocata==5) {
            btn1.setEnabled(true);
            btn2.setEnabled(false);
            btn3.setEnabled(true);
            btn4.setEnabled(true);
            btn5.setEnabled(false);
            btn6.setEnabled(true);
            btn1.setBackgroundResource(R.drawable.pulsanti_start);
            btn2.setBackgroundResource(R.drawable.pulsanti_grigi);
            btn3.setBackgroundResource(R.drawable.pulsanti_start);
            btn4.setBackgroundResource(R.drawable.pulsanti_start);
            btn5.setBackgroundResource(R.drawable.pulsanti_grigi);
            btn6.setBackgroundResource(R.drawable.pulsanti_start);
        }
        if (giocata==3||giocata==4){
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(true);
            btn6.setEnabled(true);
            btn1.setBackgroundResource(R.drawable.pulsanti_start);
            btn2.setBackgroundResource(R.drawable.pulsanti_start);
            btn3.setBackgroundResource(R.drawable.pulsanti_grigi);
            btn4.setBackgroundResource(R.drawable.pulsanti_grigi);
            btn5.setBackgroundResource(R.drawable.pulsanti_start);
            btn6.setBackgroundResource(R.drawable.pulsanti_start);
        }
    }

    void reset(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn1.setBackgroundResource(R.drawable.pulsanti_grigi);
        btn2.setBackgroundResource(R.drawable.pulsanti_grigi);
        btn3.setBackgroundResource(R.drawable.pulsanti_grigi);
        btn4.setBackgroundResource(R.drawable.pulsanti_grigi);
        btn5.setBackgroundResource(R.drawable.pulsanti_grigi);
        btn6.setBackgroundResource(R.drawable.pulsanti_grigi);
        btnInvia.setEnabled(true);
        edtMeta.setEnabled(true);
    }
}
