package com.valdo.kalkulatorkalori.util;

public class BasaMetabolicRate {
    public static final int MALE = 0;
    public static final int FEMALE = 1;
//    public static final int

    private  int tinggi;
    private  int berat;
    private  int usia;
    private  int gender;
    private  double olahraga;
    private  float index;

    public BasaMetabolicRate(int tinggi, int berat, int usia, int gender, double olahraga) {
        this.tinggi = tinggi;
        this.berat = berat;
        this.usia = usia;
        this.gender = gender;
        this.olahraga = olahraga;
        this.index = hitung();
    }
    public  float getIndex(){
        return index;
    }

    private float hitung() {
        switch (gender){
            case MALE: return (float) ((66 + (13.7 * berat) + (5 * tinggi) -(6.8 * usia)) * olahraga);
            case FEMALE: return (float) ((655 + (9.6 * berat) + (1.8 * tinggi) - (4.7 * usia)) * olahraga);
            default: return  0f;
        }

    }

}
