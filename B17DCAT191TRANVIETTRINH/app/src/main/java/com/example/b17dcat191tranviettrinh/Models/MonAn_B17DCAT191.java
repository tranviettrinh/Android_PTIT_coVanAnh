package com.example.b17dcat191tranviettrinh.Models;

public class MonAn_B17DCAT191 {
    private int id;
    private String name;
    private int price;
    private String time;

    public MonAn_B17DCAT191() {
    }

    public MonAn_B17DCAT191(int id, String name, int price, String time) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.time = time;
    }

    public MonAn_B17DCAT191(String name, int price, String time) {
        this.name = name;
        this.price = price;
        this.time = time;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
