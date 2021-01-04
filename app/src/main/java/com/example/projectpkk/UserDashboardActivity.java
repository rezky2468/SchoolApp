package com.example.projectpkk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.projectpkk.Databases.SessionManager;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.AllCategoriesActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu2Pengumuman.MenuPengumumanFragment;
import com.example.projectpkk.Common.LoginSignUp.SignUpActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.MenuJadwalFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu4Profile.MenuProfileFragment;
import com.example.projectpkk.Common.LoginSignUp.LoginActivity;
import com.example.projectpkk.Common.LoginSignUp.RetailerStartUpScreenActivity;
import com.example.projectpkk.Common.SearchActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.MenuHomeFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu4Profile.MenuProfileNoAccountFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories1Guru.GuruActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories4Denah.DenahActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories2Ekskul.EkskulActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories3Event.EventActivity;
import com.example.projectpkk.User.NavigationView.TentangActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
//import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class UserDashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // Variables
    static final float END_SCALE = 0.7f;

    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menuIcon;
    ConstraintLayout contentView;

//    ChipNavigationBar chipNavigationBar;

    BottomNavigationView bottomNavigationView;

//    Boolean isNavBarOpen = false;

    // Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    SharedPreferences darkModeSharedPreferences;

    Animation animation;
    Fragment fm;

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
        setContentView(R.layout.activity_user_dashboard);




//        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(int i) {
//                switch (i) {
//                    case R.id.bottom_nav_home:
//                        fragmentManager.beginTransaction().hide(active).show(fragment1).commit();
//                        active = fragment1;
//                        break;
//                    case R.id.bottom_nav_pengumuman:
//                        fragmentManager.beginTransaction().hide(active).show(fragment2).commit();
//                        active = fragment2;
//                        break;
//                    case R.id.bottom_nav_jadwal:
//                        fragmentManager.beginTransaction().hide(active).show(fragment3).commit();
//                        active = fragment3;
//                        break;
//                    case R.id.bottom_nav_profile:
//                        fragmentManager.beginTransaction().hide(active).show(fragment4).commit();
//                        active = fragment4;
//                        break;
//                }
//            }
//        });

        // Hooks
        contentView = findViewById(R.id.content);

        // Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
//        menuIcon = findViewById(R.id.menu_icon);

//        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        bottomNavigationView = findViewById(R.id.bottom_nav_menu);
//        chipNavigationBar.setItemSelected(R.id.bottom_nav_home, true);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuDashboardFragment()).commit();

//        bottomMenu();

        final FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment5, "5").hide(fragment5).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment4, "4").hide(fragment4).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment3, "3").hide(fragment3).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment2, "2").hide(fragment2).commit();
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragment1, "1").commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_nav_home:
                        fragmentManager.beginTransaction().hide(active).show(fragment1).commit();
                        active = fragment1;
                        return true;
                    case R.id.bottom_nav_pengumuman:
                        fragmentManager.beginTransaction().hide(active).show(fragment2).commit();
                        active = fragment2;
                        return true;
                    case R.id.bottom_nav_jadwal:
                        fragmentManager.beginTransaction().hide(active).show(fragment3).commit();
                        active = fragment3;
                        return true;
                    case R.id.bottom_nav_profile:
                        SessionManager sessionManager = new SessionManager(getApplicationContext());
                        if (sessionManager.checkLogin()) {
                            fragmentManager.beginTransaction().hide(active).show(fragment4).commit();
                            active = fragment4;
                        } else {
                            fragmentManager.beginTransaction().hide(active).show(fragment5).commit();
                            active = fragment5;
                        }
                        return true;
                }
                return false;
            }
        });

        navigationDrawer();


//        SharedPreferences.Editor editor = darkModeSharedPreferences.edit();
//        darkModeSharedPreferences = getSharedPreferences("isDarkModeOn", MODE_PRIVATE);
//        final boolean isDarkModeOn = darkModeSharedPreferences.getBoolean("darkModeOn", true);

        // When user reopens the app after applying dark/light mode
//        if (isDarkModeOn) {
//            SharedPreferences.Editor editor = darkModeSharedPreferences.edit();
//            editor.putBoolean("darkModeOn", false);
//            editor.commit();
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//        }

//        // When user taps the enable/disable dark mode button
//        if (isDarkModeOn) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//            editor.putBoolean("isDarkModeOn", false);
//            editor.apply();
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//            editor.putBoolean("isDarkModeOn", true);
//            editor.apply();
//        }


//        Button toggle = findViewById(R.id.toggle);
//        toggle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//            }
//        });


    }


//    private void bottomMenu() {
//        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(int i) {
//                Fragment fragment = null;
//                switch (i) {
//                    case R.id.bottom_nav_home:
////                        fragment = new MenuDashboardFragment();
////                        break;
//                    case R.id.bottom_nav_pengumuman:
////                        fragment = new MenuPengumumanFragment();
////                        break;
//                    case R.id.bottom_nav_jadwal:
////                        fragment = new MenuJadwalFragment();
////                          fragment = new FragmentAbsenSiswa();
////                        break;
//                    case R.id.bottom_nav_profile:
//                        SessionManager sessionManager = new SessionManager(getApplicationContext());
//                        if (sessionManager.checkLogin()) {
//                            fragment = new MenuProfileFragment();
//                            break;
//                        } else {
//                            fragment = new MenuProfileNoAccount();
//                            break;
//                        }
//                }
////                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
//            }
//        });
//    }

//     Navigation Drawer Functions
    private void animateNavigationDrawer() {

//        drawerLayout.setScrimColor(getResources().getColor(R.color.colorPrimary));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                // Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                // Translate the View, accounting for the scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    private void navigationDrawer() {
        // Navigation Drawer
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            navigationView.bringToFront();
            navigationView.setNavigationItemSelectedListener(this);
//            navigationView.setCheckedItem(R.id.nav_home);
            animateNavigationDrawer();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
//            case R.id.nav_home:
//                Fragment fragment = new MenuDashboardFragment();
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
//                chipNavigationBar.setItemEnabled(1, true);
//                chipNavigationBar.setItemSelected(R.id.bottom_nav_home, true);
//                drawerLayout.closeDrawer(GravityCompat.START);
//                break;
//            case R.id.nav_all_categories:
//                startActivity(new Intent(getApplicationContext(), AllCategories.class));
//                drawerLayout.closeDrawer(GravityCompat.START);
//                break;
            case R.id.nav_login:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_profile:
                Fragment fragment2 = new MenuProfileFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment2).commit();
//                chipNavigationBar.setItemEnabled(1, true);
//                chipNavigationBar.setItemSelected(R.id.bottom_nav_profile, true);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_logout:
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_tentang:
                startActivity(new Intent(getApplicationContext(), TentangActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = "Your body here";
                String shareSub = "Your subject here";
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                startActivity(Intent.createChooser(intent, "Share using"));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
        return true;
    }


//     Normal Functions
    public void callSideBar(View view) {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            drawerLayout.openDrawer(GravityCompat.START);
//            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    public void callRetailerScreens(View view) {
        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreenActivity.class));
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

    public void viewAllCategories(View view) {
        Intent intent = new Intent(getApplicationContext(), AllCategoriesActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


}