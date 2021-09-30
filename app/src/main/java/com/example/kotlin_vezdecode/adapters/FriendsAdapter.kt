package com.example.kotlin_vezdecode.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_vezdecode.R
import com.example.kotlin_vezdecode.models.FriendModel


class FriendsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var initList: ArrayList<FriendModel> = ArrayList()

    private var friendsList: ArrayList<FriendModel> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.block_friend, parent, false)
        return FriendsViewHolder(itemView = itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return friendsList.count()
    }


    class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}


}