package com.example.json_to_recyclerview

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.json_to_recyclerview.Adapter.MainAdapter
import com.example.json_to_recyclerview.Network.Common
import com.example.json_to_recyclerview.Network.RetrofitService
import com.example.json_to_recyclerview.Network.ModelPosts.Posts
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    
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

        getAllEmployeesList()
    }

    private fun getAllEmployeesList() {
        dialog.show()

        mService.getPostsList().enqueue(object : Callback<Posts> {
            override fun onFailure(call: Call<Posts>, t: Throwable) {
                Log.d("tag", "SOMETHING WENT WRONG!")
            }

            override fun onResponse(
                call: Call<Posts>,
                response: Response<Posts>
            ) {
                adapter = MainAdapter(baseContext, response.body() as Posts)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
                Log.d("tag", "Response: ${response.body().toString()}")

                dialog.dismiss()
            }

        })
    }
}
