package com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalRecyclerViewAdapter.JadwalHelperClass;
import com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalRecyclerViewAdapter.JadwalRVAdapter;
import com.example.projectpkk.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Jadwal11TKJFragment extends Fragment {

    RecyclerView recyclerView;
    String hari, mapel1, mapel2, mapel3, jam1, jam2, jam3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_jadwal11_t_k_j, container, false);

        recyclerView = root.findViewById(R.id.rv_jadwal_11_tkj);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        Query query = FirebaseDatabase.getInstance().getReference("jadwal-pelajaran").child("11-tkj");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                final ArrayList<JadwalHelperClass> arrayList = new ArrayList<>();

                for (DataSnapshot data : dataSnapshot.getChildren()) {

                    hari = data.child("hari").getValue(String.class);
                    mapel1 = data.child("mapel-1").getValue(String.class);
                    mapel2 = data.child("mapel-2").getValue(String.class);
                    mapel3 = data.child("mapel-3").getValue(String.class);
                    jam1 = data.child("jam-1").getValue(String.class);
                    jam2 = data.child("jam-2").getValue(String.class);
                    jam3 = data.child("jam-3").getValue(String.class);

                    arrayList.add(new JadwalHelperClass(hari, mapel1, mapel2, mapel3, jam1, jam2, jam3));

                }

                JadwalRVAdapter adapter = new JadwalRVAdapter(arrayList);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return root;
    }
}