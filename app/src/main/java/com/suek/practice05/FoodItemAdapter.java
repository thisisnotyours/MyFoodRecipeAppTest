package com.suek.practice05;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FoodItemAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<FoodItem> foodItems;

    public FoodItemAdapter(Context context, ArrayList<FoodItem> foodItems) {
        this.context = context;
        this.foodItems = foodItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_food, parent, false);

        VH holder= new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;
        FoodItem foodItem= foodItems.get(position);

        vh.civ.setImageResource(foodItem.profileImg);
        vh.tvName.setText(foodItem.food);
        vh.tvMsg.setText(foodItem.msg);
        Glide.with(context).load(foodItem.imgURL).into(vh.iv);

    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }


    class VH extends RecyclerView.ViewHolder{
        CircleImageView civ;
        TextView tvName;
        TextView tvMsg;
        ImageView iv;

        public VH(@NonNull View itemView) {
            super(itemView);
            this.civ = itemView.findViewById(R.id.civ_profile);
            this.tvName = itemView.findViewById(R.id.tv_name);
            this.tvMsg = itemView.findViewById(R.id.tv_msg);
            this.iv = itemView.findViewById(R.id.iv);
        }
    }


}
