package com.example.projectpkk.User.BottomNavigationView.Menu1Home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import com.example.projectpkk.Common.LoginSignUp.RetailerDashboardActivity;
import com.example.projectpkk.Common.LoginSignUp.RetailerStartUpScreenActivity;
import com.example.projectpkk.Databases.SessionManager;
import com.example.projectpkk.HelperClasses.HomeAdapter.FeaturedAdapter;
import com.example.projectpkk.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.projectpkk.HelperClasses.HomeAdapter.MostViewedAdapter;
import com.example.projectpkk.HelperClasses.HomeAdapter.MostViewedHelperClass;
import com.example.projectpkk.R;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories4Denah.DenahActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home3Berita.BeritaActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories1Guru.GuruActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories2Ekskul.EkskulActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories3Event.EventActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home2Jurusan.JurusanActivity;
import com.example.projectpkk.WelcomeActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MenuHomeFragment extends Fragment implements FeaturedAdapter.OnJurusanListener, MostViewedAdapter.OnBeritaListener {

    // Variables
//    static final float END_SCALE = 0.7f;


    // Add RecyclerView member
    private RecyclerView featuredRecycler, mvRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    Button buttonJurusan;

    ArrayList<FeaturedHelperClass> featuredLocations;
    ArrayList<MostViewedHelperClass> mostViewedLocations;

//    ImageView menuIcon;

    // Drawer Menu
//    DrawerLayout drawerLayout;
//    NavigationView navigationView;

    Button btnAbsen, btnEkskul, btnEvent, btnAdministrasi;
    ImageView account, menuIcon;
    Switch darkSwitch;

    FloatingActionButton fabMap;

//    LinearLayout contentView;

    SharedPreferences darkModeSharedPreferences;

    // Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    int[] index = {
            1,
            2,
            3
    };

    String[] jurusan = {
            "rpl",
            "tkj",
            "pkm"
    };

//    String[] artikel = {
//            getString(R.string.jurusanRPL),
//            getString(R.string.jurusanTKJ),
//            getString(R.string.jurusanPBK)
//    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_dashboard, container, false);

        // Menu Hooks
        drawerLayout = view.findViewById(R.id.drawer_layout);
        navigationView = view.findViewById(R.id.navigation_view);

        // Add the following lines to create RecyclerView
        featuredRecycler = view.findViewById(R.id.featured_recycler);
        mvRecycler = view.findViewById(R.id.mv_recycler);

        btnAbsen = view.findViewById(R.id.btnAbsen);
        btnAbsen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), GuruActivity.class));
            }
        });

        btnEkskul = view.findViewById(R.id.btnEkskul);
        btnEkskul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), EkskulActivity.class));
            }
        });

        btnEvent = view.findViewById(R.id.btnEvent);
        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), EventActivity.class));
            }
        });

        btnAdministrasi = view.findViewById(R.id.btnAdministrasi);
        btnAdministrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DenahActivity.class));
            }
        });

//        darkSwitch = view.findViewById(R.id.dark_mode);
//        darkSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (darkSwitch.isChecked()) {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    darkSwitch.setChecked(true);
//                } else if (!darkSwitch.isChecked()){
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    darkSwitch.setChecked(false);
//                }
//            }
//        });

        menuIcon = view.findViewById(R.id.menu_icon);
        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), WelcomeActivity.class));
            }
        });

//        fabMap = view.findViewById(R.id.fab_map);
//        fabMap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getContext(), SchoolMap.class));
//            }
//        });

        featuredRecycler();
        mvRecycler();

        return view;

    }


    public void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        final ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedHelperClass(R.drawable.jurusan1, R.drawable.rpl_icon, "RPL", "Rekayasa Perangkat Lunak"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.jurusan2, R.drawable.tkj_icon, "TKJ", "Teknik Komputer dan Jaringan"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.jurusan3, R.drawable.pkm_icon, "PKM", "Perbankan Keuangan Mikro"));

        adapter = new FeaturedAdapter(featuredLocations, this);
        featuredRecycler.setAdapter(adapter);

    }

    public void mvRecycler() {
        mvRecycler.setHasFixedSize(true);
        mvRecycler.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<MostViewedHelperClass> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.berita1, getString(R.string.judulBerita1), getString(R.string.descBerita1)));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.berita2, getString(R.string.judulBerita2), getString(R.string.descBerita2)));
        mostViewedLocations.add(new MostViewedHelperClass(R.drawable.berita3, getString(R.string.judulBerita3), getString(R.string.descBerita3)));

        adapter = new MostViewedAdapter(mostViewedLocations, this);
        mvRecycler.setAdapter(adapter);
    }

    @Override
    public void onJurusanClick(int position) {

        featuredLocations = new ArrayList<>();
//        featuredLocations.get(position);
//        Log.d(TAG, "onNoteClick: clicked." + position);

        Intent intent = new Intent(getContext(), JurusanActivity.class);
        intent.putExtra("jurusan", jurusan[position]);
//        intent.putExtra("index", index[position]);
        startActivity(intent);
    }


    @Override
    public void onBeritaClick(int position) {
        mostViewedLocations = new ArrayList<>();
        Intent intent = new Intent(getContext(), BeritaActivity.class);
        intent.putExtra("index", position);
        startActivity(intent);
    }
}
