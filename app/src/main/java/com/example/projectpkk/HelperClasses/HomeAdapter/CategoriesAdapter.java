package com.example.projectpkk.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpkk.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    ArrayList<CategoriesHelperClass> categoriesLocations;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categoriesLocations) {
        this.categoriesLocations = categoriesLocations;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_categories_card_design, parent, false);
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(view);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {

        CategoriesHelperClass categoriesHelperClass = categoriesLocations.get(position);

        holder.title.setText(categoriesHelperClass.getTitle());
        holder.image.setImageResource(categoriesHelperClass.getImage());
    }

    @Override
    public int getItemCount() {
        return categoriesLocations.size();
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;
        RelativeLayout background;

        public CategoriesViewHolder(@NonNull View itemView) {

            super(itemView);

            // Hooks
            title = itemView.findViewById(R.id.categories_title);
            image = itemView.findViewById(R.id.categories_image);

        }

    }
}
