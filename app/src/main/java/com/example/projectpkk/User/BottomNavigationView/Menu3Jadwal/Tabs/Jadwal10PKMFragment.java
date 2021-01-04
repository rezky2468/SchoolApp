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

public class Jadwal10PKMFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_jadwal10_p_k_m, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.rv_jadwal_10_p_k_m);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));

        final ArrayList<JadwalHelperClass> arrayList = new ArrayList<>();
        arrayList.add(new JadwalHelperClass("Senin", "PAI", "", "", "", "10:00 - 11:00", "", "", ""));
        arrayList.add(new JadwalHelperClass("Selasa", "SENI", "AKUNDAS", "", "", "08:00 - 09:00", "10:00 - 11:00", "", ""));
        arrayList.add(new JadwalHelperClass("Rabu", "EBISNIS", "AU", "EPROF", "SEJARAH", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00"));
        arrayList.add(new JadwalHelperClass("Kamis", "PKN", "B.INDONESIA", "BANKDAS", "SISKOMDIG", "07:00 - 08:00", "08:00 - 09:00", "09:00 - 10:00", "10:00 - 11:00"));
        arrayList.add(new JadwalHelperClass("Jumat", "MTK", "B.SUNDA", "IPA", "", "07:00 - 08:00", "09:00 - 10:00", "10:00 - 11:00", ""));
        arrayList.add(new JadwalHelperClass("Sabtu", "SPREADSHEET", "B.INGGRIS", "", "", "07:00 - 08:00", "10:00 - 11:00", "", ""));

        JadwalRVAdapter adapter = new JadwalRVAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        return root;
    }
}
