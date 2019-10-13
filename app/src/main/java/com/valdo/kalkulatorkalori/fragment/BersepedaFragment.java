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
import android.widget.TextView;
import android.widget.Toast;

import com.valdo.kalkulatorkalori.R;
import com.valdo.kalkulatorkalori.util.HitungKalori;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BersepedaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BersepedaFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private EditText beratBadan, waktu, kecepatan;
    private Button button;

    public BersepedaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bersepeda, container, false);
        beratBadan = view.findViewById(R.id.beratBadanSepeda);
        waktu = view.findViewById(R.id.waktuSepeda);
        kecepatan = view.findViewById(R.id.kecepatanSepeda);
        button = view.findViewById(R.id.hitungSepeda);
        final TextView hasil = view.findViewById(R.id.hasilBersepeda);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener == null){
                    String beratBadanString = beratBadan.getText().toString();
                    String waktuString = waktu.getText().toString();
                    String kecepatanString = kecepatan.getText().toString();
                    if (!TextUtils.isEmpty(beratBadanString) && !TextUtils.isEmpty(waktuString) && !TextUtils.isEmpty(kecepatanString)){
                        int beratBadan = Integer.parseInt(beratBadanString);
                        int waktu = Integer.parseInt(waktuString);
                        int kecepatan = Integer.parseInt(kecepatanString);
                        HitungKalori hitungKalori = new HitungKalori(kecepatan,waktu,beratBadan);
                        hasil.setText("Kalori Yang telah di bakar " + hitungKalori.getIndexBersepeda() + " kkal");


                    }
                    else {
                        Toast.makeText(getActivity(),"Silahkan Isi semua form",Toast.LENGTH_SHORT).show();
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
