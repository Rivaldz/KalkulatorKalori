package com.valdo.kalkulatorkalori.util;

public class HitungKalori {

    private int jarak;
    private int waktu;
    private int berat;
    private int kaloriLari;
    private float kaloriBersepeda;
    private float kaloriBerenang;

    public HitungKalori(int jarak, int waktu, int berat) {
        this.jarak = jarak;
        this.waktu = waktu;
        this.berat = berat;
    }

    private float hitungLari(){

        if ((jarak < 11) && (berat > 70) ){
        kaloriLari = waktu * 20;

        }
        else if ((jarak < 11) && (berat < 70)){
            kaloriLari = waktu * 14;
        }
        else if ((jarak > 11) && (berat > 70)){
            kaloriLari = waktu * 23;
        }
        else  if ((jarak > 11) && (berat < 70)){
            kaloriLari = waktu * 21;
        }
        return kaloriLari;
    }

    private float hitungBersepeda(){
        if ((jarak < 21) &&  (berat > 70)){
            kaloriBersepeda = (float) (waktu * 9.8);

        }
        else if ((jarak > 25) && (berat > 70)){
            kaloriBersepeda = (float) (waktu * 14.8);
        }
        else if (jarak < 21 && (berat < 69)){
            kaloriBersepeda = (float) (waktu * 8.8);

        }
        else if ((jarak > 21) && (berat <69)){
            kaloriBersepeda = (float) (waktu * 13.8);
        }

        return  kaloriBersepeda;
    }
    private float hitungBerenang(){
        if (berat > 70){
            kaloriBerenang = (float) (waktu * 8.6);
        }
        else if ( berat < 70){
            kaloriBerenang = (float) (waktu * 7.6);
        }
        return  kaloriBerenang;
    }

    public  float getIndex(){
        return hitungLari();
    }
    public float getIndexBersepeda(){
        return  hitungBersepeda();
    }
    public float getIndexBerenang(){
        return hitungBerenang();
    }
}
