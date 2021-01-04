package com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalRecyclerViewAdapter.JadwalHelperClass;
import com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalRecyclerViewAdapter.JadwalRVAdapter;
import com.example.projectpkk.R;

import java.util.ArrayList;

public class Jadwal10TKJFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_jadwal10_t_k_j, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.rv_10_tkj1);
        RecyclerView recyclerView2 = root.findViewById(R.id.rv_10_tkj2);
        RecyclerView recyclerView3 = root.findViewById(R.id.rv_10_tkj3);

        recyclerView.setHasFixedSize(true);
        recyclerView2.setHasFixedSize(true);
        recyclerView3.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView3.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        final ArrayList<JadwalHelperClass> arrayList = new ArrayList<>();
        arrayList.add(new JadwalHelperClass("Senin", "PAI", "", "", "", "10:00 - 11:00", "", "", ""));
        arrayList.add(new JadwalHelperClass("Selasa", "SENI", "PENJASKES", "", "", "08:00 - 09:00", "09:00 - 10:00", "", ""));
        arrayList.add(new JadwalHelperClass("Rabu", "KOMJARDAS", "SEJARAH", "", "", "09:00 - 10:00", "10:00 - 11:00", "", ""));
        arrayList.add(new JadwalHelperClass("Kamis", "PKN", "B.INDONESIA", "DDG", "SISKOMDIG", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00 ","10:00 - 11:00"));
        arrayList.add(new JadwalHelperClass("Jumat", "MTK", "FISIKA", "B.SUNDA", "", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", ""));
        arrayList.add(new JadwalHelperClass("Sabtu", "PEMDAS", "KIMIA", "SISKOM", "B.INGGRIS", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", ""));


        final ArrayList<JadwalHelperClass> arrayList2 = new ArrayList<>();
        arrayList2.add(new JadwalHelperClass("Senin", "PAI", "", "", "", "10:00 - 11:00", "", "", ""));
        arrayList2.add(new JadwalHelperClass("Selasa", "SENI", "PENJASKES", "", "", "08:00 - 09:00", "09:00 - 10:00", "", ""));
        arrayList2.add(new JadwalHelperClass("Rabu", "KOMJARDAS", "SEJARAH", "", "", "09:00 - 10:00", "10:00 - 11:00", "", ""));
        arrayList2.add(new JadwalHelperClass("Kamis", "PKN", "B.INDONESIA", "DDG", "SISKOMDIG", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00 ","10:00 - 11:00"));
        arrayList2.add(new JadwalHelperClass("Jumat", "MTK", "FISIKA", "B.SUNDA", "", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", ""));
        arrayList2.add(new JadwalHelperClass("Sabtu", "PEMDAS", "KIMIA", "SISKOM", "B.INGGRIS", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", ""));


        final ArrayList<JadwalHelperClass> arrayList3 = new ArrayList<>();
        arrayList3.add(new JadwalHelperClass("Senin", "PAI", "", "", "", "10:00 - 11:00", "", "", ""));
        arrayList3.add(new JadwalHelperClass("Selasa", "SENI", "PENJASKES", "", "", "08:00 - 09:00", "09:00 - 10:00", "", ""));
        arrayList3.add(new JadwalHelperClass("Rabu", "KOMJARDAS", "SEJARAH", "", "", "09:00 - 10:00", "10:00 - 11:00", "", ""));
        arrayList3.add(new JadwalHelperClass("Kamis", "PKN", "B.INDONESIA", "DDG", "SISKOMDIG", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00 ","10:00 - 11:00"));
        arrayList3.add(new JadwalHelperClass("Jumat", "MTK", "FISIKA", "B.SUNDA", "", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", ""));
        arrayList3.add(new JadwalHelperClass("Sabtu", "PEMDAS", "KIMIA", "SISKOM", "B.INGGRIS", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", ""));


        JadwalRVAdapter adapter1 = new JadwalRVAdapter(arrayList);
        JadwalRVAdapter adapter2 = new JadwalRVAdapter(arrayList2);
        JadwalRVAdapter adapter3 = new JadwalRVAdapter(arrayList3);

        recyclerView.setAdapter(adapter1);
        recyclerView2.setAdapter(adapter2);
        recyclerView3.setAdapter(adapter3);

        return root;
    }
}
