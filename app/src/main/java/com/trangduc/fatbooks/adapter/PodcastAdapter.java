package com.trangduc.fatbooks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.trangduc.fatbooks.R;

import com.trangduc.fatbooks.domain.PodcastDomain;

import java.util.ArrayList;

public class PodcastAdapter extends RecyclerView.Adapter<PodcastAdapter.ViewHolder> {

    ArrayList<PodcastDomain> podcastDomains;

    public PodcastAdapter(ArrayList<PodcastDomain> podcastDomains) {
        this.podcastDomains = podcastDomains;
    }

    @NonNull
    @Override
    public PodcastAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewhodler_podcast,parent,false);
        return new PodcastAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PodcastAdapter.ViewHolder holder, int position) {
        holder.text_pod.setText(podcastDomains.get(position).getText_pod());
        String imgUrl="";
        switch (position){
            case 0:
                imgUrl = "pod";
                break;
            case 1:
                imgUrl = "pod_1";
                break;
            case 2:
                imgUrl = "pod_2";
                break;
            case 3:
                imgUrl = "pod_3";
                break;
        }
        int drawableReuorceId = holder.itemView.getContext().getResources().
                getIdentifier(imgUrl,"drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableReuorceId).into(holder.img_pod);
    }

    @Override
    public int getItemCount() {
        return podcastDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_pod;

        TextView text_pod;

        ConstraintLayout mainFree;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_pod = itemView.findViewById(R.id.img_pod);
            text_pod = itemView.findViewById(R.id.text_pod);
            mainFree = itemView.findViewById(R.id.mainFree);
        }
    }
}
