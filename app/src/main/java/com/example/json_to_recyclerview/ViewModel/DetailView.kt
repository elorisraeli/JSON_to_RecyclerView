package com.example.json_to_recyclerview.ViewModel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.json_to_recyclerview.R
import kotlinx.android.synthetic.main.recycler_view_item.*

class DetailView : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        viewModel.response.observe(this, Observer {
            if (it != null){
                textViewName.text = it[0].title
                textViewAge.text = it[0].body
                textViewSalary.text = it[0].id.toString()
                Log.d("tag", it[0].toString())
            }
        })
    }
}