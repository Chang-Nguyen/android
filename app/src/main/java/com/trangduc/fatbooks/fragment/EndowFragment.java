package com.trangduc.fatbooks.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.trangduc.fatbooks.R;
import com.trangduc.fatbooks.activity.EndBookActivity;


public class EndowFragment extends Fragment {


    public EndowFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_endow, container, false);

        Button btnview = view.findViewById(R.id.view);

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EndBookActivity.class);

                intent.putExtra("key", "value");

                startActivity(intent);
            }
        });

        return view;
    }



}
