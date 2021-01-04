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

import com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalRecyclerViewAdapter.JadwalRVAdapter;
import com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalRecyclerViewAdapter.JadwalHelperClass;
import com.example.projectpkk.R;

import java.util.ArrayList;

public class Jadwal10RPLFragment extends Fragment {

    RecyclerView recyclerView;
    JadwalRVAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_jadwal10_r_p_l, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.rv_jadwal_10_r_p_l);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        final ArrayList<JadwalHelperClass> arrayList = new ArrayList<>();
        arrayList.add(new JadwalHelperClass("Senin", "PAI", "", "", "", "10:00 - 11:00", "", "", ""));
        arrayList.add(new JadwalHelperClass("Selasa", "SENI", "PENJASKES", "", "", "08:00 - 09:00", "09:00 - 10:00", "", ""));
        arrayList.add(new JadwalHelperClass("Rabu", "KOMJARDAS", "SEJARAH", "", "", "09:00 - 10:00", "10:00 - 11:00", "", ""));
        arrayList.add(new JadwalHelperClass("Kamis", "PKN", "B.INDONESIA", "DDG", "SISKOMDIG", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00"));
        arrayList.add(new JadwalHelperClass("Jumat", "MTK", "FISIKA", "B.SUNDA", "", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", ""));
        arrayList.add(new JadwalHelperClass("Sabtu", "PEMDAS", "KIMIA", "SISKOM", "", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", ""));


        JadwalRVAdapter adapter = new JadwalRVAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        return root;
    }


}
