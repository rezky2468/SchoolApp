package com.example.projectpkk.Admin;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectpkk.HelperClasses.PengumumanAdapter.PengumumanHelperClass;
import com.example.projectpkk.R;
import com.example.projectpkk.UserDashboardActivity;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class AddNewPengumumanActivity extends AppCompatActivity {

    ImageView backBtn;
    TextInputLayout judulET, isiET;
    Button saveBtn;
    String isi, judul, tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_new_pengumuman);

        backBtn = findViewById(R.id.pengumuman_tambah_back_btn);
        judulET = findViewById(R.id.pengumuman_tambah_judul);
        isiET = findViewById(R.id.pengumuman_tambah_isi);
        saveBtn = findViewById(R.id.pengumuman_tambah_save_btn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddNewPengumumanActivity.super.onBackPressed();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(AddNewPengumumanActivity.this, R.style.AlertDialog);
                builder.setMessage("Semua data sudah benar?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Long timestamp = System.currentTimeMillis();
                                String timeStampString = timestamp.toString();
                                Calendar cal = Calendar.getInstance();
                                cal.setTimeInMillis(timestamp);

                                tanggal = DateFormat.format("dd MMMM yyyy", cal).toString();
                                judul = judulET.getEditText().getText().toString();
                                isi = isiET.getEditText().getText().toString();

                                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                DatabaseReference databaseReference = firebaseDatabase.getReference("pengumuman");
                                PengumumanHelperClass pengumumanTambahHelperClass = new PengumumanHelperClass(timeStampString, judul, tanggal, isi);
                                databaseReference.child(timeStampString).setValue(pengumumanTambahHelperClass);

                                startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
                                Toast.makeText(getApplicationContext(), "Pengumuman berhasil ditambahkan!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                AlertDialog alert = builder.create();
                alert.show();

//                AlertDialog alertDialog = builder.create();
//                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                alertDialog.show();
            }
        });

    }
}