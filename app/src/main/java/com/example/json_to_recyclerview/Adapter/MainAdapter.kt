package com.example.json_to_recyclerview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.json_to_recyclerview.Model.Data
import com.example.json_to_recyclerview.Model.OfficeResponse
import com.example.json_to_recyclerview.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class MainAdapter(val context: Context, val employeesList: MutableList<Data>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewForRow = LayoutInflater.from(context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(viewForRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val employeeData = employeesList[position]
        holder.textViewName.text = employeeData.employeeName
        holder.textViewAge.text = employeeData.employeeAge
        holder.textViewSalary.text = employeeData.employeeSalary

        // i know... in this specific JSON url there is no string value = no image.
//        Picasso.get().load(employeeData.profileImage).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return employeesList.size
    }
}

class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
    var textViewName: TextView = itemview.textViewName
    var textViewAge: TextView = itemview.textViewAge
    var textViewSalary: TextView = itemview.textViewSalary
    var imageView: ImageView = itemview.imageView

}