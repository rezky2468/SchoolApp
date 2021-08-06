package com.example.projectpkk.User.BottomNavigationView.Menu2Pengumuman;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectpkk.Pengumuman;
import com.example.projectpkk.R;

public class PengumumanDetailActivity extends AppCompatActivity {

    // Variables
    TextView pengumumanDetailTitle, pengumumanDetailDate, pengumumanDetailDesc;
    ImageView share;
    String judul, tanggal, isi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pengumuman_detail);

        // Hooks
        pengumumanDetailTitle = findViewById(R.id.pengumuman_detail_title);
        pengumumanDetailDate = findViewById(R.id.pengumuman_detail_date);
        pengumumanDetailDesc = findViewById(R.id.pengumuman_detail_desc);
        share = findViewById(R.id.pengumuman_share);

        Pengumuman pengumuman = (Pengumuman) getIntent().getParcelableArrayListExtra("PENGUMUMAN");
        judul = pengumuman.getJudul();
        tanggal = pengumuman.getTanggal();
        isi = pengumuman.getIsi();

        pengumumanDetailTitle.setText(judul);
        pengumumanDetailDate.setText(tanggal);
        pengumumanDetailDesc.setText(isi);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareSubject = judul;
                String shareBody = "PENGUMUMAN: " + judul + "\nTANGGAL: " + tanggal + "\n\n" + isi;
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(intent, "Bagikan pengumuman ke"));
            }
        });

    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }

}