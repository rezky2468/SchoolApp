package com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectpkk.Common.SearchActivity;
import com.example.projectpkk.R;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories1Guru.GuruActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories2Ekskul.EkskulActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories3Event.EventActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories4Denah.DenahActivity;
import com.example.projectpkk.UserDashboardActivity;

public class AllCategoriesActivity extends AppCompatActivity {

    UserDashboardActivity userDashboardActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        // Hooks
        userDashboardActivity = new UserDashboardActivity();

    }

    public void callBackScreen(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
        finish();
    }

    public void callSearchScreen(View view) {
        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
    }

    public void callCategoriesAbsen(View view) {
        startActivity(new Intent(getApplicationContext(), GuruActivity.class));
    }

    public void callCategoriesEkskul(View view) {
        startActivity(new Intent(getApplicationContext(), EkskulActivity.class));
    }

    public void callCategoriesEvent(View view) {
        startActivity(new Intent(getApplicationContext(), EventActivity.class));
    }

    public void callCategoriesAdministrasi(View view) {
        startActivity(new Intent(getApplicationContext(), DenahActivity.class));
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
        finish();
    }

}

