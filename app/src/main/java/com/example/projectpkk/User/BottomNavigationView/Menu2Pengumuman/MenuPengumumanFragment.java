package com.example.projectpkk.User.BottomNavigationView.Menu2Pengumuman;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projectpkk.Admin.AddNewPengumumanActivity;
import com.example.projectpkk.HelperClasses.PengumumanAdapter.PengumumanHelperClass;
import com.example.projectpkk.HelperClasses.PengumumanAdapter.PengumumanAdapter;
import com.example.projectpkk.HelperClasses.PengumumanDetailHelperClass;
import com.example.projectpkk.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;

public class MenuPengumumanFragment extends Fragment {

    // Variables
    ListView pengumumanListView;
    ArrayList<PengumumanHelperClass> arrayList;
//    ArrayList<PengumumanDetailHelperClass> detailHelperClasses;
    String judul, isi, tanggal1, tanggal2;
    SwipeRefreshLayout swipeRefreshLayout;
    PengumumanAdapter pengumumanAdapter;
    Long timestamp;
    String ts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_pengumuman, container, false);
        pengumumanListView = view.findViewById(R.id.pengumuman_list_view);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_pengumuman);
        arrayList = new ArrayList<>();

        timestamp = System.currentTimeMillis();
        ts = timestamp.toString();



//        Date c = Calendar.getInstance().getTime();
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss");
//        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd MMMM yyyy");
//        String format1 = simpleDateFormat1.format(c);
//        String format2 = simpleDateFormat2.format(c);
//
//        judul = "judul";
//        isi = "isi2";
//        tanggal1 = format1;
//        tanggal2 = format2;

        pengumumanAdapter = new PengumumanAdapter(getContext(), arrayList);


        Query query = FirebaseDatabase.getInstance().getReference("pengumuman");



        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot timestamp : dataSnapshot.getChildren()) {
                    PengumumanHelperClass pengumumanHelperClass = new PengumumanHelperClass();
                    String judul = timestamp.child("judul").getValue(String.class);
                    String tanggal = timestamp.child("tanggal").getValue(String.class);
                    String isi = timestamp.child("isi").getValue(String.class);

                    pengumumanHelperClass.setJudul(judul);
                    pengumumanHelperClass.setTanggal(tanggal);
                    pengumumanHelperClass.setIsi(isi);
////                    arrayList.add(0, pengumumanHelperClass);
                    arrayList.add(pengumumanHelperClass);


////                    PengumumanDetailHelperClass pengumumanDetailHelperClass = new PengumumanDetailHelperClass();
////                    pengumumanDetailHelperClass.setIndex(i);
////                    pengumumanDetailHelperClass.setTitle(judul);
////                    pengumumanDetailHelperClass.setDate(tanggal);
////                    pengumumanDetailHelperClass.setDescription(isi);
////                    detailHelperClasses.add(pengumumanDetailHelperClass);

                }

//                for (int i = 0; i < dataSnapshot.getChildrenCount(); i++) {
//                    PengumumanHelperClass pengumumanHelperClass = new PengumumanHelperClass();
//                    String judul = dataSnapshot.child(String.valueOf(i)).child("judul").getValue(String.class);
//                    String tanggal = dataSnapshot.child(String.valueOf(i)).child("tanggal").getValue(String.class);
//                    String isi = dataSnapshot.child(String.valueOf(i)).child("isi").getValue(String.class);
//
//                    pengumumanHelperClass.setJudul(judul);
//                    pengumumanHelperClass.setTanggal(tanggal);
//                    pengumumanHelperClass.setIsi(isi);
////                    arrayList.add(0, pengumumanHelperClass);
//                    arrayList.add(pengumumanHelperClass);
//
//
////                    PengumumanDetailHelperClass pengumumanDetailHelperClass = new PengumumanDetailHelperClass();
////                    pengumumanDetailHelperClass.setIndex(i);
////                    pengumumanDetailHelperClass.setTitle(judul);
////                    pengumumanDetailHelperClass.setDate(tanggal);
////                    pengumumanDetailHelperClass.setDescription(isi);
////                    detailHelperClasses.add(pengumumanDetailHelperClass);
//                }
                pengumumanAdapter.notifyDataSetChanged();
                pengumumanListView.setAdapter(pengumumanAdapter);

                pengumumanListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(getContext(), PengumumanDetailActivity.class);
                        intent.putExtra("com.example.projectpkk.ITEM_INDEX", position);
                        startActivity(intent);

                    }
                });

                pengumumanListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                        new AlertDialog.Builder(getActivity(), R.style.AlertDialog)                   // we can't use getApplicationContext() here as we want the activity to be the context, not the application
                                .setMessage("Yakin ingin menghapus pengumuman ini?")
                                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)                        // to remove the selected note once "Yes" is pressed
                                    {
//                                        notes.remove(position);
//                                        listViewAdapter.notifyDataSetChanged();

//                                        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.example.noteapp", Context.MODE_PRIVATE);
//                                        HashSet<String> set = new HashSet<>(MainActivity.notes);
//                                        sharedPreferences.edit().putStringSet("notes", set).apply();
                                    }
                                })

                                .setNegativeButton("Tidak", null)
                                .show();

                        return true;
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                pengumumanAdapter.notifyDataSetChanged();
//                pengumumanListView.setAdapter(pengumumanAdapter);
//                Toast.makeText(getActivity(), ts, Toast.LENGTH_SHORT).show();
                Long jam = System.currentTimeMillis();
                String jam2 = jam.toString();

                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(jam);
                String date = DateFormat.format("dd MMMM yyyy", cal).toString();

                Toast.makeText(getActivity(), date, Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        ImageView imageView = view.findViewById(R.id.tambah_pengumuman);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), AddNewPengumumanActivity.class));
            }
        });



//        try {
//            JSONObject jsonObject = new JSONObject(readPengumumanJSON());
//            JSONArray jsonArray = jsonObject.getJSONArray("pengumuman");
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject _jsonObject = jsonArray.getJSONObject(i);
//
//                final String judulValue = _jsonObject.getString("judul");
//                final String tanggalValue = _jsonObject.getString("tanggal");
//                final String isiValue = _jsonObject.getString("isi");
//
//                PengumumanHelperClass pengumumanHelperClass = new PengumumanHelperClass();
//                pengumumanHelperClass.setJudul(judulValue);
//                pengumumanHelperClass.setTanggal(tanggalValue);
//                pengumumanHelperClass.setIsi(isiValue);
//                arrayList.add(0, pengumumanHelperClass);
//                pengumumanAdapter.notifyDataSetChanged();
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        pengumumanListView.post(new Runnable() {
            @Override
            public void run() {
                pengumumanListView.smoothScrollToPosition(0);
            }
        });

//        pengumumanListView.setAdapter(pengumumanAdapter);


        return view;
    }

    public void updateData() {

    }


    public String readPengumumanJSON() {
        String json = null;
        try {
            InputStream inputStream = getActivity().getAssets().open("pengumuman.json");
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