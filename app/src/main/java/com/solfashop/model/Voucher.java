package com.solfashop.model;

import android.view.View;

import com.solfashop.BaseActivity;
import com.solfashop.fragment.BaseFragment;

/**
 * Created by Ratri on 9/29/2016.
 */
public class Voucher {
    private String name;
    private int thumbnail;

    public Voucher() {
    }

    public Voucher(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}