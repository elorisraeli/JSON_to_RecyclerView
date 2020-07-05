package com.example.json_to_recyclerview

import android.app.AlertDialog
import android.graphics.Movie
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.json_to_recyclerview.Adapter.MainAdapter
import com.example.json_to_recyclerview.Common.Common
import com.example.json_to_recyclerview.Interface.RetrofitService
import com.example.json_to_recyclerview.Model.Data
import com.example.json_to_recyclerview.Model.OfficeResponse
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

//    val datalist : MutableList<Data> = mutableListOf()
//    lateinit var myAdapter: MainAdapter

    lateinit var mService: RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MainAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()

//        myAdapter = MainAdapter(datalist)
//        recyclerView.adapter = myAdapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))

//        AndroidNetworking.initialize(this)
//        AndroidNetworking.get("http://dummy.restapiexample.com/api/v1/employees")
//            .build()
//            .getAsObject(OfficeResponse::class.java, object : ParsedRequestListener<OfficeResponse>{
//                override fun onResponse(response: OfficeResponse) {
//                    datalist.addAll(response.data)
//                    myAdapter.notifyDataSetChanged()
//                }
//
//                override fun onError(anError: ANError?) {
//                    Log.d("error", "there is an error")
//                }
//            })
    }

    private fun getAllMovieList() {
        dialog.show()

        mService.getMovieList().enqueue(object : Callback<MutableList<Data>> {
            override fun onFailure(call: Call<MutableList<Data>>, t: Throwable) {
                Log.d("tag", "SOMETHING WENT WRONG!")
            }

            override fun onResponse(
                call: Call<MutableList<Data>>,
                response: Response<MutableList<Data>>
            ) {
                adapter = MainAdapter(baseContext, response.body() as MutableList<Data>)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter

                dialog.dismiss()
            }

        })
    }
}
