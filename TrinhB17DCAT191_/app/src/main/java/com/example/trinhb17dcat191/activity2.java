package com.example.trinhb17dcat191;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {
TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        text2 = findViewById(R.id.ac_text2);
        Intent hai = getIntent();
        String text1 = hai.getStringExtra("edittext1");
        text2.setText(text1);

    }
}