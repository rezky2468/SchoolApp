package com.example.projectpkk.User.BottomNavigationView.Menu4Profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.projectpkk.Common.LoginSignUp.LoginActivity;
import com.example.projectpkk.Common.LoginSignUp.SignUpActivity;
import com.example.projectpkk.R;

public class MenuProfileNoAccountFragment extends Fragment {

    Button login, signUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_profile_no_account, container, false);

        login = view.findViewById(R.id.profile_login_btn);
        signUp = view.findViewById(R.id.profile_sign_up_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SignUpActivity.class));
            }
        });

        return view;

    }
}