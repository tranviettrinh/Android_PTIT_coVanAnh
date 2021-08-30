package com.example.b17dcat191tranviettrinh.Models;

public class LoaiMon_B17DCAT191 {
    private int id;
    private String name;
    private String des;

    public LoaiMon_B17DCAT191() {
    }

    public LoaiMon_B17DCAT191(int id, String name, String des) {
        this.id = id;
        this.name = name;
        this.des = des;
    }

    public LoaiMon_B17DCAT191(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
