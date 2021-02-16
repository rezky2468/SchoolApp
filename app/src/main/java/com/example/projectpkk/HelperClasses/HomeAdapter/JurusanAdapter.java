package com.example.projectpkk.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpkk.R;

import java.util.ArrayList;

public class JurusanAdapter extends RecyclerView.Adapter<JurusanAdapter.FeaturedViewHolder> {

    ArrayList<JurusanHelperClass> featuredLocations;
    private OnJurusanListener mOnJurusanListener;

    public JurusanAdapter(ArrayList<JurusanHelperClass> featuredLocations, OnJurusanListener onNoteListener) {
        this.featuredLocations = featuredLocations;
        this.mOnJurusanListener = onNoteListener;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_jurusan_card_design, parent, false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view, mOnJurusanListener);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        final JurusanHelperClass jurusanHelperClass = featuredLocations.get(position);
        holder.image.setImageResource(jurusanHelperClass.getImage());
        holder.icon.setImageResource(jurusanHelperClass.getIcon());
        holder.title.setText(jurusanHelperClass.getTitle());
        holder.desc.setText(jurusanHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return featuredLocations.size();
    }

    public interface OnJurusanListener {
        void onJurusanClick(int position);
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        com.makeramen.roundedimageview.RoundedImageView image;
        ImageView icon;
        TextView title, desc;
        OnJurusanListener onJurusanListener;

        public FeaturedViewHolder(@NonNull View itemView, OnJurusanListener onJurusanListener) {
            super(itemView);

            // Hooks
            image = itemView.findViewById(R.id.featured_image);
            icon = itemView.findViewById(R.id.featured_icon);
            title = itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.featured_desc);

            this.onJurusanListener = onJurusanListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onJurusanListener.onJurusanClick(getAdapterPosition());
        }
    }
}
