package com.example.coffeeexpressandroid.api;

import com.example.coffeeexpressandroid.api.model.Coffee;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface apiservices {
    @GET("coffees")
    Call<List<Coffee>> getCoffees();
}
