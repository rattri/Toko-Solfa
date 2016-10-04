package com.solfashop.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.solfashop.API.Interfaces.OrderService;
import com.solfashop.API.ServiceGenerator;
import com.solfashop.holder.OrderHolder;
import com.solfashop.model.Voucher;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ratri on 10/3/2016.
 */
public class OrderAdapter extends ListAdapter<Voucher, OrderHolder> {
    Context context;
    String web= "http://solfacell.solfagaming.com/";;

    public OrderAdapter(Context ctx){
        context = ctx;
    }

    @Override
    public OrderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println("on create holder");
        OrderHolder orderHolder = new OrderHolder(parent);
        return orderHolder;
    }

    @Override
    public void onBindViewHolder(OrderHolder holder, int position) {
        Voucher voucher = get(position);
        holder.textProduk.setText(voucher.getNama());
        holder.textHarga.setText(voucher.getId_voucher());
        holder.textJumlah.setText(voucher.getKategori());
        holder.textTotal.setText(voucher.getGambar());
        holder.card.setOnClickListener(voucher.cardOnClock());

        Glide.with(context).load(ServiceGenerator.baseUrlGithub+"produk/"+voucher.getGambar()+".png").override(100, 100).into(holder.imgCover);
    }

    public void initData(){
        OrderService orderService = ServiceGenerator.connect(OrderService.class);
        Call<List<Voucher>> orderCall = orderService.getVoucher("1");
        orderCall.enqueue(new Callback<List<Voucher>>() {
            @Override
            public void onResponse(Call<List<Voucher>> call, Response<List<Voucher>> response) {
                if(response.isSuccess()){
                    addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Voucher>> call, Throwable t) {

            }
        });
    }
}
