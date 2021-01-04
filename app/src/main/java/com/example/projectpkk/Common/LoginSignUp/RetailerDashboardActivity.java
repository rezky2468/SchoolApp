package com.example.projectpkk.Common.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.projectpkk.Databases.SessionManager;
import com.example.projectpkk.R;
import com.example.projectpkk.UserDashboardActivity;

import java.util.HashMap;

public class RetailerDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_dashboard);

        TextView textView = findViewById(R.id.textView);

        SessionManager sessionManager = new SessionManager(this);
        HashMap<String, String> userDetails = sessionManager.getUsersDetailFromSession();

        String fullName = userDetails.get(SessionManager.KEY_FULLNAME);
        String phoneNumber = userDetails.get(SessionManager.KEY_PHONENUMBER);

        textView.setText(fullName);

    }

    public void callLogout(View view) {
        SessionManager sessionManager = new SessionManager(getApplicationContext());
        sessionManager.logoutUserSession();
        startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
    }
}