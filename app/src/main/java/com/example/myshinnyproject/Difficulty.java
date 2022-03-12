package com.example.myshinnyproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Difficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        Button facile = findViewById(R.id.facile);
        Button moyen = findViewById(R.id.moyen);
        Button dur = findViewById(R.id.difficile);
        facile.setOnClickListener(view -> startActivity(new Intent(Difficulty.this, activity_facile.class)));
        moyen.setOnClickListener(view -> startActivity(new Intent(Difficulty.this, activity_moyen.class)));
        dur.setOnClickListener(view -> startActivity(new Intent(Difficulty.this, activity_difficile.class)));
    }
}