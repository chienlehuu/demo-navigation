package com.example.demonavigationdrawertoolbar.activitis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demonavigationdrawertoolbar.R;
import com.example.demonavigationdrawertoolbar.model.Girl;

public class DetailActivity extends AppCompatActivity {
    private ImageView im_detail;
    private TextView tv_name;
    private TextView tv_status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        inTView();
        getDataFromFragmentHome();
    }

    private void getDataFromFragmentHome() {
        Bundle bundle=getIntent().getExtras();
        if(bundle==null){
            return;
        }
        Girl girl= (Girl) bundle.get("OBJ");
        im_detail.setImageResource(girl.getmImage());
        tv_status.setText(girl.getmStatus());
        tv_name.setText(girl.getmName());

    }

    private void inTView() {
        im_detail= findViewById(R.id.im_imageDetail);
        tv_name=findViewById(R.id.tv_NameDetail);
        tv_status=findViewById(R.id.tv_statusDetail);
    }
}