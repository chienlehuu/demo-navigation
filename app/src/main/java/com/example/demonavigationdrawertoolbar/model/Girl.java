package com.example.demonavigationdrawertoolbar.model;

import java.io.Serializable;

public class Girl implements Serializable {
    String mName,mStatus;
    int mImage;

    public Girl(String mName, String mStatus, int mImage) {
        this.mName = mName;
        this.mStatus = mStatus;
        this.mImage = mImage;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }
}
