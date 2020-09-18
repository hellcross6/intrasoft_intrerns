package com.example.myapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.users.User
import com.example.myapplication.data.users.UserModel

import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val user: ArrayList<User>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {

            itemView.textViewUserName.text = user.name
            itemView.textViewUserEmail.text = user.email
            itemView.textViewUserid.text = user.id.toString()
            itemView.textViewUsergender.text=user.gender
            itemView.textViewUsercreatedat.text=user.created_at
            itemView.button3
//            Glide.with(itemView.imageViewAvatar.context)
//                .load(user.avatar)
//                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = user.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(user[position])

    fun addData(list: UserModel) {
        user.addAll(list.user)
    }

}