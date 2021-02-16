package com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories2Ekskul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.projectpkk.R;

public class EkskulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_categories_ekskul);
    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }


}