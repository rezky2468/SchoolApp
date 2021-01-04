package com.example.projectpkk.Databases;

import android.content.Context;
import android.content.SharedPreferences;

public class ThemeSharedPreferences {

    SharedPreferences themeSharedPrefrences;
    SharedPreferences.Editor editor;
    Context context;

    public ThemeSharedPreferences(Context context) {
        this.context = context;
        themeSharedPrefrences = context.getSharedPreferences("ThemeSharedPreferences", Context.MODE_PRIVATE);
    }

    public void setNightModeState(Boolean state) {
        editor.putBoolean("NightMode", state);
        editor.commit();
    }

    public Boolean loadNightModeState() {
        Boolean state = themeSharedPrefrences.getBoolean("NightMode", false);
        return state;
    }

}
