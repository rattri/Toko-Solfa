package com.solfashop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.solfashop.API.Interfaces.OrderService;
import com.solfashop.API.ServiceGenertor;
import com.solfashop.R;
import com.solfashop.holder.OrderHolder;
import com.solfashop.model.Order;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Ratri on 10/3/2016.
 */
public class OrderAdapter extends ListAdapter<Order, OrderHolder> {
    Context context;

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
        Order order = get(position);
        holder.textProduk.setText(order.getProduk());
        holder.textHarga.setText(""+order.getHarga());
        holder.textJumlah.setText(""+order.getJumlah());
        holder.textTotal.setText(""+order.getTotal());
        holder.card.setOnClickListener(order.cardOnClock());
        Glide.with(context).load(order.getPicture()).override(100, 100).into(holder.imgCover);
    }

    public void initData(){
        OrderService orderService = ServiceGenertor.connect(OrderService.class);
        Call<List<Order>> orderCall = orderService.getOrder();
        orderCall.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if(response.isSuccess()){
                    addAll(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {

            }
        });
    }
}
