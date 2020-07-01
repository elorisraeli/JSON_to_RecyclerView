package com.example.json_to_recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.json_to_recyclerview.model.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.employee_details.view.*

class MainAdapter(val dataList: MutableList<Data>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val viewForRow = layoutInflater.inflate(R.layout.employee_details, parent, false)
        return ViewHolder(viewForRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.itemView.textViewName.text = data.employeeName
        holder.itemView.textViewAge.text = data.employeeAge
        holder.itemView.textViewSalary.text = data.employeeSalary

        // i know... in JSON url there is no string value = no image.
        Picasso.get()
            .load(data.profileImage)
            .into(holder.itemView.imageView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}