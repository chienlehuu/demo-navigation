package com.example.demonavigationdrawertoolbar.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName ="khoanthu")
public class KhoanThu implements Serializable  {
    @PrimaryKey( autoGenerate = true)
    private int id;
    private String NameKT;
    private int VNĐ;

//    public KhoanThu(int id, String mNameKT, int mVNĐ) {
//        this.id = id;
//        this.mNameKT = mNameKT;
//        this.mVNĐ = mVNĐ;
//    }

    public KhoanThu(String NameKT, int VNĐ) {
        this.NameKT = NameKT;
        this.VNĐ = VNĐ;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameKT() {
        return NameKT;
    }

    public void setNameKT(String NameKT) {
        this.NameKT = NameKT;
    }

    public int getVNĐ() {
        return VNĐ;
    }

    public void setVNĐ(int VNĐ) {
        this.VNĐ = VNĐ;
    }
}
