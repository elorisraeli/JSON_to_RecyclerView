package com.example.json_to_recyclerview.Network

import retrofit2.Call
import com.example.json_to_recyclerview.Network.Model.OfficeResponse
import retrofit2.http.GET

interface RetrofitService {
    @GET("employees")
    fun getMovieList(): Call<OfficeResponse>
}