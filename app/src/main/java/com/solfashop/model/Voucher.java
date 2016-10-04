package com.solfashop.model;

import android.view.View;

import com.solfashop.BaseActivity;
import com.solfashop.fragment.BaseFragment;

/**
 * Created by Ratri on 9/29/2016.
 */
public class Voucher {

    private String id_voucher;
    private String nama;
    private String kategori;
    private String gambar;


    public String getId_voucher() {return id_voucher;}
    public void setId_voucher(String id_voucher) {this.id_voucher = id_voucher;}
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public View.OnClickListener cardOnClock(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("klik di "+getNama());
//                getBaseActivity().startFragment(BaseActivity.FRAGMENT_PRICELIST, "PriceList FRAGMENT");
            }
        };
    }



}