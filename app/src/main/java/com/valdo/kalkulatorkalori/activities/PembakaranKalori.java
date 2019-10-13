package com.valdo.kalkulatorkalori.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.valdo.kalkulatorkalori.R;
import com.valdo.kalkulatorkalori.fragment.BerenangFragment;
import com.valdo.kalkulatorkalori.fragment.BerlariFragment;
import com.valdo.kalkulatorkalori.fragment.BersepedaFragment;
import com.valdo.kalkulatorkalori.fragment.HasilFragment;

public class PembakaranKalori extends AppCompatActivity implements BerlariFragment.OnFragmentInteractionListener, HasilFragment.OnFragmentInteractionListener {

    BerenangFragment berenangFragment;
    BerlariFragment berlariFragment;
    HasilFragment hasilFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembakaran_kalori);
        berenangFragment = new BerenangFragment();
        berenangFragment = new BerenangFragment();
        hasilFragment = new HasilFragment();
    }


    public void bberlariHandler(View view) {
        BerlariFragment checkVisible = (BerlariFragment) getSupportFragmentManager().findFragmentByTag("FRAGMENT_BERLARI");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (checkVisible != null && checkVisible.isVisible() ){
//            fragmentTransaction.commit();
        }
        else {
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.hitungKalori,new BerlariFragment(),"FRAGMENT_BERLARI");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    public void bersepedaHandler(View view) {
        BersepedaFragment checkVisible = (BersepedaFragment) getSupportFragmentManager().findFragmentByTag("FRAGMENT_BERSEPEDA");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (checkVisible != null && checkVisible.isVisible() ){
//            fragmentTransaction.commit();
        }
        else {
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.hitungKalori,new BersepedaFragment(),"FRAGMENT_BERSEPEDA");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    public void berenangHandler(View view) {
        BerenangFragment checkVisible = (BerenangFragment) getSupportFragmentManager().findFragmentByTag("FRAGMENT_BERENANG");
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (checkVisible != null && checkVisible.isVisible() ){
//            fragmentTransaction.commit();
        }
        else {
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.hitungKalori,new BerenangFragment(),"FRAGMENT_BERENANG");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onCalculateButtonClick(float index) {
        hasilFragment.setInformasi(String.format("Jumlah Kalori Yang Telah di Bakar  %.1f",index));
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.hitungKalori,new HasilFragment(),"BERLARIFRAGMENT");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    @Override
    public void buttonHitungLagi(String tag) {

    }
}
