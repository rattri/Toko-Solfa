package com.solfashop.model;

import android.view.View;

import com.solfashop.BaseActivity;
import com.solfashop.fragment.BaseFragment;

/**
 * Created by Ratri on 10/3/2016.
 */
public class Order extends BaseFragment {

    String produk;
    int harga;
    int jumlah;
    int total;
    String picture;

    public String getProduk() {
        return produk;
    }

    public void setProduk(String produk) {
        this.produk = produk;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public View.OnClickListener cardOnClock(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("klik di "+getProduk());
                getBaseActivity().startFragment(BaseActivity.FRAGMENT_PRICELIST, "PriceList FRAGMENT");
            }
        };
    }
}
