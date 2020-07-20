package com.example.json_to_recyclerview.Network.ModelPosts


import com.google.gson.annotations.SerializedName

data class PostsItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)