package com.example.b17dcat191tranviettrinh.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.b17dcat191tranviettrinh.Models.LoaiMon_B17DCAT191;
import com.example.b17dcat191tranviettrinh.R;

import java.util.ArrayList;
import java.util.List;

public class LoaiAdapter extends BaseAdapter {
    private List<LoaiMon_B17DCAT191> loaiList= new ArrayList<>();

    public LoaiAdapter(List<LoaiMon_B17DCAT191> loaiList) {
        this.loaiList = loaiList;
    }

    @Override
    public int getCount() {
        return loaiList.size();
    }

    @Override
    public Object getItem(int position) {
        return loaiList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        convertView = inflater.inflate(R.layout.custom_list_view,parent,false);
        TextView nametxt, destxt;
        nametxt = convertView.findViewById(R.id.name_txt);
        destxt = convertView.findViewById(R.id.price_or_des_txt);
        nametxt.setText(loaiList.get(position).getName());
        destxt.setText(loaiList.get(position).getDes());
        return convertView;
    }
}
