package com.solfashop.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.solfashop.API.Interfaces.PriceService;
import com.solfashop.API.ServiceGenerator;
import com.solfashop.holder.PriceHolder;
import com.solfashop.model.PriceList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ratri on 10/3/2016.
 */
public class PriceAdapter extends ListAdapter<PriceList, PriceHolder> {
    Context context;
    String web= "http://solfacell.solfagaming.com/";;

    public PriceAdapter(Context ctx){
        context = ctx;
    }

    @Override
    public PriceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println("on create holder");
        PriceHolder priceHolder = new PriceHolder(parent);
        return priceHolder;
    }

    @Override
    public void onBindViewHolder(PriceHolder holder, int position) {
        PriceList priceList = get(position);
        holder.textProduk.setText(priceList.getNama());
        holder.textHarga.setText(priceList.getHarga());
//        holder.textJumlah.setText(voucher.getKategori());
//        holder.textTotal.setText(voucher.getGambar());
//        holder.card.setOnClickListener(voucher.cardOnClock());

//        Glide.with(context).load(ServiceGenerator.baseUrlGithub+"produk/"+voucher.getGambar()+".png").override(100, 100).into(holder.imgCover);
    }

    public void initData(){
        PriceService priceService = ServiceGenerator.connect(PriceService.class);
        Call<List<PriceList>> orderCall = priceService.getPrice("1");
        orderCall.enqueue(new Callback<List<PriceList>>() {
            @Override
            public void onResponse(Call<List<PriceList>> call, Response<List<PriceList>> response) {
                if(response.isSuccess()){
                    addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<PriceList>> call, Throwable t) {

            }
        });
    }
}
