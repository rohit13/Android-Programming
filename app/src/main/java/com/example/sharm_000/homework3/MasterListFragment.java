package com.example.sharm_000.homework3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class MasterListFragment extends Fragment {


    private OnButtonClickedListener iFM;

    public MasterListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iFM=(OnButtonClickedListener)getContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_master_list, container, false);
        Button btn1 = (Button) view.findViewById(R.id.movie1);
        Button btn2 = (Button) view.findViewById(R.id.movie2);
        Button btn3 = (Button) view.findViewById(R.id.movie3);
        Button btn4 = (Button) view.findViewById(R.id.movie4);
        Button btn5 = (Button) view.findViewById(R.id.movie5);
        btn1.setOnClickListener(new btnListener(R.id.movie1));
        btn2.setOnClickListener(new btnListener(R.id.movie2));
        btn3.setOnClickListener(new btnListener(R.id.movie3));
        btn4.setOnClickListener(new btnListener(R.id.movie4));
        btn5.setOnClickListener(new btnListener(R.id.movie5));
        return view;
    }

    public static MasterListFragment newInstance() {
        MasterListFragment fragment = new MasterListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    public class btnListener implements View.OnClickListener{
        int btnId;
        public btnListener(int btnID){
            this.btnId = btnID;
        }
        @Override
        public void onClick(View v) {
            iFM.onButtonClicked(btnId) ;
        }
    }

    public interface OnButtonClickedListener{
        public void onButtonClicked(int id);
    }
}
