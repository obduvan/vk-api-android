package com.example.kotlin_vezdecode.activities

import android.os.Bundle
import com.example.kotlin_vezdecode.R
import com.example.kotlin_vezdecode.models.FriendModel
import com.example.kotlin_vezdecode.views.FriendsView
import moxy.MvpAppCompatActivity

class FriendsActivity : MvpAppCompatActivity(), FriendsView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.friends_activity)
    }

    override fun setFriendsList(friendsList: ArrayList<FriendModel>) {
        TODO("Not yet implemented")
    }

    override fun setEmptyList() {
        TODO("Not yet implemented")
    }

    override fun showError(content: Int) {

    }

    override fun startLoading() {
        TODO("Not yet implemented")
    }

    override fun endLoading() {
        TODO("Not yet implemented")
    }

}

