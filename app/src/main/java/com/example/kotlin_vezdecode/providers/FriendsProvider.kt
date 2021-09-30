package com.example.kotlin_vezdecode.providers

import com.example.kotlin_vezdecode.models.FriendModel
import com.example.kotlin_vezdecode.presenters.FriendsPresenter
import java.util.logging.Handler

class FriendsProvider(var presenter: FriendsPresenter) {
    private val TAG: String = FriendsProvider::class.java.simpleName

    fun testLoadFriends(hasFriends: Boolean) {

    }
}