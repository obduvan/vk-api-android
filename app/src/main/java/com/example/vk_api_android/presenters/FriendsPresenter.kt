package com.example.vk_api_android.presenters

import com.example.vk_api_android.R
import com.example.vk_api_android.models.FriendModel
import com.example.vk_api_android.providers.FriendsProvider
import com.example.vk_api_android.views.FriendsView
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class FriendsPresenter : MvpPresenter<FriendsView>() {
    fun loadFriends() {
        viewState.startLoading()
        FriendsProvider(presenter = this).loadFriends()

    }

    fun friendsLoaded(friendsList: ArrayList<FriendModel>) {
        viewState.endLoading()
        if (friendsList.size == 0) {
            viewState.setEmptyList()
            viewState.showError(textKey = R.string.friends_no_items)
        } else {
            viewState.setFriendsList(friendsList = friendsList)
        }
    }

    fun showError(textKey: Int){
        viewState.showError(textKey =textKey )
    }

}