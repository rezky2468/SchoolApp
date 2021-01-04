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

public class Jadwal12PKMFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jadwal12_p_k_m, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.rv_12_pkm1);
        RecyclerView recyclerView2 = view.findViewById(R.id.rv_12_pkm2);

        recyclerView.setHasFixedSize(true);
        recyclerView2.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        final ArrayList<JadwalHelperClass> arrayList = new ArrayList<>();
        arrayList.add(new JadwalHelperClass("Senin", "B. Indonesia", "", "", "", "09:00 - 10:00", "", "", ""));
        arrayList.add(new JadwalHelperClass("Selasa", "B. Jepang", "APKM", "", "", "08:00 - 09:00", "09:00 - 10:00", "", ""));
        arrayList.add(new JadwalHelperClass("Rabu", "PKN", "PKK", "B. Inggris", "BK", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00"));
        arrayList.add(new JadwalHelperClass("Kamis", "LLPKM", "Matematika", "PAI", "", "07:00 - 08:00", "08:00 - 09:00", "10:00 - 11:00", ""));
        arrayList.add(new JadwalHelperClass("Jumat", "", "", "", "", "", "", "", ""));
        arrayList.add(new JadwalHelperClass("Sabtu", "Kompak", "", "", "", "09:00 - 10:00", "", "", ""));

        final ArrayList<JadwalHelperClass> arrayList2 = new ArrayList<>();
        arrayList2.add(new JadwalHelperClass("Senin", "Matematika", "B. Indonesia", "", "", "08:00 - 09:00","09:00 - 10:00", "", ""));
        arrayList2.add(new JadwalHelperClass("Selasa", "B. Jepang", "APKM", "", "", "08:00 - 09:00", "09:00 - 10:00", "", ""));
        arrayList2.add(new JadwalHelperClass("Rabu", "PKN", "PKK", "B. Inggris", "BK", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00"));
        arrayList2.add(new JadwalHelperClass("Kamis", "PAI", "", "", "","10:00 - 11:00", "", "", ""));
        arrayList2.add(new JadwalHelperClass("Jumat", "LLPKM", "", "", "", "08:00 - 09:00", "", "", ""));
        arrayList2.add(new JadwalHelperClass("Sabtu", "Kompak", "", "", "", "09:00 - 10:00", "", "", ""));

        JadwalRVAdapter adapter1 = new JadwalRVAdapter(arrayList);
        JadwalRVAdapter adapter2 = new JadwalRVAdapter(arrayList2);

        recyclerView.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter2);

        return view;
    }
}