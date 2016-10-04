package com.solfashop.API.Interfaces;

import com.solfashop.model.PriceList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ratri on 10/4/2016.
 */
public interface PriceService {
    @GET("pricelist.php")
    Call<List<PriceList>> getPrice(@Query("a") String a);
}

