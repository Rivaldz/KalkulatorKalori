package com.valdo.kalkulatorkalori.fragment;

import android.content.Context;
import android.icu.text.UnicodeSetSpanner;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.valdo.kalkulatorkalori.R;
import com.valdo.kalkulatorkalori.util.HitungKalori;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BerenangFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BerenangFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private EditText beratBadan, waktu;
    private Button button;
    public BerenangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_berenang, container, false);
        beratBadan = view.findViewById(R.id.beratBadanBerenang);
        waktu = view.findViewById(R.id.waktuBerenang);
        button = view.findViewById(R.id.buttonHitungKaloriBerenang);
        final TextView hasil = view.findViewById(R.id.hasilBerenang);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener == null){
                    String  beratString = beratBadan.getText().toString();
                    String waktuString = waktu.getText().toString();
                    if (!TextUtils.isEmpty(waktuString) && !TextUtils.isEmpty(beratString)){
                        int beratbadan = Integer.parseInt(beratString);
                        int waktu = Integer.parseInt(waktuString);
                        HitungKalori hitungKalori = new HitungKalori(0,waktu,beratbadan);
                        hasil.setText("Hasil Kalori yand di bakar " + hitungKalori.getIndexBerenang() + " kkal");
                    }
                    else {
                        Toast.makeText(getActivity(), "Silahkan isi semua table",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

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
        void onFragmentInteraction(Uri uri);
    }
}
