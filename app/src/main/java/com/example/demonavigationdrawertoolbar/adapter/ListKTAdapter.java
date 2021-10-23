package com.example.demonavigationdrawertoolbar.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demonavigationdrawertoolbar.R;
import com.example.demonavigationdrawertoolbar.interfaces.IClickItemKhoanThu;
import com.example.demonavigationdrawertoolbar.model.KhoanThu;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListKTAdapter extends RecyclerView.Adapter<ListKTAdapter.KhoanThuViewHolder> {
    ArrayList<KhoanThu> khoanThuArrayList;
    IClickItemKhoanThu iClickItemKhoanThu;

    public ListKTAdapter(ArrayList<KhoanThu> khoanThuArrayList,IClickItemKhoanThu iClickItemKhoanThu) {
        this.khoanThuArrayList = khoanThuArrayList;
        this.iClickItemKhoanThu=iClickItemKhoanThu;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KhoanThuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_khoan_thu, parent, false);
        return new KhoanThuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KhoanThuViewHolder holder, int position) {
        KhoanThu khoanThu=khoanThuArrayList.get(position);
        holder.tv_money.setText(String.valueOf(khoanThu.getVNĐ()));
        holder.tv_nameKT.setText(khoanThu.getNameKT());
        holder.btn_clickUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iClickItemKhoanThu.OnClickItemKhoanThu(khoanThu);

            }
        });

    }

    @Override
    public int getItemCount() {
        if (khoanThuArrayList != null) {

            return khoanThuArrayList.size();
        }
        return 0;
    }

    public class KhoanThuViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nameKT, tv_money;
        LinearLayout myLayout;
        Button btn_clickUpdate;

        public KhoanThuViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nameKT = itemView.findViewById(R.id.tv_nameKT);
            tv_money = itemView.findViewById(R.id.tv_money);
            myLayout=itemView.findViewById(R.id.myLayoutItemKT);
            btn_clickUpdate=itemView.findViewById(R.id.btn_clickUpdate);

        }
    }
}
