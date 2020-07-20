package com.example.json_to_recyclerview.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.json_to_recyclerview.Network.Model.OfficeResponse
import com.example.json_to_recyclerview.Network.ModelPosts.Posts
import com.example.json_to_recyclerview.R
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class MainAdapter(val context: Context, val postsList: Posts) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewForRow = LayoutInflater.from(context)
            .inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(viewForRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val postData = postsList[position]
        holder.textViewName.text = postData.title
        holder.textViewAge.text = postData.body
        holder.textViewSalary.text = postData.id.toString()

        // i know... in this specific JSON url there is no string value = no image.
//        Picasso.get().load(employeeData.profileImage).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return postsList.size
    }
}

class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
    var textViewName: TextView = itemview.textViewName
    var textViewAge: TextView = itemview.textViewAge
    var textViewSalary: TextView = itemview.textViewSalary
    var imageView: ImageView = itemview.imageView

}