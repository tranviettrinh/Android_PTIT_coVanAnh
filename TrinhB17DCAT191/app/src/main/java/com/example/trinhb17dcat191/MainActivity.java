package com.example.trinhb17dcat191;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText edit2, edit3;
Button button2, button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = edit2.getText().toString();
                Intent intent1 = new Intent(getBaseContext(),activity2.class);
                intent1.putExtra("edittext1",a);
                startActivity(intent1);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),activity3.class));
            }
        });
        Intent mot = getIntent();
        String edittext3 = mot.getStringExtra("edittext4");
        edit3.setText(edittext3);


    }
}