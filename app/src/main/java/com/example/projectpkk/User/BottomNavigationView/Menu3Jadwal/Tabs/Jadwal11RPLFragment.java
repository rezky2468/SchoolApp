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

public class Jadwal11RPLFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_jadwal11_r_p_l, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.rv_11_rpl1);
        RecyclerView recyclerView2 = root.findViewById(R.id.rv_11_rpl2);

        recyclerView.setHasFixedSize(true);
        recyclerView2.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        final ArrayList<JadwalHelperClass> arrayList = new ArrayList<>();
        arrayList.add(new JadwalHelperClass("Senin", "B.JEPANG", "B.INGGRIS", "", "", "07:00 - 08:00", "10:00 - 11:00", "", ""));
        arrayList.add(new JadwalHelperClass("Selasa", "WEB", "", "", "", "07:00 - 08:00", "", "", ""));
        arrayList.add(new JadwalHelperClass("Rabu", "PAI", "PENJASKES", "", "", "07:00 - 08:00", "10:00 - 11:00", "", ""));
        arrayList.add(new JadwalHelperClass("Kamis", "BD", "PKK", "BK", "", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", ""));
        arrayList.add(new JadwalHelperClass("Jumat", "B.INDONESIA", "MTK", "", "", "08:00 - 09:00", "10:00 - 11:00", "", ""));
        arrayList.add(new JadwalHelperClass("Sabtu", "PPL", "PBO", "", "", "08:00 - 09:00", "10;00 - 11:00", "", ""));

        final ArrayList<JadwalHelperClass> arrayList2 = new ArrayList<>();
        arrayList2.add(new JadwalHelperClass("Senin", "B.JEPANG", "B.INGGRIS", "", "", "07:00 - 08:00", "10:00 - 11:00", "", ""));
        arrayList2.add(new JadwalHelperClass("Selasa", "WEB", "", "", "", "07:00 - 08:00", "", "", ""));
        arrayList2.add(new JadwalHelperClass("Rabu", "PAI", "PENJASKES", "", "", "07:00 - 08:00", "10:00 - 11:00", "", ""));
        arrayList2.add(new JadwalHelperClass("Kamis", "BD", "PKK", "BK", "", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", ""));
        arrayList2.add(new JadwalHelperClass("Jumat", "B.INDONESIA", "MTK", "", "", "08:00 - 09:00", "10:00 - 11:00", "", ""));
        arrayList2.add(new JadwalHelperClass("Sabtu", "PPL", "PBO", "", "", "08:00 - 09:00", "10;00 - 11:00", "", ""));

        JadwalRVAdapter adapter1 = new JadwalRVAdapter(arrayList);
        JadwalRVAdapter adapter2 = new JadwalRVAdapter(arrayList2);

        recyclerView.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter2);

        return root;
    }
}