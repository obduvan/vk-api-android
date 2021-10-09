package com.example.kotlin_vezdecode.providers

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.example.kotlin_vezdecode.R
import com.example.kotlin_vezdecode.models.FriendModel
import com.example.kotlin_vezdecode.presenters.FriendsPresenter
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.VKApiConfig
import com.vk.api.sdk.auth.VKAuthParams
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.requests.VKRequest
import com.vk.api.sdk.utils.VKUtils
import com.vk.api.sdk.utils.VKUtils.getCertificateFingerprint
import com.vk.sdk.api.friends.FriendsService
import com.vk.sdk.api.friends.dto.FriendsGetFieldsResponse
import com.vk.sdk.api.users.dto.UsersFields
import com.vk.sdk.api.users.dto.UsersFields.*
import com.vk.sdk.api.users.dto.UsersUserFull


class FriendsProvider(var presenter: FriendsPresenter) {
    private val TAG: Class<FriendsProvider> = FriendsProvider::class.java
    private var friendsList: ArrayList<FriendModel> = arrayListOf();

    fun testLoadFriends(hasFriends: Boolean) {

        Handler(Looper.getMainLooper()).postDelayed({
            val friendsList = ArrayList<FriendModel>()

            if (hasFriends) {
                val friend1 =
                    FriendModel(
                        name = "Ivan",
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

    fun loadFriends() {
        val fields = listOf(FIRST_NAME_NOM, LAST_NAME_NOM, CITY, ONLINE_INFO, PHOTO)
        VK.execute(
            FriendsService().friendsGet(fields = fields,),
            object : VKApiCallback<FriendsGetFieldsResponse> {
                override fun fail(error: Exception) {
                    Log.e("ERROR", error.toString())
                    presenter.showError(textKey = R.string.friends_error_loading)
                }

                override fun success(result: FriendsGetFieldsResponse) {
//                    deleteNull(result.items)
                    presenter.friendsLoaded(getFriendsModels(result.items))
                }

            })
    }


    fun getFriendsModels(listUser: List<UsersUserFull>): ArrayList<FriendModel> {
        friendsList.clear()

        listUser.forEach {
            friendsList.add(
                FriendModel(
                    name = if (it.firstName != null) it.firstName!! else "",
                    surname = if (it.lastName != null) it.lastName!! else "",
                    city = it.city?.title,
                    online = it.onlineInfo?.isOnline ?: false,
                    image = it.photo
                )
            )
        }
        return friendsList
    }


    fun deleteNull(listUsers: List<UsersUserFull>) {
        listUsers.forEach {
            Log.e("TAG", it.city.toString())
        }
    }
}