package com.valdo.kalkulatorkalori.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.valdo.kalkulatorkalori.R;
import com.valdo.kalkulatorkalori.fragment.BasalMetabolicRateFragment;
import com.valdo.kalkulatorkalori.fragment.BerlariFragment;
import com.valdo.kalkulatorkalori.fragment.HasilFragment;
import com.valdo.kalkulatorkalori.fragment.MenuFragment;

public class MainActivity extends AppCompatActivity implements
        MenuFragment.OnFragmentInteractionListener,
        BasalMetabolicRateFragment.OnFragmentInteractionListener,
        HasilFragment.OnFragmentInteractionListener,
        BerlariFragment.OnFragmentInteractionListener {

   private MenuFragment menuFragment;
   private BasalMetabolicRateFragment basalMetabolicRateFragment;
   private HasilFragment hasilFragment;
   private PembakaranKalori pembakaranKalori;
   private BerlariFragment berlariFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuFragment = new MenuFragment();
        hasilFragment = new HasilFragment();
        pembakaranKalori = new PembakaranKalori();
        berlariFragment = new BerlariFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, menuFragment)
                .commit();
        basalMetabolicRateFragment = new BasalMetabolicRateFragment();
    }

    @Override
    public void onFragmentBMRCliked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,basalMetabolicRateFragment)
                .commit();
    }
    @Override
    public void onFragmentKcalCliked() {
//        Intent i = new Intent(MainActivity.this, PembakaranKalori.class);
//        startActivities(i);
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container,pembakaranKalori)
//                .commit();
    }


    @Override
    public void onCalculateButtonBMRClicked(float index) {
        hasilFragment.setInformasi(String.format("Kebutuhan kalori harian anda adalah %.1f",index));
        basalMetabolicRateFragment = (BasalMetabolicRateFragment) getSupportFragmentManager().findFragmentByTag("BMR");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,hasilFragment)
//				.addToBackStack(null)
                .commit();

    }

    @Override
    public void buttonHitungLagi(String tag) {
        if (basalMetabolicRateFragment == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new BasalMetabolicRateFragment(),"BMR")
                    .commit();
        }
        else {

//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.fragment_container, new , "BMI_FRAGMENT")
//                    .commit();
        }

    }

    @Override
    public void onCalculateButtonClick(int index) {
        hasilFragment.setInformasi(String.format("Jumlah Kalori Yang Telah di Bakar  %.1f",index));
         berlariFragment = (BerlariFragment) getSupportFragmentManager().findFragmentByTag("BerlariKalori");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,hasilFragment)
//				.addToBackStack(null)
                .commit();
    }
}
