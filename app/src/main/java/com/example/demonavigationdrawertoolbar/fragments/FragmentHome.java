package com.example.demonavigationdrawertoolbar.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demonavigationdrawertoolbar.R;
import com.example.demonavigationdrawertoolbar.activitis.DetailActivity;
import com.example.demonavigationdrawertoolbar.adapter.ListGirlAdapter;
import com.example.demonavigationdrawertoolbar.interfaces.IClickItem;
import com.example.demonavigationdrawertoolbar.model.Girl;

import java.util.ArrayList;

public class FragmentHome extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Girl> girlArrayList;
    private ListGirlAdapter listGirlAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        intView(view);
        return view;

    }

    private void intView(View view) {
        recyclerView = view.findViewById(R.id.rv_listGirl);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        listGirlAdapter = new ListGirlAdapter(girlArrayList(), new IClickItem() {
            @Override
            public void onClickItemGirl(Girl girl) {
                clickOnItemGotoDetail(girl);


            }
        });
        recyclerView.setAdapter(listGirlAdapter);

    }

    private void clickOnItemGotoDetail(Girl girl) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("OBJ", girl);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    private ArrayList<Girl> girlArrayList() {
        girlArrayList = new ArrayList<>();
        girlArrayList.add(new Girl("Jsooooooo", "Đã Kết Hôn", R.drawable.iteam2));
        girlArrayList.add(new Girl("Jenseiiiiii", "đọc thân", R.drawable.iteam4));
        girlArrayList.add(new Girl("Jsooooooo1", "Đã Kết Hôn", R.drawable.iteam5));
        girlArrayList.add(new Girl("Jsooooooo2", "Đã Kết Hôn", R.drawable.item1));
        girlArrayList.add(new Girl("Jsooooooo3", "Đã Kết Hôn", R.drawable.item3));
        girlArrayList.add(new Girl("Jsooooooo4", "Đã Kết Hôn", R.drawable.iteam2));
        girlArrayList.add(new Girl("Jsooooooo5", "Đã Kết Hôn", R.drawable.iteam2));
        return girlArrayList;
    }
}
