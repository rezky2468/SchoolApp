package com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home2Jurusan;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectpkk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class JurusanActivity extends AppCompatActivity {

    TextView jurusanJudul, jurusanArtikel, jurusanNamaKaprodi;
    ImageView jurusanImage, jurusanFotoKaprodi;
    FloatingActionButton fabShareJurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_jurusan);

        jurusanJudul = findViewById(R.id.jurusan_judul);
        jurusanArtikel = findViewById(R.id.jurusan_artikel);
        jurusanNamaKaprodi = findViewById(R.id.jurusan_nama_kaprodi);
        jurusanImage = findViewById(R.id.jurusan_image);
        jurusanFotoKaprodi = findViewById(R.id.jurusan_foto_kaprodi);
        fabShareJurusan = findViewById(R.id.fab_share_jurusan);

        String jurusan = getIntent().getStringExtra("jurusan");

        if (jurusan.equals("rpl")) {
            jurusanJudul.setText("Rekayasa Perangkat Lunak");
            jurusanArtikel.setText(Html.fromHtml(getString(R.string.artikelJurusanRPL)));
            jurusanNamaKaprodi.setText("Asep Dimyati Yusup, St");
            jurusanImage.setImageResource(R.drawable.jurusan1);
            jurusanFotoKaprodi.setImageResource(R.drawable.guru_asep_d);
            fabShareJurusan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String shareBody = "SMK BPPI - Rekayasa Perangkat Lunak";
                    String shareSub = "INFO PPDB SMK BPPI";
                    intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                    startActivity(Intent.createChooser(intent, "Bagikan info PPDB dengan"));
                }
            });
        } else if (jurusan.equals("tkj")) {
            jurusanJudul.setText("Teknik Komputer dan Jaringan");
            jurusanArtikel.setText(Html.fromHtml(getString(R.string.artikelJurusanTKJ)));
            jurusanNamaKaprodi.setText("Indra Setia Nugraha, St");
            jurusanImage.setImageResource(R.drawable.jurusan2);
            jurusanFotoKaprodi.setImageResource(R.drawable.guru_indra);
            fabShareJurusan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String shareBody = "SMK BPPI - Teknik Komputer dan Jaringan";
                    String shareSub = "INFO PPDB SMK BPPI";
                    intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                    startActivity(Intent.createChooser(intent, "Bagikan info PPDB dengan"));
                }
            });
        } else if (jurusan.equals("pkm")) {
            jurusanJudul.setText("Perbankan Keuangan Mikro");
            jurusanArtikel.setText(Html.fromHtml(getString(R.string.artikelJurusanPBK)));
            jurusanNamaKaprodi.setText("Devi Adriani, S.Pd");
            jurusanImage.setImageResource(R.drawable.jurusan3);
            jurusanFotoKaprodi.setImageResource(R.drawable.guru_devi);
            fabShareJurusan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String shareBody = "SMK BPPI - Perbankan Keuangan Mikro";
                    String shareSub = "INFO PPDB SMK BPPI";
                    intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                    startActivity(Intent.createChooser(intent, "Bagikan info PPDB dengan"));
                }
            });
        }

    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }

}