package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AyatShowingActivity2 extends AppCompatActivity {

    TextView ayaText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat_showing2);

        String ayat=getIntent().getStringExtra("ayat");
        ayaText=findViewById(R.id.ayatTextBoxDisplay);
        ayaText.setText(ayat);

    }
}