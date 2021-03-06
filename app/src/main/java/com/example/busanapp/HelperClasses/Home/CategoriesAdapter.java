package com.example.busanapp.HelperClasses.Home;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.busanapp.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.AdapterAllCategoriesViewHolder> {
    private ArrayList<CategoriesHelperClass> mostViewedLocations;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> mostViewedLocations) {
        this.mostViewedLocations = mostViewedLocations;
    }

    @NonNull
    @Override
    public AdapterAllCategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        return new AdapterAllCategoriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAllCategoriesViewHolder holder, int position) {
        CategoriesHelperClass helperClass = mostViewedLocations.get(position);

//      holder.imageView.setImageResource(helperClass.getImage());
        Glide.with(holder.itemView.getContext()).load(helperClass.getUrl()).into(holder.imageView);
        holder.textView.setText(helperClass.getTitle());
//      holder.relativeLayout.setBackground(Drawable.createFromPath(helperClass.getGradient()));
    }

    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    static class AdapterAllCategoriesViewHolder extends RecyclerView.ViewHolder {
//      RelativeLayout relativeLayout;
        ImageView imageView;
        TextView textView;

        AdapterAllCategoriesViewHolder(@NonNull View itemView) {
            super(itemView);

//          relativeLayout = itemView.findViewById(R.id.background_gradient);
            imageView = itemView.findViewById(R.id.categories_image);
            textView = itemView.findViewById(R.id.categories_title);
        }
    }
}