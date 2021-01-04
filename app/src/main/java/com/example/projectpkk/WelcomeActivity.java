package com.example.projectpkk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.projectpkk.Databases.SessionManager;
import com.example.projectpkk.Databases.ThemeSharedPreferences;
import com.mahfa.dnswitch.DayNightSwitch;
import com.mahfa.dnswitch.DayNightSwitchListener;
//import com.mahfa.dnswitch.DayNightSwitch;
//import com.mahfa.dnswitch.DayNightSwitchListener;

public class WelcomeActivity extends AppCompatActivity {

    ImageView sun, dayLand, nightLand;
    View daySky, nightSky;
    DayNightSwitch dayNightSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        sun = findViewById(R.id.sun);
        dayLand = findViewById(R.id.day_landscape);
        nightLand = findViewById(R.id.night_landscape);
        daySky = findViewById(R.id.day_bg);
        nightSky = findViewById(R.id.night_bg);
        dayNightSwitch = findViewById(R.id.day_night_switch);

//        final ThemeSharedPreferences themeSharedPreferences = new ThemeSharedPreferences(this);

        sun.setTranslationY(-110);

//        if (themeSharedPreferences.loadNightModeState()) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        }

        dayNightSwitch.setListener(new DayNightSwitchListener() {
            @Override
            public void onSwitch(boolean is_night) {
                if (is_night) {
//                    if (!themeSharedPreferences.loadNightModeState()) {
                    sun.animate().translationY(110).setDuration(1000);
                    dayLand.animate().alpha(0).setDuration(1300);
                    daySky.animate().alpha(0).setDuration(1300);
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    themeSharedPreferences.setNightModeState(true);
//                } else {
//                    return;
                } else {
//                if (themeSharedPreferences.loadNightModeState()) {
                    sun.animate().translationY(-110).setDuration(1000);
                    dayLand.animate().alpha(1).setDuration(1300);
                    daySky.animate().alpha(1).setDuration(1300);
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    themeSharedPreferences.setNightModeState(false);
                }
            }
//        }
        });


    }
}