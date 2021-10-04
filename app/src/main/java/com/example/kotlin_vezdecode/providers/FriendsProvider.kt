package com.example.kotlin_vezdecode.providers

import android.os.Handler
import android.os.Looper
import com.example.kotlin_vezdecode.models.FriendModel
import com.example.kotlin_vezdecode.presenters.FriendsPresenter

class FriendsProvider(var presenter: FriendsPresenter) {
    private val TAG: String = FriendsProvider::class.java.simpleName

    fun testLoadFriends(hasFriends: Boolean) {
        Handler(Looper.getMainLooper()).postDelayed({
            val friendsList = ArrayList<FriendModel>()

            if (hasFriends) {
                val friend1 =
                    FriendModel(
                        name = "Vasya",
                        surname = "Ivan",
                        city = "Ebenya",
                        online = false,
                        image = null
                    )
                val friend2 =
                    FriendModel(
                        name = "Ivann",
                        surname = "Ivan",
                        city = null,
                        online = true,
                        image = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg"
                    )
                val friend3 =
                    FriendModel(
                        name = "Eptol",
                        surname = "Ivanov",
                        city = "Moscow",
                        online = true,
                        image = "https://static.remove.bg/remove-bg-web/8fb1a6ef22fefc0b0866661b4c9b922515be4ae9/assets/start-1abfb4fe2980eabfbbaaa4365a0692539f7cd2725f324f904565a9a744f8e214.jpg"
                    )
                friendsList.add(friend1)
                friendsList.add(friend2)
                friendsList.add(friend3)

            }
            presenter.friendsLoaded(friendsList = friendsList)


        }, 200)

    }
}