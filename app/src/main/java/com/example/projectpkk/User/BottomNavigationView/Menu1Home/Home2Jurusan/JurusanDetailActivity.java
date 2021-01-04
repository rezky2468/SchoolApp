package com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home2Jurusan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.projectpkk.R;

public class JurusanDetailActivity extends AppCompatActivity {

    String[] juduls = {
            getString(R.string.jurusanRPLJudulDetail1),
            getString(R.string.jurusanRPLJudulDetail2),
            getString(R.string.jurusanRPLJudulDetail3),
            getString(R.string.jurusanRPLJudulDetail4),
            getString(R.string.jurusanRPLJudulDetail5),

            getString(R.string.jurusanTKJJudulDetail1),
            getString(R.string.jurusanTKJJudulDetail2),
            getString(R.string.jurusanTKJJudulDetail3),
            getString(R.string.jurusanTKJJudulDetail4),
            getString(R.string.jurusanTKJJudulDetail5),

            getString(R.string.jurusanPKMJudulDetail1),
            getString(R.string.jurusanPKMJudulDetail2),
            getString(R.string.jurusanPKMJudulDetail3),
            getString(R.string.jurusanPKMJudulDetail4),
            getString(R.string.jurusanPKMJudulDetail5)
    };

    String[] artikels = {
            getString(R.string.jurusanRPLArtikelDetail1),
            getString(R.string.jurusanRPLArtikelDetail2),
            getString(R.string.jurusanRPLArtikelDetail3),
            getString(R.string.jurusanRPLArtikelDetail4),
            getString(R.string.jurusanRPLArtikelDetail5),

            getString(R.string.jurusanTKJArtikelDetail1),
            getString(R.string.jurusanTKJArtikelDetail2),
            getString(R.string.jurusanTKJArtikelDetail3),
            getString(R.string.jurusanTKJArtikelDetail4),
            getString(R.string.jurusanTKJArtikelDetail5),

            getString(R.string.jurusanPKMArtikelDetail1),
            getString(R.string.jurusanPKMArtikelDetail2),
            getString(R.string.jurusanPKMArtikelDetail3),
            getString(R.string.jurusanPKMArtikelDetail4),
            getString(R.string.jurusanPKMArtikelDetail5)

    };

    TextView judul, artikel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_jurusan_detail);

        // Hooks
        judul = findViewById(R.id.jurusan_detail_judul);
        artikel = findViewById(R.id.jurusan_detail_artikel);

        String jurusan = getIntent().getStringExtra("jurusan");
        String detail = getIntent().getStringExtra("detail");

        if (jurusan.equals("rpl")) {
            if (detail.equals("alasan")) {
                judul.setText(juduls[0]);
                artikel.setText(artikels[0]);
            } else if (detail.equals("plusMin")) {
                judul.setText(juduls[1]);
                artikel.setText(artikels[1]);
            } else if (detail.equals("mapel")) {
                judul.setText(juduls[2]);
                artikel.setText(artikels[2]);
            } else if (detail.equals("kuliah")) {
                judul.setText(juduls[3]);
                artikel.setText(artikels[3]);
            } else if (detail.equals("prospek")) {
                judul.setText(juduls[4]);
                artikel.setText(artikels[4]);
            }
        } else if (jurusan.equals("tkj")) {
            if (detail.equals("alasan")) {
                judul.setText(juduls[5]);
                artikel.setText(artikels[5]);
            } else if (detail.equals("plusMin")) {
                judul.setText(juduls[6]);
                artikel.setText(artikels[6]);
            } else if (detail.equals("mapel")) {
                judul.setText(juduls[7]);
                artikel.setText(artikels[7]);
            } else if (detail.equals("kuliah")) {
                judul.setText(juduls[8]);
                artikel.setText(artikels[8]);
            } else if (detail.equals("prospek")) {
                judul.setText(juduls[9]);
                artikel.setText(artikels[9]);
            }
        } else if (jurusan.equals("pkm")) {
            if (detail.equals("alasan")) {
                judul.setText(juduls[10]);
                artikel.setText(artikels[10]);
            } else if (detail.equals("plusMin")) {
                judul.setText(juduls[11]);
                artikel.setText(artikels[11]);
            } else if (detail.equals("mapel")) {
                judul.setText(juduls[12]);
                artikel.setText(artikels[12]);
            } else if (detail.equals("kuliah")) {
                judul.setText(juduls[13]);
                artikel.setText(artikels[13]);
            } else if (detail.equals("prospek")) {
                judul.setText(juduls[14]);
                artikel.setText(artikels[14]);
            }
        }
    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }
}