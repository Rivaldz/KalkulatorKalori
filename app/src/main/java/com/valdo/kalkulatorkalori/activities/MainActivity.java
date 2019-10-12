package com.valdo.kalkulatorkalori.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.valdo.kalkulatorkalori.R;
import com.valdo.kalkulatorkalori.fragment.BasalMetabolicRateFragment;
import com.valdo.kalkulatorkalori.fragment.MenuFragment;

public class MainActivity extends AppCompatActivity implements
        MenuFragment.OnFragmentInteractionListener,
        BasalMetabolicRateFragment.OnFragmentInteractionListener {

   private MenuFragment menuFragment;
   private BasalMetabolicRateFragment basalMetabolicRateFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuFragment = new MenuFragment();
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

    }


    @Override
    public void onCalculateButtonBMRClicked() {

    }
}
