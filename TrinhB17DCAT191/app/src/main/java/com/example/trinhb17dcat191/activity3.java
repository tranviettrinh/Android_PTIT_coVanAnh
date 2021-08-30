package com.example.trinhb17dcat191;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity3 extends AppCompatActivity {
EditText edit4;
Button submit, cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        edit4 = findViewById(R.id.edit4);
        submit = findViewById(R.id.submit);
        cancel = findViewById(R.id.cancel);
        Intent intent_2 = new Intent(getBaseContext(),MainActivity.class);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = edit4.getText().toString();
                intent_2.putExtra("edittext4", a);
                startActivity(intent_2);
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b = "nothing received from Activity 3";
                intent_2.putExtra("edittext4",b);
                startActivity(intent_2);
            }
        });
    }
}