package com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home4Berita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectpkk.R;

public class BeritaActivity extends AppCompatActivity {

    private static final String TAG = "SomeActivity";
    TextView beritaJudul, beritaTanggal, beritaArtikel;
    ImageView beritaImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_berita_terbaru);

        String[] judul = {
                getString(R.string.judulBerita1),
                getString(R.string.judulBerita2),
                getString(R.string.judulBerita3)
        };

        String[] tanggal = {
                getString(R.string.tanggalBerita1),
                getString(R.string.tanggalBerita2),
                getString(R.string.tanggalBerita3)
        };

        String[] artikel = {
                getString(R.string.artikelBerita1),
                getString(R.string.artikelBerita2),
                getString(R.string.artikelBerita3)
        };

        beritaJudul = findViewById(R.id.berita_judul);
        beritaTanggal = findViewById(R.id.berita_tanggal);
        beritaArtikel = findViewById(R.id.berita_artikel);

        beritaImage = findViewById(R.id.berita_image);

        int _index = getIntent().getIntExtra("index", -1);

        if (_index == 0) {
            beritaJudul.setText(judul[0]);
            beritaTanggal.setText(tanggal[0]);
            beritaArtikel.setText(Html.fromHtml(artikel[0]));
            beritaImage.setImageResource(R.drawable.berita1);
        } else if (_index == 1) {
            beritaJudul.setText(judul[1]);
            beritaTanggal.setText(tanggal[1]);
            beritaArtikel.setText(Html.fromHtml(artikel[1]));
            beritaImage.setImageResource(R.drawable.berita2);
        } else if (_index == 2) {
            beritaJudul.setText(judul[2]);
            beritaTanggal.setText(tanggal[2]);
            beritaArtikel.setText(Html.fromHtml(artikel[2]));
            beritaImage.setImageResource(R.drawable.berita3);
        }

    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }
}