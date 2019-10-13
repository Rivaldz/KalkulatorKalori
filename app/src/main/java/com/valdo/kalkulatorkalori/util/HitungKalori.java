package com.valdo.kalkulatorkalori.util;

public class HitungKalori {

    private int jarak;
    private int waktu;
    private int berat;
    private int kaloriLari;

    public HitungKalori(int jarak, int waktu, int berat) {
        this.jarak = jarak;
        this.waktu = waktu;
        this.berat = berat;
    }

    private int hitungLari(){

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

    public  int getIndex(){
        return hitungLari();
    }
}
