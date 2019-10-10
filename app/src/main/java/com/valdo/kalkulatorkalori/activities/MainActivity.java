package com.valdo.kalkulatorkalori.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.valdo.kalkulatorkalori.R;
import com.valdo.kalkulatorkalori.fragment.MenuFragment;

public class MainActivity extends AppCompatActivity implements MenuFragment.OnFragmentInteractionListener {

   private MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuFragment = new MenuFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, menuFragment)
                .commit();
    }

    @Override
    public void onFragmentBMRCliked() {
        System.out.println("BMR sedang di klik");

    }

    @Override
    public void onFragmentKcalCliked() {

    }
}
