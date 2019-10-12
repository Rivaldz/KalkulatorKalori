package com.valdo.kalkulatorkalori.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.valdo.kalkulatorkalori.R;
import com.valdo.kalkulatorkalori.util.BasaMetabolicRate;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BasalMetabolicRateFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BasalMetabolicRateFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private RadioGroup radioGroup;
    private EditText tinggiBadan;
    private EditText beratBadan;
    private EditText usia;
    private RadioGroup listAktivitas;
    private RadioButton kurangAktif, sedikitAktif, cukupAktif, aktif, sangatAktif;


    public BasalMetabolicRateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basal_metabolic_rate, container, false);
        radioGroup = view.findViewById(R.id.radioGrupBMR);
        tinggiBadan = view.findViewById(R.id.editTextTinggi);
        beratBadan = view.findViewById(R.id.editTextBerat);
        usia = view.findViewById(R.id.editTextUsia);
        kurangAktif = view.findViewById(R.id.radioTidakAktif);
        sedikitAktif = view.findViewById(R.id.radioCukupAktif);
        cukupAktif = view.findViewById(R.id.radioAktif);
        aktif = view.findViewById(R.id.radioSedikitAktif);
        sangatAktif = view.findViewById(R.id.radioSangatAktif);


        Button buttonHitung = view.findViewById(R.id.butttonHitung);
        buttonHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (mListener != null){
                   String tinggiBadanString = tinggiBadan.getText().toString();
                   String beratBadanString = beratBadan.getText().toString();
                   String usiaString = usia.getText().toString();
                   int checkID =  radioGroup.getCheckedRadioButtonId();
                   if ((checkID != -1) && !TextUtils.isEmpty(tinggiBadanString) && !TextUtils.isEmpty(beratBadanString) && !TextUtils.isEmpty(usiaString)){
                      int tinggi = Integer.parseInt(tinggiBadanString);
                      int berat = Integer.parseInt(beratBadanString);
                      int usia = Integer.parseInt(usiaString);
                      int gender = (checkID == R.id.radioLaki_Laki) ? BasaMetabolicRate.MALE : BasaMetabolicRate.FEMALE;
                      BasaMetabolicRate basaMetabolicRate = new BasaMetabolicRate(tinggi,berat,usia,gender);
                      mListener.onCalculateButtonBMRClicked(basaMetabolicRate.getIndex());

                   }
                   else {
                       Toast.makeText(getActivity(),"Silahkan isi semua form dan radio button",Toast.LENGTH_SHORT).show();
                   }

               }
               userAnswer();
            }
        });

        return  view;
    }

    private void userAnswer(){



    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

        // TODO: Update argument type and name
        void onCalculateButtonBMRClicked(float index);
    }
}
