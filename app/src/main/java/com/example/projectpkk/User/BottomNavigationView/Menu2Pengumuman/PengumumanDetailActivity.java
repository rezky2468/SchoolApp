package com.example.projectpkk.User.BottomNavigationView.Menu2Pengumuman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectpkk.HelperClasses.PengumumanAdapter.PengumumanHelperClass;
import com.example.projectpkk.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class PengumumanDetailActivity extends AppCompatActivity {

    // Variables
    TextView pengumumanDetailTitle, pengumumanDetailDate, pengumumanDetailDesc;
    ImageView share;
    int index;

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

//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//        Query query = FirebaseDatabase.getInstance().getReference("pengumuman");
//        query.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                int index = getIntent().getIntExtra("com.example.projectpkk.ITEM_INDEX", -1);
//                final String judul = dataSnapshot.child(String.valueOf(index)).child("judul").getValue(String.class);
//                final String tanggal = dataSnapshot.child(String.valueOf(index)).child("tanggal").getValue(String.class);
//                final String isi = dataSnapshot.child(String.valueOf(index)).child("isi").getValue(String.class);
//
//                if (index > -1) {
//                    pengumumanDetailTitle.setText(judul);
//                    pengumumanDetailDate.setText(tanggal);
//                    pengumumanDetailDesc.setText(isi);
//                }
//
//                share.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(Intent.ACTION_SEND);
//                        intent.setType("text/plain");
//                        String shareSubject = judul;
//                        String shareBody = tanggal + " - " + isi;
//                        intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
//                        intent.putExtra(Intent.EXTRA_TEXT, shareBody);
//                        startActivity(Intent.createChooser(intent, "Bagikan pengumuman dengan"));
//                    }
//                });
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        index = getIntent().getIntExtra("com.example.projectpkk.ITEM_INDEX", -1);

        Query query = FirebaseDatabase.getInstance().getReference("pengumuman");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot detail : dataSnapshot.getChildren()) {

                    final String judul = detail.child("judul").getValue(String.class);
                    final String tanggal = detail.child("tanggal").getValue(String.class);
                    final String isi = detail.child("isi").getValue(String.class);

                    if (index > -1) {
                        pengumumanDetailTitle.setText(judul);
                        pengumumanDetailDate.setText(tanggal);
                        pengumumanDetailDesc.setText(isi);
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        try {
//            JSONObject jsonObject = new JSONObject(loadPengumumanJSONFromAsset());
//            JSONArray jsonArray = jsonObject.getJSONArray("pengumuman");
//            JSONObject _jsonObject = jsonArray.getJSONObject(index);
//
//            final String judulValue = _jsonObject.getString("judul");
//            final String tanggalValue = _jsonObject.getString("tanggal");
//            final String isiValue = _jsonObject.getString("isi");
//
//            Bundle bundle = new Bundle();
//            bundle.putString("judul", judulValue);
//            bundle.putString("tanggal", tanggalValue);
//            bundle.putString("isi", isiValue);
//
//            if (index > -1) {
//                pengumumanDetailTitle.setText(judulValue);
//                pengumumanDetailDate.setText(tanggalValue);
//                pengumumanDetailDesc.setText(isiValue);
//            }
//
//            share.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(Intent.ACTION_SEND);
//                    intent.setType("text/plain");
//                    String shareSubject = judulValue;
//                    String shareBody = tanggalValue + " - " + isiValue;
//                    intent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
//                    intent.putExtra(Intent.EXTRA_TEXT, shareBody);
//                    startActivity(Intent.createChooser(intent, "Bagikan pengumuman dengan"));
//                }
//            });
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }

    public String loadPengumumanJSONFromAsset() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("pengumuman.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

}