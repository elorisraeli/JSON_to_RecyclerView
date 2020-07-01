package com.example.json_to_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.json_to_recyclerview.model.Data
import com.example.json_to_recyclerview.model.OfficeResponse
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val datalist : MutableList<Data> = mutableListOf()
    lateinit var myAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myAdapter = MainAdapter(datalist)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))

        AndroidNetworking.initialize(this)
        AndroidNetworking.get("http://dummy.restapiexample.com/api/v1/employees")
            .build()
            .getAsObject(OfficeResponse::class.java, object : ParsedRequestListener<OfficeResponse>{
                override fun onResponse(response: OfficeResponse) {
                    datalist.addAll(response.data)
                    myAdapter.notifyDataSetChanged()
                }

                override fun onError(anError: ANError?) {
                }

            })
    }
}
