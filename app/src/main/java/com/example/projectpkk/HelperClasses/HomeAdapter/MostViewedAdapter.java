package com.example.projectpkk.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpkk.R;

import java.util.ArrayList;

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewedViewHolder> {

    ArrayList<MostViewedHelperClass> mostViewedLocations;
    private OnBeritaListener mOnberitaListener;

    public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostViewedLocations, OnBeritaListener onBeritaListener) {
        this.mostViewedLocations = mostViewedLocations;
        this.mOnberitaListener = onBeritaListener;
    }

    @NonNull
    @Override
    public MostViewedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_berita_card_design, parent, false);
        MostViewedViewHolder mostViewedViewHolder = new MostViewedViewHolder(view, mOnberitaListener);
        return mostViewedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MostViewedViewHolder holder, int position) {
        MostViewedHelperClass mostViewedHelperClass = mostViewedLocations.get(position);
        holder.image.setImageResource(mostViewedHelperClass.getImage());
        holder.title.setText(mostViewedHelperClass.getTitle());
        holder.desc.setText(mostViewedHelperClass.getDesc());


    }

    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public static class MostViewedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        com.makeramen.roundedimageview.RoundedImageView image;
        TextView title, desc;
        OnBeritaListener onBeritaListener;

        public MostViewedViewHolder(@NonNull View itemView, OnBeritaListener onBeritaListener) {

            super(itemView);

            // Hooks
            image = itemView.findViewById(R.id.mv_image);
            title = itemView.findViewById(R.id.mv_title);
            desc = itemView.findViewById(R.id.mv_desc);

            this.onBeritaListener = onBeritaListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onBeritaListener.onBeritaClick(getAdapterPosition());
        }
    }

    public interface OnBeritaListener {
        void onBeritaClick(int position);
    }

}
