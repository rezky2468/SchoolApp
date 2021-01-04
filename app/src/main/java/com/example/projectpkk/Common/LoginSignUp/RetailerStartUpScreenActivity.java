package com.example.projectpkk.Common.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;

import com.example.projectpkk.R;

public class RetailerStartUpScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_start_up_screen);
    }

    public void callLoginScreen(View view) {

        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(findViewById(R.id.login_btn), "transition_login");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RetailerStartUpScreenActivity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

    public void callSignUpScreen(View view) {

        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

            Pair[] pairs = new Pair[1];
            pairs[0] = new Pair<View, String>(findViewById(R.id.sign_up_btn), "transition_sign_up");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RetailerStartUpScreenActivity.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }
    }

}