package com.example.myshinnyproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class activity_difficile extends AppCompatActivity {

    private int bonneReponse;
    private int score = 0;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficile);


        TextView answer1 = findViewById(R.id.answer1);
        TextView answer2 = findViewById(R.id.answer2);
        TextView answer3 = findViewById(R.id.answer3);
        TextView answer4 = findViewById(R.id.answer4);
        ProgressBar progress = findViewById(R.id.progressBar);
        TextView operation = findViewById(R.id.operation);

        bonneReponse = gTout(operation, answer1, answer2, answer3, answer4);

        answer1.setOnClickListener(view -> {
            vRep(bonneReponse,answer1);
            new CountDownTimer(500, 1000) {

                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    bonneReponse = onClick(progress,operation,answer1,answer2,answer3,answer4);
                }
            }.start();

        });
        answer2.setOnClickListener(view -> {
            vRep(bonneReponse,answer2);
            new CountDownTimer(500, 1000) {

                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    bonneReponse = onClick(progress,operation,answer1,answer2,answer3,answer4);

                }
            }.start();

        });
        answer3.setOnClickListener(view -> {
            vRep(bonneReponse,answer3);
            new CountDownTimer(500, 1000) {

                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    bonneReponse = onClick(progress,operation,answer1,answer2,answer3,answer4);

                }
            }.start();

        });
        answer4.setOnClickListener(view -> {
            vRep(bonneReponse,answer4);
            new CountDownTimer(500, 1000) {

                public void onTick(long millisUntilFinished) {

                }

                public void onFinish() {
                    bonneReponse = onClick(progress,operation,answer1,answer2,answer3,answer4);

                }
            }.start();

        });

    }

    private void vRep(int res,TextView a){
        if (a.getText().toString().equals(""+res)){
            a.setBackgroundResource(R.drawable.correct);
            score += 1;
        }else{
            a.setBackgroundResource(R.drawable.incorrect);
        }

    }

    private int onClick(ProgressBar p, TextView o, TextView a1, TextView a2, TextView a3, TextView a4){
        p.setProgress(p.getProgress()+1);
        int res = 0;
        if (p.getProgress() == 5){
            Intent i = new Intent(activity_difficile.this,Score.class);
            i.putExtra("key",score);
            startActivity(i);
        }else {
            res = gTout(o,a1,a2,a3,a4);
        }
        return res;
    }

    @SuppressLint("SetTextI18n")
    private int gTout(TextView o, TextView a1, TextView a2, TextView a3, TextView a4){
        int[] tab = gOperation(o);
        int[] reponses = gReponses(tab);
        a1.setText(""+reponses[0]);
        a2.setText(""+reponses[1]);
        a3.setText(""+reponses[2]);
        a4.setText(""+reponses[3]);
        a1.setBackgroundResource(R.drawable.rounded_corners);
        a2.setBackgroundResource(R.drawable.rounded_corners);
        a3.setBackgroundResource(R.drawable.rounded_corners);
        a4.setBackgroundResource(R.drawable.rounded_corners);

        return tab[3];
    }

    @SuppressLint("SetTextI18n")
    private int[] gOperation(TextView T){
        int operation = gRandom(4);
        int negatif = gRandom(8);
        int x1;
        int x2;
        int res;
        if(operation == 0){
            x1 = gRandom(50)+15;
            x2 = gRandom(50)+15;
            if (negatif == 0 ){
                x1 = -x1;
            }
            T.setText(""+x1+" + "+x2);
            res = x1 + x2;
        }else if(operation == 1){
            x1 = gRandom(50)+15;
            x2 = gRandom(50)+15;
            if (negatif == 0 ){
                x1 = -x1;
            }
            T.setText(""+x1+" - "+x2);
            res = x1 - x2;
        }else if(operation == 2){
            x1 = gRandom(16)+1;
            x2 = gRandom(16)+1;
            if (negatif == 0 ){
                x1 = -x1;
            }else if(negatif == 1){
                x2 = -x2;
            }else if(negatif == 2){
                x1 = -x1;
                x2 = -x2;
            }
            T.setText(""+x1+" x "+x2);
            res = x1 * x2;
        }else {
            int div = gRandom(2);
            if(div == 0){
                x1 = gRandom(25)+1;
                res = gRandom(11)+1;
                if (negatif == 0 ){
                    x1 = -x1;
                }else if(negatif == 1){
                    res = -res;
                }else if(negatif == 2){
                    x1 = -x1;
                    res = -res;
                }
                x2 = x1*res;
                T.setText(""+x2+" / "+x1);
            }else{
                res = gRandom(25)+1;
                x2 = gRandom(11)+1;
                if (negatif == 0 ){
                    res = -res;
                }else if(negatif == 1){
                    x2 = -x2;
                }else if(negatif == 2){
                    res = -res;
                    x2 = -x2;
                }
                x1 = x2*res;
                T.setText(""+x1+" / "+x2);
            }
        }
        int[] tab = new int[4];
        tab[0] = operation;
        tab[1] = x1;
        tab[2] = x2;
        tab[3] = res;
        return tab;

    }

    private  int gRandom(int x){
        return new Random().nextInt(x);
    }

    private  int[] gReponses(int[] tab){
        int res = tab[3];
        int [] sortie = new int[4];
        int plus = gDiffPlus(res);
        int moins = gDiffMoins(res);
        int signe = gDiffSign(tab);
        while(plus == moins || plus == signe || signe == moins){
            if(plus == moins){
                plus +=1;
            }else if(plus == signe){
                plus +=1;
            }else {
                moins +=1;
            }
        }

        int alea = gRandom(24);
        switch (alea){
            case 0:
                sortie[0] = res;
                sortie[1] = plus;
                sortie[2] = moins;
                sortie[3] = signe;
                break;
            case 1:
                sortie[0] = res;
                sortie[1] = plus;
                sortie[2] = signe;
                sortie[3] = moins;
                break;
            case 2:
                sortie[0] = res;
                sortie[1] = moins;
                sortie[2] = plus;
                sortie[3] = signe;
                break;
            case 3:
                sortie[0] = res;
                sortie[1] = moins;
                sortie[2] = signe;
                sortie[3] = plus;
                break;
            case 4:
                sortie[0] = res;
                sortie[1] = signe;
                sortie[2] = plus;
                sortie[3] = moins;
                break;
            case 5:
                sortie[0] = res;
                sortie[1] = signe;
                sortie[2] = moins;
                sortie[3] = plus;
                break;
            case 6:
                sortie[0] = plus;
                sortie[1] = res;
                sortie[2] = signe;
                sortie[3] = moins;
                break;
            case 7:
                sortie[0] = plus;
                sortie[1] = res;
                sortie[2] = moins;
                sortie[3] = signe;
                break;
            case 8:
                sortie[0] = plus;
                sortie[1] = signe;
                sortie[2] = res;
                sortie[3] = moins;
                break;
            case 9:
                sortie[0] = plus;
                sortie[1] = signe;
                sortie[2] = moins;
                sortie[3] = res;
                break;
            case 10:
                sortie[0] = plus;
                sortie[1] = moins;
                sortie[2] = res;
                sortie[3] = signe;
                break;
            case 11:
                sortie[0] = plus;
                sortie[1] = moins;
                sortie[2] = signe;
                sortie[3] = res;
                break;
            case 12:
                sortie[0] = moins;
                sortie[1] = plus;
                sortie[2] = res;
                sortie[3] = signe;
                break;
            case 13:
                sortie[0] = moins;
                sortie[1] = plus;
                sortie[2] = signe;
                sortie[3] = res;
                break;
            case 14:
                sortie[0] = moins;
                sortie[1] = signe;
                sortie[2] = res;
                sortie[3] = plus;
                break;
            case 15:
                sortie[0] = moins;
                sortie[1] = signe;
                sortie[2] = plus;
                sortie[3] = res;
                break;
            case 16:
                sortie[0] = moins;
                sortie[1] = res;
                sortie[2] = signe;
                sortie[3] = plus;
                break;
            case 17:
                sortie[0] = moins;
                sortie[1] = res;
                sortie[2] = plus;
                sortie[3] = signe;
                break;
            case 18:
                sortie[0] = signe;
                sortie[1] = res;
                sortie[2] = plus;
                sortie[3] = moins;
                break;
            case 19:
                sortie[0] = signe;
                sortie[1] = res;
                sortie[2] = moins;
                sortie[3] = plus;
                break;
            case 20:
                sortie[0] = signe;
                sortie[1] = plus;
                sortie[2] = moins;
                sortie[3] = res;
                break;
            case 21:
                sortie[0] = signe;
                sortie[1] = plus;
                sortie[2] = res;
                sortie[3] = moins;
                break;
            case 22:
                sortie[0] = signe;
                sortie[1] = moins;
                sortie[2] = plus;
                sortie[3] = res;
                break;
            case 23:
                sortie[0] = signe;
                sortie[1] = moins;
                sortie[2] = res;
                sortie[3] = plus;
                break;
        }

        return sortie;
    }

    private int gDiffPlus(int res){
        return res + (gRandom(5)+1);

    }

    private int gDiffMoins(int res){
        return  res - (gRandom(5)+1);

    }

    private int gDiffSign(int[] tab){
        int res;
        if (tab[0] == 0){
            res = tab[1] - tab[2];
        }else if(tab[0] == 1){
            res = tab[1] + tab[2];
        }else{
            int unite = tab[3] % 10;
            int dizaine = (tab[3] - unite)/10;
            int rand = gRandom(2);
            if(rand == 0){
                dizaine = dizaine -1;
            }else{
                dizaine = dizaine +1;
            }
            res = (10 * dizaine) + unite;
        }
        return res;
    }


}