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

        RecyclerView recyclerView = root.findViewById(R.id.rv_jadwal_10_tkj);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));

        final ArrayList<JadwalHelperClass> arrayList = new ArrayList<>();
        arrayList.add(new JadwalHelperClass(getString(R.string.senin), getString(R.string.pai), getString(R.string.simkomdig), getString(R.string.fisika), getString(R.string.jam_ke1), getString(R.string.jam_ke2), getString(R.string.jam_ke3)));
        arrayList.add(new JadwalHelperClass(getString(R.string.selasa), getString(R.string.b_indonesia), getString(R.string.desain_grafis), getString(R.string.jardas), getString(R.string.jam_ke1), getString(R.string.jam_ke2), getString(R.string.jam_ke3)));
        arrayList.add(new JadwalHelperClass(getString(R.string.rabu), getString(R.string.pkn), getString(R.string.sejarah), getString(R.string.bk), getString(R.string.jam_ke1), getString(R.string.jam_ke2), getString(R.string.jam_ke3)));
        arrayList.add(new JadwalHelperClass(getString(R.string.kamis), getString(R.string.matematika), getString(R.string.pjok), getString(R.string.kimia), getString(R.string.jam_ke1), getString(R.string.jam_ke2), getString(R.string.jam_ke3)));
        arrayList.add(new JadwalHelperClass(getString(R.string.jumat), getString(R.string.b_inggris), getString(R.string.b_sunda), getString(R.string.siskom), getString(R.string.jam_ke1), getString(R.string.jam_ke2), getString(R.string.jam_ke3)));
        arrayList.add(new JadwalHelperClass(getString(R.string.sabtu), getString(R.string.seni), getString(R.string.pemdas), "",getString(R.string.jam_ke1), getString(R.string.jam_ke2), ""));

        JadwalRVAdapter adapter = new JadwalRVAdapter(arrayList);
        recyclerView.setAdapter(adapter);

        return root;
    }
}
