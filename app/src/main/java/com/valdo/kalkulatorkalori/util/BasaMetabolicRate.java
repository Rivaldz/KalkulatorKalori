package com.valdo.kalkulatorkalori.util;

public class BasaMetabolicRate {
    public static final int MALE = 0;
    public static final int FEMALE = 1;
//    public static final int

    private  int tinggi;
    private  int berat;
    private  int usia;
    private  int gender;
    private  float index;

    public BasaMetabolicRate(int tinggi, int berat, int usia, int gender) {
        this.tinggi = tinggi;
        this.berat = berat;
        this.usia = usia;
        this.gender = gender;
        this.index = hitung();
    }

    private float hitung() {

        return index;

    }

}
