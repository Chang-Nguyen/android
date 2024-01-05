package com.trangduc.fatbooks.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.trangduc.fatbooks.R;

import java.util.ArrayList;

public class ItemBookAdapter extends RecyclerView.Adapter<ItemBookAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<Integer> integerArrayList;
    buttonClickListener buttonClickListener;


    public ItemBookAdapter(Context context, ArrayList<Integer> integerArrayList,
                           buttonClickListener buttonClickListener) {
        this.context = context;
        this.integerArrayList = integerArrayList;
        this.buttonClickListener = buttonClickListener;
    }

    @NonNull
    @Override
    public ItemBookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.viewholder_itembook,parent,false);
        return new ItemBookAdapter.ViewHolder(view, buttonClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemBookAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(integerArrayList.get(position))
                .into(holder.itemPic);
    }

    @Override
    public int getItemCount() {
        return integerArrayList.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView itemPic;

        Button itemBtn;

        buttonClickListener buttonClickListener;
        public ViewHolder(@NonNull View itemView, buttonClickListener buttonClickListener) {
            super(itemView);
            itemPic = itemView.findViewById(R.id.itemPic);
            itemBtn = itemView.findViewById(R.id.itemBtn);
            this.buttonClickListener = buttonClickListener;
            itemBtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            buttonClickListener.onButtonClick(getAdapterPosition());
        }
    }
    public interface buttonClickListener {
        void onButtonClick(int position);
    }
}