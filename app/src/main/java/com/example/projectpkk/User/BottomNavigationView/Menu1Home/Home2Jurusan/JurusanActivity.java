package com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home2Jurusan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectpkk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class JurusanActivity extends AppCompatActivity {

    String[] artikel = {
//            Resources.getSystem().getString(R.string.jurusanRPL),
//            getResources().getString(R.string.jurusanTKJ),
//            getResources().getString(R.string.jurusanPBK)
            "l",
            "l",
            "l",
    };

    TextView jurusanJudul, jurusanArtikel, jurusanNamaKaprodi;
    Button jurusan1, jurusan2, jurusan3, jurusan4, jurusan5;
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

//        jurusan1 = findViewById(R.id.jurusan1);
//        jurusan2 = findViewById(R.id.jurusan2);
//        jurusan3 = findViewById(R.id.jurusan3);
//        jurusan4 = findViewById(R.id.jurusan4);
//        jurusan5 = findViewById(R.id.jurusan5);

        String jurusan = getIntent().getStringExtra("jurusan");
//        int _index = getIntent().getIntExtra("index");

        if (jurusan.equals("rpl")) {
            jurusanJudul.setText("Rekayasa Perangkat Lunak");
            jurusanArtikel.setText(R.string.jurusanRPL);
            jurusanNamaKaprodi.setText("Asep Dimyati Yusup, St");
            jurusanImage.setImageResource(R.drawable.jurusan1);
            jurusanFotoKaprodi.setImageResource(R.drawable.guru_asep_d_y);
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
            jurusanArtikel.setText(R.string.jurusanRPL);
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
            jurusanArtikel.setText(R.string.jurusanRPL);
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


//        jurusan1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String _jurusan = getIntent().getStringExtra("jurusan");
//
//                Intent intent = new Intent(getApplicationContext(), JurusanDetailActivity.class);
//
//                if (_jurusan.equals("rpl")) {
//                    intent.putExtra("jurusan", "rpl");
//                    intent.putExtra("detail", "alasan");
//                    startActivity(intent);
//                } else if (_jurusan.equals("tkj")) {
//                    intent.putExtra("jurusan", "tkj");
//                    intent.putExtra("detail", "alasan");
//                    startActivity(intent);
//                } else if (_jurusan.equals("pkm")) {
//                    intent.putExtra("jurusan", "pkm");
//                    intent.putExtra("detail", "alasan");
//                    startActivity(intent);
//                }
//            }
//        });
//
//        jurusan2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String _jurusan = getIntent().getStringExtra("jurusan");
//
//                Intent intent = new Intent(getApplicationContext(), JurusanDetailActivity.class);
//
//                if (_jurusan.equals("rpl")) {
//                    intent.putExtra("jurusan", "rpl");
//                    intent.putExtra("detail", "plusMin");
//                    startActivity(intent);
//                } else if (_jurusan.equals("tkj")) {
//                    intent.putExtra("jurusan", "tkj");
//                    intent.putExtra("detail", "plusMin");
//                    startActivity(intent);
//                } else if (_jurusan.equals("pkm")) {
//                    intent.putExtra("jurusan", "pkm");
//                    intent.putExtra("detail", "plusMin");
//                    startActivity(intent);
//                }
//            }
//        });
//
//        jurusan3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String _jurusan = getIntent().getStringExtra("jurusan");
//
//                Intent intent = new Intent(getApplicationContext(), JurusanDetailActivity.class);
//
//                if (_jurusan.equals("rpl")) {
//                    intent.putExtra("jurusan", "rpl");
//                    intent.putExtra("detail", "mapel");
//                    startActivity(intent);
//                } else if (_jurusan.equals("tkj")) {
//                    intent.putExtra("jurusan", "tkj");
//                    intent.putExtra("detail", "mapel");
//                    startActivity(intent);
//                } else if (_jurusan.equals("pkm")) {
//                    intent.putExtra("jurusan", "pkm");
//                    intent.putExtra("detail", "mapel");
//                    startActivity(intent);
//                }
//            }
//        });
//
//        jurusan4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String _jurusan = getIntent().getStringExtra("jurusan");
//
//                Intent intent = new Intent(getApplicationContext(), JurusanDetailActivity.class);
//
//                if (_jurusan.equals("rpl")) {
//                    intent.putExtra("jurusan", "rpl");
//                    intent.putExtra("detail", "kuliah");
//                    startActivity(intent);
//                } else if (_jurusan.equals("tkj")) {
//                    intent.putExtra("jurusan", "tkj");
//                    intent.putExtra("detail", "kuliah");
//                    startActivity(intent);
//                } else if (_jurusan.equals("pkm")) {
//                    intent.putExtra("jurusan", "pkm");
//                    intent.putExtra("detail", "kuliah");
//                    startActivity(intent);
//                }
//            }
//        });
//
//        jurusan5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String _jurusan = getIntent().getStringExtra("jurusan");
//
//                Intent intent = new Intent(getApplicationContext(), JurusanDetailActivity.class);
//
//                if (_jurusan.equals("rpl")) {
//                    intent.putExtra("jurusan", "rpl");
//                    intent.putExtra("detail", "prospek");
//                    startActivity(intent);
//                } else if (_jurusan.equals("tkj")) {
//                    intent.putExtra("jurusan", "tkj");
//                    intent.putExtra("detail", "prospek");
//                    startActivity(intent);
//                } else if (_jurusan.equals("pkm")) {
//                    intent.putExtra("jurusan", "pkm");
//                    intent.putExtra("detail", "prospek");
//                    startActivity(intent);
//                }
//            }
//        });
    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }

    public void shareJurusan(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String shareBody = "Your body here";
        String shareSub = "INFO PPDB SMK BPPI";
        intent.putExtra(Intent.EXTRA_TEXT, shareBody);
        intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
        startActivity(Intent.createChooser(intent, "Share using"));
    }

//    public void callJurusanAlasan(View view) {
//
//        String _jurusan = getIntent().getStringExtra("jurusan");
//
//        Intent intent = new Intent(getApplicationContext(), JurusanDetail.class);
//
//        if (_jurusan.equals("rpl")) {
//            intent.putExtra("jurusan", "rpl");
//            intent.putExtra("detail", "alasan");
//            startActivity(intent);
//        } else if (_jurusan.equals("tkj")) {
//            intent.putExtra("jurusan", "tkj");
//            intent.putExtra("detail", "alasan");
//            startActivity(intent);
//        } else if (_jurusan.equals("pkm")) {
//            intent.putExtra("jurusan", "pkm");
//            intent.putExtra("detail", "alasan");
//            startActivity(intent);
//        }
//
//    }
//
//    public void callJurusanPlusMin(View view) {
//
//        String _jurusan = getIntent().getStringExtra("jurusan");
//
//        Intent intent = new Intent(getApplicationContext(), JurusanDetail.class);
//
//        if (_jurusan.equals("rpl")) {
//            intent.putExtra("jurusan", "rpl");
//            intent.putExtra("detail", "plusMin");
//            startActivity(intent);
//        } else if (_jurusan.equals("tkj")) {
//            intent.putExtra("jurusan", "tkj");
//            intent.putExtra("detail", "plusMin");
//            startActivity(intent);
//        } else if (_jurusan.equals("pkm")) {
//            intent.putExtra("jurusan", "pkm");
//            intent.putExtra("detail", "plusMin");
//            startActivity(intent);
//        }
//
//    }
//
//    public void callJurusanMapel(View view) {
//
//        String _jurusan = getIntent().getStringExtra("jurusan");
//
//        Intent intent = new Intent(getApplicationContext(), JurusanDetail.class);
//
//        if (_jurusan.equals("rpl")) {
//            intent.putExtra("jurusan", "rpl");
//            intent.putExtra("detail", "mapel");
//            startActivity(intent);
//        } else if (_jurusan.equals("tkj")) {
//            intent.putExtra("jurusan", "tkj");
//            intent.putExtra("detail", "mapel");
//            startActivity(intent);
//        } else if (_jurusan.equals("pkm")) {
//            intent.putExtra("jurusan", "pkm");
//            intent.putExtra("detail", "mapel");
//            startActivity(intent);
//        }
//
//    }
//
//    public void callJurusanKuliah(View view) {
//
//        String _jurusan = getIntent().getStringExtra("jurusan");
//
//        Intent intent = new Intent(getApplicationContext(), JurusanDetail.class);
//
//        if (_jurusan.equals("rpl")) {
//            intent.putExtra("jurusan", "rpl");
//            intent.putExtra("detail", "kuliah");
//            startActivity(intent);
//        } else if (_jurusan.equals("tkj")) {
//            intent.putExtra("jurusan", "tkj");
//            intent.putExtra("detail", "kuliah");
//            startActivity(intent);
//        } else if (_jurusan.equals("pkm")) {
//            intent.putExtra("jurusan", "pkm");
//            intent.putExtra("detail", "kuliah");
//            startActivity(intent);
//        }
//
//    }
//
//    public void callJurusanProspek(View view) {
//
//        String _jurusan = getIntent().getStringExtra("jurusan");
//
//        Intent intent = new Intent(getApplicationContext(), JurusanDetail.class);
//
//        if (_jurusan.equals("rpl")) {
//            intent.putExtra("jurusan", "rpl");
//            intent.putExtra("detail", "prospek");
//            startActivity(intent);
//        } else if (_jurusan.equals("tkj")) {
//            intent.putExtra("jurusan", "tkj");
//            intent.putExtra("detail", "prospek");
//            startActivity(intent);
//        } else if (_jurusan.equals("pkm")) {
//            intent.putExtra("jurusan", "pkm");
//            intent.putExtra("detail", "prospek");
//            startActivity(intent);
//        }
//
//    }

}