package com.example.rest_api_fundamental.posts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rest_api_fundamental.R
import com.example.rest_api_fundamental.posts.model.Post
import kotlinx.android.synthetic.main.list_item_layout.view.*

class ListAdapter(private val postList: List<Post>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout,parent,false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount() = postList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = postList[position]
        holder.textView.setText(currentItem.title)
        holder.textBody.setText(currentItem.body)
        holder.userId.setText(currentItem.userId.toString())
        holder.listId.setText(currentItem.id.toString())
    }

    class ListViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
        val textView : TextView = itemView.list_item_text_view
        val textBody : TextView = itemView.list_item_body_view
        val userId : TextView = itemView.user_id_data
        val listId : TextView = itemView.id_data

    }
}