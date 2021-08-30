package com.example.b17dcat191tranviettrinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.b17dcat191tranviettrinh.Adapters.MonAdapter;
import com.example.b17dcat191tranviettrinh.Database.B17DCAT191_QUANLYTHUCDON;
import com.example.b17dcat191tranviettrinh.Models.MonAn_B17DCAT191;

import java.util.ArrayList;
import java.util.List;

public class MonAnMng extends AppCompatActivity {
    private Button thembtn;
    private ListView monlst;
    private List<MonAn_B17DCAT191> monList = new ArrayList<>();
    private MonAdapter adapter;
    private B17DCAT191_QUANLYTHUCDON data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new B17DCAT191_QUANLYTHUCDON(getBaseContext());
        setContentView(R.layout.activity_mon_an_mng);
        thembtn = findViewById(R.id.them_mon_btn);
        monlst = findViewById(R.id.danh_sach_mon);
        adapter = new MonAdapter(monList);
        monlst.setAdapter(adapter);

        thembtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),ThemMon.class));
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        monList.clear();
        monList.addAll(data.getAllMon());
        adapter.notifyDataSetChanged();
    }
}