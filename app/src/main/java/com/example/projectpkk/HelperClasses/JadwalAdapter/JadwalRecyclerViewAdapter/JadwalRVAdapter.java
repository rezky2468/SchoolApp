package com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalRecyclerViewAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpkk.R;

import java.util.ArrayList;

public class JadwalRVAdapter extends RecyclerView.Adapter<JadwalRVAdapter.JadwalViewHolder> {

    ArrayList<JadwalHelperClass> arrayList;

    public JadwalRVAdapter(ArrayList<JadwalHelperClass> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public JadwalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_jadwal_hari, parent, false);
        JadwalViewHolder jadwalViewHolder = new JadwalViewHolder(view);
        return jadwalViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalViewHolder holder, int position) {
        final JadwalHelperClass jadwalHelperClass = arrayList.get(position);
        holder.hari.setText(jadwalHelperClass.getHari());
        holder.jadwal1.setText(jadwalHelperClass.getJadwal1());
        holder.jadwal2.setText(jadwalHelperClass.getJadwal2());
        holder.jadwal3.setText(jadwalHelperClass.getJadwal3());
        holder.jam1.setText(jadwalHelperClass.getJam1());
        holder.jam2.setText(jadwalHelperClass.getJam2());
        holder.jam3.setText(jadwalHelperClass.getJam3());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class JadwalViewHolder extends RecyclerView.ViewHolder {

        TextView hari, jadwal1, jadwal2, jadwal3, jadwal4, jam1, jam2, jam3, jam4;

        public JadwalViewHolder(@NonNull View itemView) {

            super(itemView);

            // Hooks
            hari = itemView.findViewById(R.id.jadwal_hari);
            jadwal1 = itemView.findViewById(R.id.jadwal_mapel1);
            jadwal2 = itemView.findViewById(R.id.jadwal_mapel2);
            jadwal3 = itemView.findViewById(R.id.jadwal_mapel3);
            jam1 = itemView.findViewById(R.id.jadwal_jam1);
            jam2 = itemView.findViewById(R.id.jadwal_jam2);
            jam3 = itemView.findViewById(R.id.jadwal_jam3);

        }
    }

}
