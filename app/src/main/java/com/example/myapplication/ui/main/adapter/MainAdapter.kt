package com.example.myapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.data.ListOfPosts
import com.example.myapplication.data.Posts
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val users: ArrayList<Posts>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: Posts) {
            itemView.textViewPostsId.text = user.id.toString()
            itemView.textViewUserId.text = user.user_id.toString()
            Glide.with(itemView.imageViewAvatar.context)
                .load(user.title)
                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: ListOfPosts) {
        users.addAll(list)
    }

}

private fun <E> java.util.ArrayList<E>.addAll(elements: ListOfPosts) {
    TODO("Not yet implemented")
}

