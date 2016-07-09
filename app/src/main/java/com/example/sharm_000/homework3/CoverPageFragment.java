package com.example.sharm_000.homework3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CoverPageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CoverPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoverPageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private OnFragmentInteractionListener mListener;
    private OnButtonClickedListener bListener;
    private OnTask2ButtonClickedListener t2Listener;
    private OnTask3ButtonClickedListener t3Listener;
    Button aboutme;
    Button task2;
    Button task3;
    public CoverPageFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CoverPageFragment newInstance() {
        CoverPageFragment fragment = new CoverPageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            /*mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);*/
        }
        try{
            bListener = (OnButtonClickedListener) getContext();
            t2Listener = (OnTask2ButtonClickedListener) getContext();
            t3Listener = (OnTask3ButtonClickedListener) getContext();
        }catch(ClassCastException ex){
            throw new ClassCastException("forget to implement interface");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cover_page, container, false);
        aboutme = (Button) view.findViewById(R.id.aboutme);
        aboutme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bListener.onButtonClicked(savedInstanceState);
            }
        });
        task2 = (Button) view.findViewById(R.id.task2);
        task2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                t2Listener.onTask2ButtonClick(savedInstanceState);
            }
        });

        task3 = (Button) view.findViewById(R.id.task3);
        task3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                t3Listener.onTask3ButtonClick(savedInstanceState);
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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    public interface OnButtonClickedListener{
        public void onButtonClicked(Bundle savedInstanceState);
    }

    public interface OnTask2ButtonClickedListener{
        public void onTask2ButtonClick(Bundle savedInstanceState);
    }

    public  interface OnTask3ButtonClickedListener{
        public void onTask3ButtonClick(Bundle savedInstanceState);
    }
}
