package com.example.json_to_recyclerview.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.json_to_recyclerview.Network.Model.OfficeResponse

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repository =
        DetailRepository(application)
    val response : LiveData<OfficeResponse>

    init {
        response = repository.response
    }

}