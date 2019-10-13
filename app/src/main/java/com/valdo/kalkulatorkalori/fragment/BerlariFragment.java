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

import com.valdo.kalkulatorkalori.R;
import com.valdo.kalkulatorkalori.activities.PembakaranKalori;
import com.valdo.kalkulatorkalori.util.HitungKalori;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BerlariFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BerlariFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private EditText beratBadan, waktu, jarak;
    private RadioButton hitung;

    public BerlariFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_berlari, container, false);
        beratBadan = view.findViewById(R.id.textViewBerat);
        waktu = view.findViewById(R.id.textViewBerat);
        jarak = view.findViewById(R.id.textVIewJarak);
        hitung = view.findViewById(R.id.buttonHitungLari);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null){
                    String beratString = beratBadan.getText().toString();
                    String waktuString = waktu.getText().toString();
                    String jarakString = jarak.getText().toString();
                    if (!TextUtils.isEmpty((beratString)) && !TextUtils.isEmpty(jarakString) && !TextUtils.isEmpty(waktuString) ){
                        int beratBadan = Integer.parseInt(beratString);
                        int waktu = Integer.parseInt(waktuString);
                        int jarak = Integer.parseInt(jarakString);
                        HitungKalori hitungKalori = new HitungKalori(jarak,waktu,beratBadan);
                        mListener.onCalculateButtonClick(hitungKalori.getIndex());


                    }
                }
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

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
        void onCalculateButtonClick(int index);
    }
}
