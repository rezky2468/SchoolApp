package com.example.projectpkk.User.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

//import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
//import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
//import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.example.projectpkk.Databases.SessionManager;
import com.example.projectpkk.R;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.MenuHomeFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu2Pengumuman.MenuPengumumanFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.MenuJadwalFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu4Profile.MenuProfileFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu4Profile.MenuProfileNoAccountFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.core.view.Change;

public class TentangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tentang);

        TextView textView = findViewById(R.id.tentang_aplikasi);
        Button button = findViewById(R.id.kontak_kami);

        textView.setText(Html.fromHtml(getString(R.string.tentang_aplikasi)));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "ptniacdaa0@gmail.com", null));
                startActivity(Intent.createChooser(intent, null));
            }
        });
    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }

}