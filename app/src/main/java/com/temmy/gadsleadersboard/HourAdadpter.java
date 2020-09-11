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

public class HourAdadpter extends RecyclerView.Adapter<HourAdadpter.MyViewHolder> {
    ArrayList<String> mName, mDetails;
    ArrayList<String> mimageurl;
    Context mContext;
    RequestOptions options = new RequestOptions().centerCrop().placeholder(R.drawable.badge).error(R.drawable.badge);

    public HourAdadpter(ArrayList<String> name, ArrayList<String> details, ArrayList<String> imageurl, Context context) {
        mName = name;
        mDetails = details;
        mContext = context;
        mimageurl = imageurl;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.hour_list,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.name.setText(mName.get(position));
            holder.details.setText(mDetails.get(position));
            Glide.with(mContext).load(mimageurl.get(position)).apply(options).into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mName.size();
    }

    public static  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name , details;
        ImageView mImageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameHr);
            details = itemView.findViewById(R.id.detailsHr);
            mImageView = itemView.findViewById(R.id.hourbadge);
        }
    }
}
