package com.example.demonavigationdrawertoolbar.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demonavigationdrawertoolbar.R;
import com.example.demonavigationdrawertoolbar.activitis.UpdateKhoanThuActivity;
import com.example.demonavigationdrawertoolbar.adapter.ListKTAdapter;
import com.example.demonavigationdrawertoolbar.database.DatabaseManager;
import com.example.demonavigationdrawertoolbar.interfaces.IClickItemKhoanThu;
import com.example.demonavigationdrawertoolbar.model.KhoanThu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FragmentKhoanThu extends Fragment implements View.OnClickListener {
    EditText edt_nameKT, edt_money;
    Button btn_nhap;
    RecyclerView rc_khoanthu;
    ListKTAdapter listKTAdapter;
    ArrayList<KhoanThu> khoanThuArrayList;
    ActivityResultLauncher<Intent> someActivityResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_khoanthu, container, false);
        anhxa(view);

        return view;
    }

    private void anhxa(View view) {
        edt_nameKT = view.findViewById(R.id.edt_nameKT);
        edt_money = view.findViewById(R.id.edt_money);
        btn_nhap = view.findViewById(R.id.btn_nhapKT);
        rc_khoanthu = view.findViewById(R.id.rc_KhoanThu);

        khoanThuArrayList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        rc_khoanthu.setLayoutManager(linearLayoutManager);
        getDataFromDatabase();
        btn_nhap.setOnClickListener(this);
    }

    private void getDataFromDatabase() {
        khoanThuArrayList = (ArrayList<KhoanThu>)
                DatabaseManager.getInstance(getContext()).khoanThuDAO().getArrayList();
        listKTAdapter = new ListKTAdapter(khoanThuArrayList, new IClickItemKhoanThu() {
            @Override
            public void OnClickItemKhoanThu(KhoanThu khoanThu) {
                OnclickItemKhoanThu(khoanThu);
            }
        });
        rc_khoanthu.setAdapter(listKTAdapter);

    }

    private void OnclickItemKhoanThu(KhoanThu khoanThu) {

        Intent intent = new Intent(getContext(), UpdateKhoanThuActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("OBJ", khoanThu);
        intent.putExtras(bundle);
        // code sự kiện on click khoan thu
        someActivityResult.launch(intent);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        someActivityResult = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            getDataFromDatabase();
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        String nameKT = edt_nameKT.getText().toString().trim();
        String moneyKt = edt_money.getText().toString().trim();

        if (TextUtils.isEmpty(nameKT) && TextUtils.isEmpty(moneyKt)) {
            Toast.makeText(getContext(), "vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        KhoanThu khoanThu = new KhoanThu(nameKT, Integer.parseInt(moneyKt));

        if (isKhoanThu(khoanThu) == true) {
            Toast.makeText(getContext(), "Tên Khoản Thu Đã Tồn Tại", Toast.LENGTH_SHORT).show();
            return;
        }
        DatabaseManager.getInstance(getContext()).khoanThuDAO().insertKhoanThu(khoanThu);
        Toast.makeText(getContext(), "Thêm Thành Công", Toast.LENGTH_SHORT).show();
        getDataFromDatabase();
        clearText();


    }

    public void clearText() {
        edt_nameKT.setText("");
        edt_money.setText("");
    }

    public boolean isKhoanThu(KhoanThu khoanThu) {
        List<KhoanThu> khoanThuList = DatabaseManager.getInstance(getContext()).khoanThuDAO().checkListKT(khoanThu.getNameKT());
        if (khoanThuList != null && !khoanThuList.isEmpty()) {
            return true;
        }
        return false;
    }
}
