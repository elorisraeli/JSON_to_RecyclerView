package com.example.json_to_recyclerview.Interface

import retrofit2.Call
import com.example.json_to_recyclerview.Model.Data
import retrofit2.http.GET

interface RetrofitService {
    @GET("employees")
    fun getMovieList(): Call<MutableList<Data>>
}