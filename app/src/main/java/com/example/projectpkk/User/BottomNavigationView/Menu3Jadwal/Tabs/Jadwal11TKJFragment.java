package com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalRecyclerViewAdapter.JadwalHelperClass;
import com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalRecyclerViewAdapter.JadwalRVAdapter;
import com.example.projectpkk.R;

import java.util.ArrayList;

public class Jadwal11TKJFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_jadwal11_t_k_j, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.rv_jadwal_11_tkj);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        final ArrayList<JadwalHelperClass> arrayList = new ArrayList<>();
        arrayList.add(new JadwalHelperClass(getString(R.string.senin), getString(R.string.pai), getString(R.string.asj), "", getString(R.string.jam_ke1), getString(R.string.jam_ke2), ""));
        arrayList.add(new JadwalHelperClass(getString(R.string.selasa), getString(R.string.b_indonesia), getString(R.string.b_jepang), getString(R.string.bk), getString(R.string.jam_ke1), getString(R.string.jam_ke2), getString(R.string.jam_ke3)));
        arrayList.add(new JadwalHelperClass(getString(R.string.rabu), getString(R.string.pkn), getString(R.string.aij), "", getString(R.string.jam_ke1), getString(R.string.jam_ke2), ""));
        arrayList.add(new JadwalHelperClass(getString(R.string.kamis), getString(R.string.matematika), getString(R.string.pjok), "", getString(R.string.jam_ke1), getString(R.string.jam_ke2), ""));
        arrayList.add(new JadwalHelperClass(getString(R.string.jumat), getString(R.string.b_inggris), getString(R.string.wan), "", getString(R.string.jam_ke1), getString(R.string.jam_ke2), ""));
        arrayList.add(new JadwalHelperClass(getString(R.string.sabtu), getString(R.string.tlj), getString(R.string.pkk),"", getString(R.string.jam_ke1), getString(R.string.jam_ke2), ""));

        JadwalRVAdapter adapter = new JadwalRVAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        return root;
    }
}