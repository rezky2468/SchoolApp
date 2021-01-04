package com.example.projectpkk.User.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
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

    final Fragment fragment1 = new MenuHomeFragment();
    final Fragment fragment2 = new MenuPengumumanFragment();
    final Fragment fragment3 = new MenuJadwalFragment();
    final Fragment fragment4 = new MenuProfileFragment();
    final Fragment fragment5 = new MenuProfileNoAccountFragment();
    Fragment active = fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tentang);

        AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);



        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Beranda", R.drawable.ic_menu_beranda_24, R.color.colorPrimary);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Pengumuman", R.drawable.ic_menu_pengumuman_24, R.color.colorPrimary);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Jadwal", R.drawable.ic_menu_jadwal_24, R.color.colorPrimary);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Profil", R.drawable.ic_menu_profile_24, R.color.colorPrimary);

        // Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);

        // Set background color
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FEFEFE"));
//
//// Disable the translation inside the CoordinatorLayout
//        bottomNavigation.setBehaviorTranslationEnabled(false);
//
// Enable the translation of the FloatingActionButton
//        bottomNavigation.manageFloatingActionButtonBehavior(floatingActionButton);
//
    // Change colors
//        bottomNavigation.setAccentColor(Color.parseColor("#75a6eb"));
//        bottomNavigation.setInactiveColor(Color.parseColor("#747474"));
//
//// Force to tint the drawable (useful for font with icon for example)
//        bottomNavigation.setForceTint(true);
//
//// Display color under navigation bar (API 21+)
//// Don't forget these lines in your style-v21
//// <item name="android:windowTranslucentNavigation">true</item>
//// <item name="android:fitsSystemWindows">true</item>
//        bottomNavigation.setTranslucentNavigationEnabled(true);
//
//// Manage titles
//        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
//        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
//        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);
//
//// Use colored navigation with circle reveal effect
//        bottomNavigation.setColored(true);
//
//// Set current item programmatically
//        bottomNavigation.setCurrentItem(1);
//
//// Customize notification (title, background, typeface)
//        bottomNavigation.setNotificationBackgroundColor(Color.parseColor("#F63D2B"));
//
//// Add or remove notification for each item
        bottomNavigation.setNotification("1", 2);
//// OR
//        AHNotification notification = new AHNotification.Builder()
//                .setText("1")
//                .setBackgroundColor(ContextCompat.getColor(DemoActivity.this, R.color.color_notification_back))
//                .setTextColor(ContextCompat.getColor(DemoActivity.this, R.color.color_notification_text))
//                .build();
//        bottomNavigation.setNotification(notification, 1);
//
//// Enable / disable item & set disable color
//        bottomNavigation.enableItemAtPosition(2);
//        bottomNavigation.disableItemAtPosition(2);
//        bottomNavigation.setItemDisableColor(Color.parseColor("#3A000000"));
//
//// Set listeners
//        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
//            @Override
//            public boolean onTabSelected(int position, boolean wasSelected) {
//                // Do something cool here...
//                return true;
//            }
//        });
//        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
//            @Override
//            public void onPositionChange(int y) {
//                // Manage the new y position
//            }
//        });

//        final FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment5, "5").hide(fragment5).commit();
//        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment4, "4").hide(fragment4).commit();
//        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment3, "3").hide(fragment3).commit();
//        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment2, "2").hide(fragment2).commit();
//        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment1, "1").commit();
//
//        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
//            @Override
//            public boolean onTabSelected(int position, boolean wasSelected) {
//                // Do something cool here...
//                switch (position) {
//                    case R.id.bottom_nav_home:
//                        fragmentManager.beginTransaction().hide(active).show(fragment1).commit();
//                        active = fragment1;
//                        return true;
//                    case R.id.bottom_nav_pengumuman:
//                        fragmentManager.beginTransaction().hide(active).show(fragment2).commit();
//                        active = fragment2;
//                        return true;
//                    case R.id.bottom_nav_jadwal:
//                        fragmentManager.beginTransaction().hide(active).show(fragment3).commit();
//                        active = fragment3;
//                        return true;
//                    case R.id.bottom_nav_profile:
//                        SessionManager sessionManager = new SessionManager(getApplicationContext());
//                        if (sessionManager.checkLogin()) {
//                            fragmentManager.beginTransaction().hide(active).show(fragment4).commit();
//                            active = fragment4;
//                        } else {
//                            fragmentManager.beginTransaction().hide(active).show(fragment5).commit();
//                            active = fragment5;
//                        }
//                        return true;
//                }
//                return false;
//            }
//        });

//        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.bottom_nav_home:
//                        fragmentManager.beginTransaction().hide(active).show(fragment1).commit();
//                        active = fragment1;
//                        return true;
//                    case R.id.bottom_nav_pengumuman:
//                        fragmentManager.beginTransaction().hide(active).show(fragment2).commit();
//                        active = fragment2;
//                        return true;
//                    case R.id.bottom_nav_jadwal:
//                        fragmentManager.beginTransaction().hide(active).show(fragment3).commit();
//                        active = fragment3;
//                        return true;
//                    case R.id.bottom_nav_profile:
//                        SessionManager sessionManager = new SessionManager(getApplicationContext());
//                        if (sessionManager.checkLogin()) {
//                            fragmentManager.beginTransaction().hide(active).show(fragment4).commit();
//                            active = fragment4;
//                        } else {
//                            fragmentManager.beginTransaction().hide(active).show(fragment5).commit();
//                            active = fragment5;
//                        }
//                        return true;
//                }
//                return false;
//            }
//        });

    }
}