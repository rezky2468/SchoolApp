package com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories1Guru;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.projectpkk.HelperClasses.GuruAdapter.GuruAdapter;
import com.example.projectpkk.HelperClasses.GuruAdapter.GuruHelperClass;
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
import java.util.ArrayList;

public class GuruActivity extends AppCompatActivity {

    ListView listView;
    SwipeRefreshLayout swipeRefreshLayout;
    ArrayList<GuruHelperClass> arrayList;
    GuruAdapter guruAdapter;
    String nama, jabatan, ttl, pendidikan, mapel, email, telp;

    int[] fotos = {
            R.drawable.guru_anton,
            R.drawable.guru_asep_d_y,
            R.drawable.guru_wahyu,
            R.drawable.guru_teli,
            R.drawable.guru_sigid,
            R.drawable.guru_indra,
            R.drawable.guru_devi,
            R.drawable.guru_abin,
            R.drawable.guru_iis,
            R.drawable.guru_asep_y,
            R.drawable.guru_egi,
            R.drawable.no_photo,
            R.drawable.guru_mega,
            R.drawable.guru_nurwita,
            R.drawable.no_photo,
            R.drawable.guru_rina,
            R.drawable.guru_wahyudi,
            R.drawable.guru_liku,
            R.drawable.guru_indira,
            R.drawable.guru_fitria,
            R.drawable.no_photo,
            R.drawable.guru_pravita,
            R.drawable.guru_eka,
            R.drawable.guru_irma,
            R.drawable.guru_rini,
            R.drawable.guru_isma,
            R.drawable.guru_ai,
            R.drawable.guru_yogie,
            R.drawable.guru_odih,
            R.drawable.guru_fajar,
            R.drawable.guru_nirwan,
            R.drawable.guru_neni,
            R.drawable.guru_kiki,
            R.drawable.guru_lisda,
            R.drawable.guru_hani,
            R.drawable.guru_m_sobar,
            R.drawable.guru_sinta,
            R.drawable.guru_andiyanto,
            R.drawable.guru_guruh,
            R.drawable.guru_handi,
            R.drawable.guru_uman
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_categories_guru);

        listView = findViewById(R.id.pengajar_list_view);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh_guru);
        arrayList = new ArrayList<>();
        guruAdapter = new GuruAdapter(this, arrayList);

        Query query = FirebaseDatabase.getInstance().getReference("guru");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
                    GuruHelperClass guruHelperClass = new GuruHelperClass();
                    String nama = dataSnapshot.child(String.valueOf(i)).child("nama").getValue(String.class);
                    String mapel = dataSnapshot.child(String.valueOf(i)).child("mapel").getValue(String.class);
                    guruHelperClass.setNama(nama);
                    guruHelperClass.setMapel(mapel);
                    arrayList.add(guruHelperClass);
                }
                guruAdapter.notifyDataSetChanged();
                listView.setAdapter(guruAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                guruAdapter.notifyDataSetChanged();
                listView.setAdapter(guruAdapter);
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                Query _query = FirebaseDatabase.getInstance().getReference("guru");
                _query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                        for (int i = position; i < dataSnapshot.getChildrenCount(); i++) {
                        String _nama = dataSnapshot.child(String.valueOf(position)).child("nama").getValue(String.class);
                        String _jabatan = dataSnapshot.child(String.valueOf(position)).child("jabatan").getValue(String.class);
                        String _ttl = dataSnapshot.child(String.valueOf(position)).child("ttl").getValue(String.class);
                        String _pendidikan = dataSnapshot.child(String.valueOf(position)).child("pendidikan").getValue(String.class);
                        String _mapel = dataSnapshot.child(String.valueOf(position)).child("mapel").getValue(String.class);
                        String _email = dataSnapshot.child(String.valueOf(position)).child("email").getValue(String.class);
                        String _telp = dataSnapshot.child(String.valueOf(position)).child("telp").getValue(String.class);

                        Bundle bundle = new Bundle();
                        bundle.putInt("dataId", position);
                        bundle.putString("dataNama", _nama);
                        bundle.putString("dataJabatan", _jabatan);
                        bundle.putString("dataTtl", _ttl);
                        bundle.putString("dataPendidikan", _pendidikan);
                        bundle.putString("dataMapel", _mapel);
                        bundle.putString("dataEmail", _email);
                        bundle.putString("dataTelp", _telp);
                        bundle.putInt("dataFoto", fotos[position]);
                        GuruDetailBottomSheet bottomSheetDialog = new GuruDetailBottomSheet();
                        bottomSheetDialog.setArguments(bundle);
                        bottomSheetDialog.show(getSupportFragmentManager(), "exampleBottomSheet");

//                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//        DatabaseReference scoresRef = FirebaseDatabase.getInstance().getReference("guru");
//        scoresRef.keepSynced(true);
//        Query query = scoresRef;
//        Query myGuru = FirebaseDatabase.getInstance().getReference("guru");
//        myGuru.keepSynced(true);

//        myGuru.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot snap: dataSnapshot.getChildren()) {
//                    Toast.makeText(getActivity(), snap.getKey(), Toast.LENGTH_SHORT).show();
//                    Log.e(snap.getKey(),snap.getChildrenCount() + "");

//                    final String namaValue = dataSnapshot.child(snap.getKey()).child("nama").getValue(String.class);
//                    final String jabatanValue = dataSnapshot.child(snap.getKey()).child("jabatan").getValue(String.class);
//                    final String ttlValue = dataSnapshot.child(snap.getKey()).child("ttl").getValue(String.class);
//                    final String pendidikanValue = dataSnapshot.child(snap.getKey()).child("pendidikan").getValue(String.class);
//                    final String mapelValue = dataSnapshot.child(snap.getKey()).child("mapel").getValue(String.class);
//                    final String emailValue = dataSnapshot.child(snap.getKey()).child("email").getValue(String.class);
//                    final String telpValue = dataSnapshot.child(snap.getKey()).child("telp").getValue(String.class);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//


//                try {

//                    JSONObject jsonObject = new JSONObject(readPengajarJSON());
//                    JSONArray jsonArray = jsonObject.getJSONArray("guru");
//                    JSONObject _jsonObject = jsonArray.getJSONObject(position);
//                    final String namaValue = _jsonObject.getString("nama");
//                    final String jabatanValue = _jsonObject.getString("jabatan");
//                    final String ttlValue = _jsonObject.getString("ttl");
//                    final String pendidikanValue = _jsonObject.getString("pendidikan");
//                    final String mapelValue = _jsonObject.getString("mapel");
//                    final String emailValue = _jsonObject.getString("email");
//                    final String telpValue = _jsonObject.getString("telp");
//
//                    Bundle bundle = new Bundle();
//                    bundle.putInt("dataId", position);
//                    bundle.putString("dataNama", namaValue);
//                    bundle.putString("dataJabatan", jabatanValue);
//                    bundle.putString("dataTtl", ttlValue);
//                    bundle.putString("dataPendidikan", pendidikanValue);
//                    bundle.putString("dataMapel", mapelValue);
//                    bundle.putString("dataEmail", emailValue);
//                    bundle.putString("dataTelp", telpValue);
//                    bundle.putInt("dataFoto", fotos[position]);
//                    GuruDetailBottomSheet bottomSheetDialog = new GuruDetailBottomSheet();
//                    bottomSheetDialog.setArguments(bundle);
//                    bottomSheetDialog.show(getSupportFragmentManager(), "exampleBottomSheet");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                        }

//                    });
//                }

//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


//        PengajarAdapter pengajarAdapter = new PengajarAdapter(this);
//        myListView.setAdapter(pengajarAdapter);
//                myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                try {
//
//                    JSONObject jsonObject = new JSONObject(readPengajarJSON());
//                    JSONArray jsonArray = jsonObject.getJSONArray("guru");
//                    JSONObject _jsonObject = jsonArray.getJSONObject(position);
//                    final String namaValue = _jsonObject.getString("nama");
//                    final String jabatanValue = _jsonObject.getString("jabatan");
//                    final String ttlValue = _jsonObject.getString("ttl");
//                    final String pendidikanValue = _jsonObject.getString("pendidikan");
//                    final String mapelValue = _jsonObject.getString("mapel");
//                    final String emailValue = _jsonObject.getString("email");
//                    final String telpValue = _jsonObject.getString("telp");

//                    Bundle bundle = new Bundle();
//                    bundle.putInt("dataId", position);
//                    bundle.putString("dataNama", namaValue);
//                    bundle.putString("dataJabatan", jabatanValue);
//                    bundle.putString("dataTtl", ttlValue);
//                    bundle.putString("dataPendidikan", pendidikanValue);
//                    bundle.putString("dataMapel", mapelValue);
//                    bundle.putString("dataEmail", emailValue);
//                    bundle.putString("dataTelp", telpValue);
//                    bundle.putInt("dataFoto", fotos[position]);
//                    GuruDetailBottomSheet bottomSheetDialog = new GuruDetailBottomSheet();
//                    bottomSheetDialog.setArguments(bundle);
//                    bottomSheetDialog.show(getSupportFragmentManager(), "exampleBottomSheet");
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        });


    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }

    public String readPengajarJSON() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("guru.json");
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