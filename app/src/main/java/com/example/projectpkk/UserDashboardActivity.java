package com.example.projectpkk;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.projectpkk.Databases.SessionManager;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.MenuHomeFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu2Pengumuman.MenuPengumumanFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.MenuJadwalFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu4Profile.MenuProfileFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu4Profile.MenuProfileNoAccountFragment;
import com.example.projectpkk.User.NavigationView.GaleriFoto.FotoActivity;
import com.example.projectpkk.User.NavigationView.TentangActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

;

public class UserDashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // Variables
    static final float END_SCALE = 0.7f;
    ConstraintLayout contentView;
    BottomNavigationView bottomNavigationView;

    // Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    final Fragment fragment1 = new MenuHomeFragment();
    final Fragment fragment2 = new MenuPengumumanFragment();
    final Fragment fragment3 = new MenuJadwalFragment();
    final Fragment fragment4 = new MenuProfileFragment();
    final Fragment fragment5 = new MenuProfileNoAccountFragment();
    Fragment active = fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

//        int theme = getThemeFromPreferences(R.style.AppTheme_RED);
//        setTheme(theme);

//        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
//        DatabaseReference reference = rootNode.getReference("Users");
//        UserHelperClass addNewUser = new UserHelperClass("Asep Surya", "asep123", "asep123@gmail.com", "123", "Laki-laki", "28/12/2002", "+6280000000000");
//        reference.child("+6280000000000").setValue(addNewUser);

        // Hooks
        contentView = findViewById(R.id.content);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        bottomNavigationView = findViewById(R.id.bottom_nav_menu);

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

//        StatusBarUtil.setTransparent(UserDashboardActivity.class);

    }

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
//            animateNavigationDrawer();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_foto:
                startActivity(new Intent(getApplicationContext(), FotoActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_tentang:
                startActivity(new Intent(getApplicationContext(), TentangActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_share:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = "Proyek PKK membuat aplikasi info SMK BPPI";
                String shareSub = "Aplikasi SMK BPPI";
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                startActivity(Intent.createChooser(intent, "Share using"));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
//            case R.id.nav_theme:
//                startActivity(new Intent(getApplicationContext(), ThemeActivity.class));
        }
        return true;
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