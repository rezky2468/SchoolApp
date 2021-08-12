package com.example.projectpkk.User.BottomNavigationView.Menu2Pengumuman;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.projectpkk.Admin.AddNewPengumumanActivity;
import com.example.projectpkk.Databases.SessionManager;
import com.example.projectpkk.HelperClasses.PengumumanAdapter.PengumumanAdapter;
import com.example.projectpkk.HelperClasses.PengumumanAdapter.PengumumanHelperClass;
import com.example.projectpkk.Pengumuman;
import com.example.projectpkk.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuPengumumanFragment extends Fragment {

    // Variables
    ListView pengumumanListView;
    ArrayList<PengumumanHelperClass> arrayList;
//    ArrayList<PengumumanDetailHelperClass> detailHelperClasses;
    String judul, isi, tanggal1, tanggal2;
    SwipeRefreshLayout swipeRefreshLayout;
    PengumumanAdapter pengumumanAdapter;
    Long timestamp;
    ImageView tambahPengumumanIV;
    String ts;
    DatabaseReference databaseReference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_pengumuman, container, false);
        pengumumanListView = view.findViewById(R.id.pengumuman_list_view);
        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_pengumuman);
        tambahPengumumanIV = view.findViewById(R.id.announcement_add_image_view);

        databaseReference = FirebaseDatabase.getInstance().getReference("pengumuman");

        arrayList = new ArrayList<>();

        timestamp = System.currentTimeMillis();
        ts = timestamp.toString();

        pengumumanAdapter = new PengumumanAdapter(getContext(), arrayList);

        pengumumanListView.setAdapter(pengumumanAdapter);

        RetrieveData();

        pengumumanListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                Query _query = FirebaseDatabase.getInstance().getReference("pengumuman");
                _query.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        ArrayList<Pengumuman> arrayList1 = new ArrayList<>();
                        for (DataSnapshot timestamp : dataSnapshot.getChildren()) {
                            Pengumuman pengumuman = new Pengumuman();
                            String judul = timestamp.child("judul").getValue().toString();
                            String tanggal = timestamp.child("tanggal").getValue().toString();
                            String isi = timestamp.child("isi").getValue().toString();

                            pengumuman.setJudul(judul);
                            pengumuman.setTanggal(tanggal);
                            pengumuman.setIsi(isi);
                            arrayList1.add(pengumuman);

                        }

                        Intent intent = new Intent(getContext(), PengumumanDetailActivity.class);
                        intent.putParcelableArrayListExtra("PENGUMUMAN", arrayList1.get(position));
                        intent.putExtra("com.example.projectpkk.ITEM_INDEX", position);
                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        pengumumanListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                new AlertDialog.Builder(getActivity(), R.style.AlertDialog)
                        .setMessage("Yakin ingin menghapus pengumuman ini?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Object deletedData = pengumumanListView.getItemAtPosition(position);
                                PengumumanHelperClass delData = (PengumumanHelperClass) deletedData;
                                DeleteData(delData.getTimestamp());
//                                FirebaseDatabase.getInstance().getReference("pengumuman").child(time).removeValue();
//                                pengumumanAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Tidak", null)
                        .show();
                return true;
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pengumumanAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        SessionManager sessionManager = new SessionManager(getContext());
        if (sessionManager.checkLogin()) {
            HashMap<String, String> hashMap = sessionManager.getUsersDetailFromSession();
            final String level = hashMap.get(SessionManager.KEY_LEVEL);
            if (level.equals("admin") || level.equals("guru")) {
                tambahPengumumanIV.setVisibility(View.VISIBLE);
                tambahPengumumanIV.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getActivity(), AddNewPengumumanActivity.class));
                    }
                });
            }
        }

        pengumumanListView.post(new Runnable() {
            @Override
            public void run() {
                pengumumanListView.smoothScrollToPosition(0);
            }
        });

        return view;
    }

    private void RetrieveData() {

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                if (dataSnapshot.exists()) {
                    DisplayData(dataSnapshot);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                pengumumanAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                String key = dataSnapshot.getKey();
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i).getTimestamp().equals(key)) {
                        arrayList.remove(i);
                        break;
                    }
                }
                pengumumanAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void DisplayData(DataSnapshot dataSnapshot) {
        PengumumanHelperClass pengumumanHelperClass = new PengumumanHelperClass();
        String judul = dataSnapshot.child("judul").getValue(String.class);
        String tanggal = dataSnapshot.child("tanggal").getValue(String.class);
        String isi = dataSnapshot.child("isi").getValue(String.class);
        String times = dataSnapshot.child("timestamp").getValue(String.class);

        pengumumanHelperClass.setJudul(judul);
        pengumumanHelperClass.setTanggal(tanggal);
        pengumumanHelperClass.setIsi(isi);
        pengumumanHelperClass.setTimestamp(times);
////                    arrayList.add(0, pengumumanHelperClass);
        arrayList.add(pengumumanHelperClass);
        pengumumanAdapter.notifyDataSetChanged();
    }

    public void DeleteData(String key) {
        databaseReference.child(key).removeValue();
    }


}