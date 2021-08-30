package com.example.trinhb17dcat191;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etA;
    EditText etB;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void cOng(View view) {
        etA = findViewById(R.id.editTextA);
        etB = findViewById(R.id.editTextB);
        result = findViewById(R.id.textView6);
//        if(etA.getText().toString().isEmpty()){
//            Toast.makeText(MainActivity.this,"fsdfsd",Toast.LENGTH_SHORT).show();
//        }
//        Toast.makeText(MainActivity.this,etA.getText().toString(),Toast.LENGTH_SHORT).show();
        if(!etA.getText().toString().isEmpty() && !etB.getText().toString().isEmpty()) {
            int rs = Integer.parseInt(etA.getText().toString()) + Integer.parseInt(etB.getText().toString());
            result.setText(String.valueOf(rs));
        }
    }

    public void tRu(View view) {
        etA = findViewById(R.id.editTextA);
        etB = findViewById(R.id.editTextB);
        result = findViewById(R.id.textView6);
        if(!etA.getText().toString().isEmpty() && !etB.getText().toString().isEmpty()) {
            int rs = Integer.parseInt(etA.getText().toString()) - Integer.parseInt(etB.getText().toString());
            result.setText(String.valueOf(rs));
        }
    }

    public void nHan(View view) {
        etA = findViewById(R.id.editTextA);
        etB = findViewById(R.id.editTextB);
        result = findViewById(R.id.textView6);
        if(!etA.getText().toString().isEmpty() && !etB.getText().toString().isEmpty()) {
            int rs = Integer.parseInt(etA.getText().toString()) * Integer.parseInt(etB.getText().toString());
            result.setText(String.valueOf(rs));
        }
    }

    public void cHia(View view) {
        etA = findViewById(R.id.editTextA);
        etB = findViewById(R.id.editTextB);
        result = findViewById(R.id.textView6);
        if(!etA.getText().toString().isEmpty() && !etB.getText().toString().isEmpty()) {
            double rs = Double.parseDouble(etA.getText().toString()) / Double.parseDouble(etB.getText().toString());
            result.setText(String.valueOf(rs));
        }
    }
}