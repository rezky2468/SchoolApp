package com.example.projectpkk.User.BottomNavigationView.Menu1Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpkk.Databases.SessionManager;
import com.example.projectpkk.Databases.ThemeSharedPreferences;
import com.example.projectpkk.HelperClasses.HomeAdapter.BeritaAdapter;
import com.example.projectpkk.HelperClasses.HomeAdapter.BeritaHelperClass;
import com.example.projectpkk.HelperClasses.HomeAdapter.JurusanAdapter;
import com.example.projectpkk.HelperClasses.HomeAdapter.JurusanHelperClass;
import com.example.projectpkk.R;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories1Guru.GuruActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories2Ekskul.EkskulActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories3Event.EventActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories4Denah.DenahActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home2Jurusan.JurusanActivity;
import com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home4Berita.BeritaActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuHomeFragment extends Fragment implements JurusanAdapter.OnJurusanListener, BeritaAdapter.OnBeritaListener {

    // Variables
    Button btnGuru, btnEkskul, btnEvent, btnDenah;
    Switch darkSwitch;
    ThemeSharedPreferences themeSharedPreferences;

    // Add RecyclerView member
    RecyclerView jurusanRecycler, beritaRecycler;
    RecyclerView.Adapter adapter;
    ArrayList<JurusanHelperClass> jurusanLocations;
    ArrayList<BeritaHelperClass> beritaLocations;

    String[] jurusan = {"rpl", "tkj", "pkm"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_beranda, container, false);

        // Hooks
        darkSwitch = view.findViewById(R.id.dark_mode_switch);
        jurusanRecycler = view.findViewById(R.id.jurusan_recycler);
        beritaRecycler = view.findViewById(R.id.berita_recycler);

        btnGuru = view.findViewById(R.id.btn_absen);
        btnEkskul = view.findViewById(R.id.btn_ekskul);
        btnEvent = view.findViewById(R.id.btn_event);
        btnDenah = view.findViewById(R.id.btn_denah);

        // Dark Mode Function
        themeSharedPreferences = new ThemeSharedPreferences(getActivity());

        if (themeSharedPreferences.loadNightModeState()) {
            darkSwitch.setChecked(true);
        } else {
            darkSwitch.setChecked(false);
        }

        darkSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (darkSwitch.isChecked()) {
                    themeSharedPreferences.setNightModeState(true);
                    Toast.makeText(getActivity(), "Restart aplikasi untuk beralih ke tema gelap", Toast.LENGTH_SHORT).show();
                } else {
                    themeSharedPreferences.setNightModeState(false);
                    Toast.makeText(getActivity(), "Restart aplikasi untuk beralih ke tema normal", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Categories Button Functions
        btnGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SessionManager sessionManager = new SessionManager(getActivity());
                HashMap<String, String> hashMap = sessionManager.getUsersDetailFromSession();
                String level = hashMap.get(SessionManager.KEY_LEVEL);
                if (sessionManager.checkLogin() && (level.equals("siswa") || level.equals("guru") || level.equals("admin"))) {
                    startActivity(new Intent(getActivity(), GuruActivity.class));
                } else {
                    Toast.makeText(getActivity(), "Kamu harus login terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnEkskul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), EkskulActivity.class));
            }
        });

        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), EventActivity.class));
            }
        });

        btnDenah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), DenahActivity.class));
            }
        });

        jurusanRecycler();
        beritaRecycler();

        return view;

    }

    public void jurusanRecycler() {
        jurusanRecycler.setHasFixedSize(true);
        jurusanRecycler.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        final ArrayList<JurusanHelperClass> jurusanLocations = new ArrayList<>();
        jurusanLocations.add(new JurusanHelperClass(R.drawable.jurusan1, R.drawable.rpl_icon, "RPL", "Rekayasa Perangkat Lunak"));
        jurusanLocations.add(new JurusanHelperClass(R.drawable.jurusan2, R.drawable.tkj_icon, "TKJ", "Teknik Komputer dan Jaringan"));
        jurusanLocations.add(new JurusanHelperClass(R.drawable.jurusan3, R.drawable.pkm_icon, "PKM", "Perbankan Keuangan Mikro"));

        adapter = new JurusanAdapter(jurusanLocations, this);
        jurusanRecycler.setAdapter(adapter);
    }

    public void beritaRecycler() {
        beritaRecycler.setHasFixedSize(true);
        beritaRecycler.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        ArrayList<BeritaHelperClass> beritaLocations = new ArrayList<>();
        beritaLocations.add(new BeritaHelperClass(R.drawable.berita1, getString(R.string.judulBerita1), getString(R.string.descBerita1)));
        beritaLocations.add(new BeritaHelperClass(R.drawable.berita2, getString(R.string.judulBerita2), getString(R.string.descBerita2)));
        beritaLocations.add(new BeritaHelperClass(R.drawable.berita3, getString(R.string.judulBerita3), getString(R.string.descBerita3)));

        adapter = new BeritaAdapter(beritaLocations, this);
        beritaRecycler.setAdapter(adapter);
    }

    @Override
    public void onJurusanClick(int position) {
        jurusanLocations = new ArrayList<>();
        Intent intent = new Intent(getContext(), JurusanActivity.class);
        intent.putExtra("jurusan", jurusan[position]);
        startActivity(intent);
    }

    @Override
    public void onBeritaClick(int position) {
        beritaLocations = new ArrayList<>();
        Intent intent = new Intent(getContext(), BeritaActivity.class);
        intent.putExtra("index", position);
        startActivity(intent);
    }
}
