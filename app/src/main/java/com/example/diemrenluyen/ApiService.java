package com.example.diemrenluyen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    Gson gson = new GsonBuilder().setLenient()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://192.168.1.10:8080/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @GET("mucdiemcon/list")
    Call<ArrayList<mucchamdomain>> showitem();
    @GET("mucdiemcha/list")
    Call<ArrayList<mucchadomain>> showmuccha();
    @GET("user/list")
    Call<ArrayList<userdomain>> showuser();
    @GET("lop/list")
    Call<ArrayList<userdomain>> showlop();
    @GET("khoa/list")
    Call<ArrayList<userdomain>> showkhoa();

}
