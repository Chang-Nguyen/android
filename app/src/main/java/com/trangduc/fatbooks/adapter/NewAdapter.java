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
import com.trangduc.fatbooks.domain.BookFreeDomain;
import com.trangduc.fatbooks.domain.NewDomain;

import java.util.ArrayList;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ViewHolder> {

    ArrayList<NewDomain> newDomains;

    public NewAdapter(ArrayList<NewDomain> newDomains) {
        this.newDomains = newDomains;
    }

    @NonNull
    @Override
    public NewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewhodler_new,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewAdapter.ViewHolder holder, int position) {
        holder.text_new.setText(newDomains.get(position).getText_new());
        String imgUrl="";
        switch (position){
            case 0:
                imgUrl = "tt";
                break;
            case 1:
                imgUrl = "tt_1";
                break;

        }
        int drawableReuorceId = holder.itemView.getContext().getResources().
                getIdentifier(imgUrl,"drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableReuorceId).into(holder.img_new);
    }

    @Override
    public int getItemCount() {
        return newDomains.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img_new;

        TextView text_new;

        ConstraintLayout mainFree;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_new = itemView.findViewById(R.id.img_new);
            text_new = itemView.findViewById(R.id.text_new);
            mainFree = itemView.findViewById(R.id.mainFree);
        }

    }

    public interface itemClickListener{
        void onItemClick(int position);
    }
}