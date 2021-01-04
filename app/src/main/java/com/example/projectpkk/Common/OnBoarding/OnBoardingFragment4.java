package com.example.projectpkk.Common.OnBoarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.projectpkk.R;
import com.example.projectpkk.UserDashboardActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OnBoardingFragment4 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_on_boarding4, container, false);

        TextView button = view.findViewById(R.id.skip4);
        FloatingActionButton welcome = view.findViewById(R.id.welcome);
//        button = view.findViewById(R.id.skip4);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UserDashboardActivity.class));
            }
        });

        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UserDashboardActivity.class));
            }
        });

        return view;
    }
}