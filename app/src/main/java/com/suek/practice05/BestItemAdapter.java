package com.suek.practice05;
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

public class BestItemAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Best_Item> best_items;

    public BestItemAdapter(Context context, ArrayList<Best_Item> best_items) {
        this.context = context;
        this.best_items = best_items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View itemView= inflater.inflate(R.layout.recycler_bestitem, parent,false);
        VH holder= new VH(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        VH vh= (VH)holder;
        Best_Item best_item= best_items.get(position);
        vh.tvName.setText(best_item.name);
        vh.tvPrice.setText(best_item.price);
        Glide.with(context).load(best_item.imgURL).into(vh.iv);
    }

    @Override
    public int getItemCount() {
        return best_items.size();
    }


    class VH extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tvName;
        TextView tvPrice;

        public VH(@NonNull View itemView) {
            super(itemView);
            this.iv = itemView.findViewById(R.id.iv);
            this.tvName= itemView.findViewById(R.id.tv_name);
            this.tvPrice= itemView.findViewById(R.id.tv_price);
        }
    }
}
