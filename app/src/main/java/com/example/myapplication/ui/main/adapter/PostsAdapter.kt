package com.example.myapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.ListOfPosts
import com.example.myapplication.data.Posts
import com.example.myapplication.data.User
import com.example.myapplication.data.UserModel
import kotlinx.android.synthetic.main.post_layout.view.*
import kotlinx.android.synthetic.main.user_layout.view.*

class PostsAdapter

    (  private val post: ArrayList<Posts>
    ) : RecyclerView.Adapter<PostsAdapter.DataViewHolder>() {

        class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(post: Posts) {
                itemView.textViewPostsTitle.text = post.title
                itemView.textViewPostsBody.text = post.body
                itemView.textViewPostsid.text = post.id.toString()
                itemView.textViewPostsuserId.text = post.user_id.toString()
                itemView.textViewPostscreatedat.text = post.created_at
                // itemView.comments
                //  itemView.delete
                //   itemView.posts
//           / itemView.button3
//            Glide.with(itemView.imageViewAvatar.context)
//                .load(user.avatar)
//                .into(itemView.imageViewAvatar)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            DataViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.user_layout, parent,
                    false
                )
            )

        override fun getItemCount(): Int = post.size

        override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
            holder.bind(post[position])

        fun addData(list: ListOfPosts) {
            post.addAll(list.data)
        }

    }
