package com.temmy.gadsleadersboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.MyListHolder>{

    ArrayList<String> name;
    ArrayList<String> details;
    ArrayList<String> imageurl;
    Context context;
    RequestOptions  options = new RequestOptions().centerCrop().placeholder(R.drawable.badge).error(R.drawable.badge);

    public SkillAdapter(ArrayList<String> name, ArrayList<String> details, ArrayList<String> imageurl, Context context) {
        this.name = name;
        this.details = details;
        this.context = context;
        this.imageurl = imageurl;
    }

    @NonNull
    @Override
    public MyListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.skill_list, parent, false);
        return new MyListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillAdapter.MyListHolder holder, int position) {
        holder.nameView.setText(name.get(position));
        holder.detailView.setText(details.get(position));
        Glide.with(context).load("https://res.cloudinary.com/mikeattara/image/upload/v1596700835/skill-IQ-trimmed.png").apply(options).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class MyListHolder extends RecyclerView.ViewHolder{

        TextView nameView, detailView;
        ImageView mImageView;
        public MyListHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.name);
            detailView = itemView.findViewById(R.id.details);
            mImageView =itemView.findViewById(R.id.skillbadge);
        }
    }
}
