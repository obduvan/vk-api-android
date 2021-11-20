package com.example.vk_api_android.adapters

import android.annotation.SuppressLint


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vk_api_android.R
import com.example.vk_api_android.models.FriendModel
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView


class FriendsAdapter : RecyclerView.Adapter<FriendsAdapter.FriendsViewHolder>() {

    private var sourceFriendList: ArrayList<FriendModel> = ArrayList()
    private var friendsList: ArrayList<FriendModel> = ArrayList()

    fun setupFriends(friendsListFromPres: ArrayList<FriendModel>) {
        sourceFriendList.clear()
        sourceFriendList.addAll(friendsListFromPres)
        filter(query = "")
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendsViewHolder {
        val layoutInflater: LayoutInflater =
            LayoutInflater.from(parent.context)        //parent = RV
        val itemView: View = layoutInflater.inflate(R.layout.block_friend, parent, false)

        return FriendsViewHolder(itemView = itemView)
    }

    override fun onBindViewHolder(holder: FriendsViewHolder, position: Int) {
        holder.bind(friendModel = friendsList[position])

    }

    override fun getItemCount(): Int = friendsList.size

    @SuppressLint("NotifyDataSetChanged")
    fun filter(query: String) {
        friendsList.clear()
        sourceFriendList.forEach {
            if (it.name.contains(query, ignoreCase = true) || it.surname.contains(query,ignoreCase = true)) {
                friendsList.add(it)
            } else {
                it.city?.let { city ->
                    if (city.contains(query, ignoreCase = true)) {
                        friendsList.add(it)
                    }
                }
            }
        }

        notifyDataSetChanged()

    }

    class FriendsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var civAvatar: CircleImageView = itemView.findViewById(R.id.civ_friend_avatar)
        private var txtUserName: TextView = itemView.findViewById(R.id.txt_user_name)
        private var txtCity: TextView = itemView.findViewById(R.id.txt_city_friend)
        private var imgOnline: ImageView = itemView.findViewById(R.id.img_online_status)

//        @SuppressLint("SetTextI18n")



        fun bind(friendModel: FriendModel) {
            friendModel.image?.let { url ->
                Picasso.get().load(url).into(civAvatar)
            }
            txtUserName.text = "${friendModel.name} ${friendModel.surname}"
            txtCity.text = friendModel.city ?: itemView.context.getString(R.string.friend_no_city)

            if (friendModel.online)
                imgOnline.visibility = View.VISIBLE
            else
                imgOnline.visibility = View.GONE

        }
    }
}