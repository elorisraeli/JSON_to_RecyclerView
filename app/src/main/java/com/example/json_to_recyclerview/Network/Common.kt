package com.example.json_to_recyclerview.Network

import com.example.json_to_recyclerview.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val retrofitService: RetrofitService
        get() = RetrofitClient.getClient(BASE_URL).create(
            RetrofitService::class.java)

}