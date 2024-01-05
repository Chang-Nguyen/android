package com.trangduc.fatbooks.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.trangduc.fatbooks.R;

public class LoginRequiredFragment extends Fragment {

    public LoginRequiredFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_required, container, false);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button yesButton = view.findViewById(R.id.yes);
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToLoginFragment();
            }
        });

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button noButton = view.findViewById(R.id.no);
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Bạn đã từ chối", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    private void switchToLoginFragment() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.frame_container, new LoginFragment());

        transaction.addToBackStack(null);

        transaction.commit();
    }
}
