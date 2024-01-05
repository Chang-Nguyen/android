package com.trangduc.fatbooks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.makeramen.roundedimageview.RoundedImageView;
import com.trangduc.fatbooks.Photo;
import com.trangduc.fatbooks.R;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>{

    private List<Photo> photo;
    private ViewPager2 viewpager2;

    public PhotoAdapter(List<Photo> photo, ViewPager2 viewpager2) {
        this.photo = photo;
        this.viewpager2 = viewpager2;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PhotoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.photo_item_container, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        holder.setImage(photo.get(position));
        if(position == photo.size() -2){
            viewpager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return photo.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder{

        private RoundedImageView imageView;
        PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagePhoto);
        }

        void setImage(Photo photo){
            imageView.setImageResource(photo.getImage());
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            photo.addAll(photo);
            notifyDataSetChanged();
        }
    };
}
