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
import com.trangduc.fatbooks.domain.CategoryDomain;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<CategoryDomain> categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhodler_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        holder.categoryName.setText(categoryDomains.get(position).getTitle());
        String picUrl="";
        switch (position){
            case 0: {
                picUrl = "pic_1";
                break;
            }
            case 1: {
                picUrl = "pic_2";
                break;
            }
            case 2: {
                picUrl = "pic_3";
                break;
            }
            case 3: {
                picUrl = "pic_4";
                break;
            }
            case 4: {
                picUrl = "pic_5";
                break;
            }

        }
        int drawableReuorceId = holder.itemView.getContext().getResources().
                getIdentifier(picUrl,"drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableReuorceId).into(holder.categoryPic);

        holder.categoryText.setText(categoryDomains.get(position).getText());
        String imgUrl="";
        switch (position){
            case 0: {
                imgUrl = "pic_6";
                break;
            }
            case 1: {
                imgUrl = "pic_7";
                break;
            }
            case 2: {
                imgUrl = "pic_8";
                break;
            }
            case 3: {
                imgUrl = "pic_9";
                break;
            }
            case 4: {
                imgUrl = "pic_10";
                break;
            }
        }
        drawableReuorceId = holder.itemView.getContext().getResources().
                getIdentifier(imgUrl, "drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableReuorceId).into(holder.categoryImg);
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView categoryName;
        ImageView categoryPic;

        TextView categoryText;
        ImageView categoryImg;

        ConstraintLayout mainLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryPic = itemView.findViewById(R.id.categoryPic);
            categoryText = itemView.findViewById(R.id.categoryText);
            categoryImg = itemView.findViewById(R.id.categoryImg);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
