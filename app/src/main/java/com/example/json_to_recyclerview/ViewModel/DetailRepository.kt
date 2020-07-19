package com.example.json_to_recyclerview.ViewModel

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.json_to_recyclerview.Network.Common
import com.example.json_to_recyclerview.Network.Model.OfficeResponse
import com.example.json_to_recyclerview.Network.RetrofitService
import com.example.json_to_recyclerview.Retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailRepository(val context: Context) {

    val response = MutableLiveData<OfficeResponse>()

    val service = Common.retrofitService.getEmployeesList().enqueue(object : Callback<OfficeResponse> {
        override fun onFailure(call: Call<OfficeResponse>, t: Throwable) {
            Log.d("tag", "Something Go Wrong!!")
        }

        override fun onResponse(
            call: Call<OfficeResponse>,
            resp: Response<OfficeResponse>
        ) {
            response.value = resp.body()
            Log.d("tag", "Perfect Response!!")
        }
    })
}