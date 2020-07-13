package com.example.json_to_recyclerview.Network

import com.example.json_to_recyclerview.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "http://dummy.restapiexample.com/api/v1/"

    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(
            RetrofitService::class.java)

}