package com.example.kotlin_vezdecode.presenters

import com.example.kotlin_vezdecode.R
import com.example.kotlin_vezdecode.models.FriendModel
import com.example.kotlin_vezdecode.providers.FriendsProvider
import com.example.kotlin_vezdecode.views.FriendsView
import moxy.InjectViewState
import moxy.MvpPresenter


@InjectViewState
class FriendsPresenter : MvpPresenter<FriendsView>() {
    fun loadFriends() {
        viewState.startLoading()
        FriendsProvider(presenter = this).testLoadFriends(hasFriends = true)

    }

    fun friendsLoaded(friendsList: ArrayList<FriendModel>) {
        viewState.endLoading()
        if (friendsList.size == 0) {
            viewState.setEmptyList()
            viewState.showError(keyText = R.string.friends_no_items)
        } else {
            viewState.setFriendsList(friendsList = friendsList)
        }

    }

}