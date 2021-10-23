package com.example.demonavigationdrawertoolbar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demonavigationdrawertoolbar.R;
import com.example.demonavigationdrawertoolbar.interfaces.IClickItem;
import com.example.demonavigationdrawertoolbar.model.Girl;

import java.util.ArrayList;

public class ListGirlAdapter extends RecyclerView.Adapter<ListGirlAdapter.GirlViewHolder> {
    public ArrayList<Girl> girlArrayList;
    public IClickItem iClickItem;

    public ListGirlAdapter(ArrayList<Girl> girlArrayList, IClickItem iClickItem) {
        this.girlArrayList = girlArrayList;
        this.iClickItem = iClickItem;
    }

    @NonNull
    @Override
    public GirlViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rcview,parent,false);
        return new GirlViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GirlViewHolder holder, int position) {
        Girl girl= girlArrayList.get(position);
        holder.imageView.setImageResource(girl.getmImage());
        holder.tv_name.setText(girl.getmName());
        holder.tv_status.setText(girl.getmStatus());
        holder.layoutClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickItem.onClickItemGirl(girl);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(girlArrayList!=null){
            return girlArrayList.size();
        }
        return 0;

    }

    public class GirlViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView tv_name,tv_status;
        public RelativeLayout layoutClick;

        public GirlViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.im_view);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_status=itemView.findViewById(R.id.tv_status);
            layoutClick=itemView.findViewById(R.id.rLayout);
        }
    }


}
