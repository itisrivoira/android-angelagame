package com.example.angelagamefinale;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class P101 {
    private Utente utente;
    private Activity activity;
    private TextView txtGiocUtente;
    private TextView txtGiocP101;
    private TextView txtSomma;
    private EditText edtMeta;
    private ScrollView scroll1;
    private ScrollView scroll2;
    private ScrollView scroll3;

    private ArrayList<String> giocUtente;
    private ArrayList<String> giocP101;
    private ArrayList<String> somme;

    private Integer intGiocP101;
    private Integer intSomma=0;
    private int intSommaP101=0;
    private int intSommaUtente=0;
    private Integer b=0;

    P101(ArrayList<String> giocUtente,ArrayList<String> giocP101, ArrayList<String> somme, Integer intGiocP101, EditText edtMeta, TextView txtGiocP101, TextView txtGiocUtente, TextView txtSomma, Utente utente, Activity activity,ScrollView scroll1, ScrollView scroll2, ScrollView scroll3) {
        this.giocUtente = giocUtente;
        this.giocP101 = giocP101;
        this.somme = somme;
        this.intGiocP101=intGiocP101;
        this.edtMeta=edtMeta;
        this.txtGiocP101=txtGiocP101;
        this.txtGiocUtente=txtGiocUtente;
        this.txtSomma=txtSomma;
        this.utente=utente;
        this.activity=activity;
        this.scroll1=scroll1;
        this.scroll2=scroll2;
        this.scroll3=scroll3;
    }

    void reset(){
        somme.clear();
        giocP101.clear();
        giocUtente.clear();
        b=0;
        intSommaP101=0;
        intSomma=0;
        intSommaUtente=0;
        txtGiocUtente.setText("");
        txtSomma.setText("");
        txtGiocP101.setText("");
        edtMeta.setText("");
    }

    int gioca(int intGiocUtente) {
        intGiocP101 = calcolaGiocataM(intGiocUtente, edtMeta.getText().toString());
        utente.controlloGiocata(intGiocP101);
        intSommaUtente = intSommaUtente + intGiocUtente;
        intSommaP101 = intSommaP101 + intGiocP101;
        intSomma = intSommaUtente + intSommaP101;
        stampa(intGiocUtente);
        int intMeta = Integer.parseInt(edtMeta.getText().toString());
        if(intSomma==intMeta||intSomma-intGiocP101>intMeta){
            stampa(intGiocUtente);
            utente.reset();
            reset();
            Intent perso = new Intent(activity.getApplicationContext(), Sconfitta.class);
            activity.startActivity(perso);
        }else if(intSomma-intGiocP101==intMeta||intSomma>intMeta) {
            utente.reset();
            reset();
            Intent vinto = new Intent(activity.getApplicationContext(), Vittoria.class);
            activity.startActivity(vinto);
        }
        return intGiocP101;
    }

    private void stampa(int intGiocUtente){
        if(giocP101.size()==0) {
            giocUtente.add(" "+intGiocUtente + "\n");
            giocP101.add(" "+intGiocP101 + "\n");
            somme.add(" "+intSomma + "\n");
        }else{
            giocUtente.add(intGiocUtente + "\n");
            giocP101.add(intGiocP101 + "\n");
            somme.add(intSomma + "\n");
        }
        String strGiocUtente = giocUtente.toString().replace("[","");
        String strVirgola = strGiocUtente.replace(",","");
        String strFinale = strVirgola.replace("]","");
        String strGiocP101 = giocP101.toString().replace("[","");
        String strVirgola1 = strGiocP101.replace(",","");
        String strFinale1 = strVirgola1.replace("]","");
        String strSomme = somme.toString().replace("[","");
        String strVirgola2 = strSomme.replace(",","");
        String strFinale2 = strVirgola2.replace("]","");
        txtGiocUtente.setText(strFinale);
        txtGiocP101.setText(strFinale1);
        txtSomma.setText(strFinale2);
        scroll1.fullScroll(View.FOCUS_DOWN);
        scroll2.fullScroll(View.FOCUS_DOWN);
        scroll3.fullScroll(View.FOCUS_DOWN);
    }

    private int calcolaGiocataM(int utente, String meta) {
        int somma1;
        int a = Integer.parseInt(meta) - b;
        if(utente==2&&a==4) intGiocP101 = 1;
        else {
            List<Integer> digits = new LinkedList<>();
            while (a > 0) {
                digits.add(0, a % 10);
                a = a / 10;
            }
            if (Integer.parseInt(meta)==100) {
                try {
                    somma1 = digits.get(0) + digits.get(1);
                } catch (Exception e) {
                    e.printStackTrace();
                    somma1=digits.get(0);
                }
            } else if (digits.size() == 2) {
                somma1 = digits.get(0) + digits.get(1);
            } else {
                somma1 = digits.get(0);
            }
            if (somma1 > 9) {
                List<Integer> digits2 = new LinkedList<>();
                while (somma1 > 0) {
                    digits2.add(0, somma1 % 10);
                    somma1 = somma1 / 10;
                }
                if (digits2.size() == 2) {
                    somma1 = digits2.get(0) + digits2.get(1);
                } else {
                    somma1 = digits2.get(0);
                }
            }
            if (utente == 1) {
                if (somma1 == 1 || somma1 == 10 || somma1 == 3 || somma1 == 2) {
                    intGiocP101 = 2;
                }
                if (somma1 == 4 || somma1 == 7 || somma1 == 8) {
                    intGiocP101 = 3;
                }
                if (somma1 == 5 || somma1 == 9) {
                    intGiocP101 = 4;
                }
                if (somma1 == 6) {
                    intGiocP101 = 5;
                }
            }
            if (utente == 2) {
                if (somma1 == 1 || somma1 == 10 || somma1 == 6) {
                    intGiocP101 = 4;
                }
                if (somma1 == 2 || somma1 == 3 || Integer.parseInt(meta) == 54 && somma1 == 5) {
                    intGiocP101 = 1;
                }
                if (somma1 == 4 || somma1 == 5 || somma1 == 9) {
                    intGiocP101 = 3;
                }
                if (somma1 == 7 || somma1 == 8) {
                    intGiocP101 = 6;
                }
            }
            if (utente == 3) {
                if (somma1 == 1 || somma1 == 10 || somma1 == 2 || somma1 == 3 || somma1 == 4) {
                    intGiocP101 = 1;
                }
                if (somma1 == 5) {
                    intGiocP101 = 2;
                }
                if (somma1 == 6 || somma1 == 7 || somma1 == 8) {
                    intGiocP101 = 5;
                }
                if (somma1 == 9) {
                    intGiocP101 = 6;
                }
            }
            if (utente == 4) {
                if (somma1 == 1 || somma1 == 10) {
                    intGiocP101 = 6;
                }
                if (somma1 == 2 || somma1 == 3 || somma1 == 4 || somma1 == 5) {
                    intGiocP101 = 1;
                }
                if (somma1 == 6) {
                    intGiocP101 = 2;
                }
                if (somma1 == 7 || somma1 == 8 || somma1 == 9) {
                    intGiocP101 = 5;
                }
            }
            if (utente == 5) {
                if (somma1 == 1 || somma1 == 10 || somma1 == 2) {
                    intGiocP101 = 6;
                }
                if (somma1 == 3 || somma1 == 7 || somma1 == 8) {
                    intGiocP101 = 3;
                }
                if (somma1 == 4 || somma1 == 9) {
                    intGiocP101 = 4;
                }
                if (somma1 == 5 || somma1 == 6) {
                    intGiocP101 = 1;
                }
            }
            if (utente == 6) {
                if (somma1 == 1 || somma1 == 10 || somma1 == 5) {
                    intGiocP101 = 4;
                }
                if (somma1 == 3 || somma1 == 4 || somma1 == 9) {
                    intGiocP101 = 3;
                }
                if (somma1 == 2) {
                    intGiocP101 = 5;
                }
                if (somma1 == 6 || somma1 == 7 || somma1 == 8) {
                    intGiocP101 = 2;
                }
            }
        }
        b = b + utente + intGiocP101;
        return intGiocP101;
    }
}
