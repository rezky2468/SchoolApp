package com.example.projectpkk.User.BottomNavigationView.Menu4Profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.projectpkk.Databases.SessionManager;
import com.example.projectpkk.R;
import com.example.projectpkk.UserDashboardActivity;

import java.util.HashMap;
public class MenuProfileFragment extends Fragment {

    Button btnEmail;
    Button btnWhatsapp;
    Button logout;
    TextView fullName, email, phone, dob;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_profile, container, false);

        fullName = view.findViewById(R.id.profile_full_name);
        email = view.findViewById(R.id.profile_email);
        phone = view.findViewById(R.id.profile_phone);
        dob = view.findViewById(R.id.profile_dob);
        logout = view.findViewById(R.id.profile_logout);

        SessionManager sessionManager = new SessionManager(getActivity());
        HashMap<String, String> hashMap = sessionManager.getUsersDetailFromSession();

        String _fullName = hashMap.get(SessionManager.KEY_FULLNAME);
        String _email = hashMap.get(SessionManager.KEY_EMAIL);
        String _phone = hashMap.get(SessionManager.KEY_PHONENUMBER);
        String _dob = hashMap.get(SessionManager.KEY_DATE);

        fullName.setText(_fullName);
        email.setText(_email);
        phone.setText(_phone);
        dob.setText(_dob);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionManager sessionManager = new SessionManager(getActivity());
                sessionManager.logoutUserSession();
            }
        });

//        btnEmail = view.findViewById(R.id.btn_email);
//        btnWhatsapp = view.findViewById(R.id.btn_whatsapp);

//        btnEmail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String subject = "Subject";
//                String message = "Message";
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setType("message/rfc822");
//                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
//                intent.putExtra(Intent.EXTRA_TEXT, message);
//                Intent mailer = Intent.createChooser(intent, null);
//                startActivity(mailer);
//            }
//        });

//        btnWhatsapp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String number = "+62895345213909";
//                String url = "https://api.whatsapp.com/send?phone=" + number;
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(url));
//                startActivity(intent);
//            }
//        });

        return view;
    }


}