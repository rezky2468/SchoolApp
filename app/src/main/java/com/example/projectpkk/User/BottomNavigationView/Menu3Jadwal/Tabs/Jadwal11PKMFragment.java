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

public class Jadwal11PKMFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jadwal11_p_k_m, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_jadwal_11_pkm);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        final ArrayList<JadwalHelperClass> arrayList = new ArrayList<>();
        arrayList.add(new JadwalHelperClass("Senin", "B.JEPANG", "B.INGGRIS", "", "", "07.00 - 08.00", "10.00 - 11.00", "", ""));
        arrayList.add(new JadwalHelperClass("Selasa", "PAI", "", "", "", "08.00 - 09.00", "", "", ""));
        arrayList.add(new JadwalHelperClass("Rabu", "KOMPAK", "PKAS", "APKM", "PENJASKES", "07.00 - 08.00", "08.00 - 09.00", "09.00 - 10.00", "10.00-11.00"));
        arrayList.add(new JadwalHelperClass("Kamis", "AP", "PKK", "BK", "PKN", "07.00 - 08.000", "08.00 - 09.00", "09.00 - 10.00", "10.00 - 11.00"));
        arrayList.add(new JadwalHelperClass("Jumat", "B.INDO", "MTK", "", "", "08.00 - 09.00", "10.00 - 11.00", "", ""));
        arrayList.add(new JadwalHelperClass("Sabtu", "LLPKM", "mapel2", "", "", "10.00 - 11.00", "", "", ""));

        JadwalRVAdapter adapter = new JadwalRVAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}