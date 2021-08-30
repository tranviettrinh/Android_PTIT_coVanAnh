package com.example.trinhb17dcat191;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
EditText username, password;
Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.user);
        password = findViewById(R.id.pass);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = username.getText().toString();
                String p = password.getText().toString();
                if (u.equalsIgnoreCase("b17dcat191") && p.equalsIgnoreCase("sa")) {
                    Intent main_class = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(main_class);
                }else if(!u.equalsIgnoreCase("b17dcat191")){
                    username.setError("Sai nguoi dung");
                }
                else if(!p.equalsIgnoreCase("sa")){
                    password.setError("Sai mật khẩu");
                }
            }
        });

    }
}