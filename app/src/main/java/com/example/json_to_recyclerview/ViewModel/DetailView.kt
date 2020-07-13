package com.example.json_to_recyclerview.ViewModel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.json_to_recyclerview.R
import kotlinx.android.synthetic.main.recycler_view_item.*

class DetailView : AppCompatActivity() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        viewModel.response.observe(this, Observer {
            if (it != null){
                textViewName.text = it.data[0].employeeName
                textViewAge.text = it.data[0].employeeAge
                textViewSalary.text = it.data[0].employeeSalary
            }
        })
    }
}