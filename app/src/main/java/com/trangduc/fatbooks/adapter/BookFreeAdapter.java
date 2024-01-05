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

import java.util.ArrayList;

public class BookFreeAdapter extends RecyclerView.Adapter<BookFreeAdapter.ViewHolder> {

    ArrayList<BookFreeDomain> bookFreeDomains;

    public BookFreeAdapter(ArrayList<BookFreeDomain> bookFreeDomains) {
        this.bookFreeDomains = bookFreeDomains;
    }

    @NonNull
    @Override
    public BookFreeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewhodler_bookfree,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookFreeAdapter.ViewHolder holder, int position) {
        holder.text_free.setText(bookFreeDomains.get(position).getText());
        String imgUrl="";
        switch (position){
            case 0:
                imgUrl = "free";
                break;
            case 1:
                imgUrl = "free_1";
                break;
            case 2:
                imgUrl = "free_2";
                break;
            case 3:
                imgUrl = "free_3";
                break;
            case 4:
                imgUrl = "free_4";
                break;
            case 5:
                imgUrl = "free_5";
                break;
            case 6:
                imgUrl = "free_6";
                break;
            case 7:
                imgUrl = "free_7";
                break;
        }
        int drawableReuorceId = holder.itemView.getContext().getResources().
                getIdentifier(imgUrl,"drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableReuorceId).into(holder.img_free);
    }

    @Override
    public int getItemCount() {
        return bookFreeDomains.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img_free;

        TextView text_free;

        ConstraintLayout mainFree;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_free = itemView.findViewById(R.id.img_free);
            text_free = itemView.findViewById(R.id.text_free);
            mainFree = itemView.findViewById(R.id.mainFree);
        }

    }

    public interface itemClickListener{
        void onItemClick(int position);
    }
}