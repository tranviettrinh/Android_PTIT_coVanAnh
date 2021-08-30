package com.example.b17dcat191tranviettrinh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.b17dcat191tranviettrinh.Database.B17DCAT191_QUANLYTHUCDON;
import com.example.b17dcat191tranviettrinh.Models.MonAn_B17DCAT191;

public class ThemMon extends AppCompatActivity {
    private EditText nametxt,pricetxt,timetxt;
    private Button thembtn;
    private B17DCAT191_QUANLYTHUCDON data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_mon);
        data = new B17DCAT191_QUANLYTHUCDON(getBaseContext());
        nametxt = findViewById(R.id.them_name);
        pricetxt = findViewById(R.id.them_price);
        timetxt = findViewById(R.id.them_time);
        thembtn = findViewById(R.id.them_button);
        thembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonAn_B17DCAT191 mon = new MonAn_B17DCAT191(nametxt.getText().toString(),Integer.parseInt(pricetxt.getText().toString()),timetxt.getText().toString());
                data.addMon(mon);
                finish();
            }
        });


    }
}