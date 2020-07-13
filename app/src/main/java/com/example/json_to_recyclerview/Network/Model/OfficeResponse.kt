package com.example.json_to_recyclerview.Network.Model

import com.google.gson.annotations.SerializedName


data class OfficeResponse(@SerializedName("status")val status: String,
                          @SerializedName("data")val data: List<Data>)