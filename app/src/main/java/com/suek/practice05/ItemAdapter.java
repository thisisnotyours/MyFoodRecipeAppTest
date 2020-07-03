package com.suek.practice05;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Item> items;

    public ItemAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_todaysmenu, parent, false);
        VH1 holder= new VH1(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH1 vh1= (VH1)holder;
        Item item= items.get(position);

        Glide.with(context).load(item.imgURL).into(vh1.iv);
        vh1.tvName.setText(item.tvname);
        vh1.tvPrice.setText(item.tvprice);



        vh1.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(  context, YoutubeActivity.class);
                intent.putExtra("pos", position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    class VH1 extends RecyclerView.ViewHolder{

        ImageView iv;
        TextView tvName;
        TextView tvPrice;

        public VH1(@NonNull View itemView) {
            super(itemView);
            this.iv = itemView.findViewById(R.id.iv);
            this.tvName = itemView.findViewById(R.id.tv_name);
            this.tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
