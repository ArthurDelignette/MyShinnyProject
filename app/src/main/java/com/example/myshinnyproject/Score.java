package com.example.myshinnyproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Score extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        int score = getIntent().getIntExtra("key",0);
        TextView textView = findViewById(R.id.score);
        textView.setText("" + score + "/5");
        Button bouton_rejouer = findViewById(R.id.rejouer);
        bouton_rejouer.setOnClickListener(view -> startActivity(new Intent(Score.this,Difficulty.class)));
    }
}