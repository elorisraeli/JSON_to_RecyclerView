package com.example.json_to_recyclerview.Network

import retrofit2.Call
import com.example.json_to_recyclerview.Network.Model.OfficeResponse
import com.example.json_to_recyclerview.Network.ModelPosts.Posts
import retrofit2.http.GET

interface RetrofitService {
    @GET("posts")
    fun getPostsList(): Call<Posts>
}