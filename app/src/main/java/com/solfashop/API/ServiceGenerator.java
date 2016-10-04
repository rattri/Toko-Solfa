package com.solfashop.API;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.RetryableSink;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ratri on 10/3/2016.
 */
public class ServiceGenerator {
    public static final String baseUrlGithub = "http://solfacell.solfagaming.com/";
    public static <T> T connect(Class<T> service){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder requestBuilder = request.newBuilder();
                        requestBuilder.method(request.method(), request.body());
                        Response response = chain.proceed(requestBuilder.build());
                        return response;
                    }
                }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrlGithub)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(service);
    }

}
