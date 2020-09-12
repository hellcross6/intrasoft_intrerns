package com.example.myapplication.ui.main.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.model.Posts
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val postss: ArrayList<Posts>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {
    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(posts: Posts) {
            itemView.textViewUserId.text = posts.user_id.toString()
            itemView.textViewPostsId.text = posts.id.toString()
            Glide.with(itemView.imageViewAvatar.context)
                .load(posts.title)
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

    override fun getItemCount(): Int = postss.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(postss[position])

    fun addData(list: List<Posts>) {
        postss.addAll(list)
    }





}