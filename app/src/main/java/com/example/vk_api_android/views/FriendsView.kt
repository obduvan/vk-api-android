package com.example.vk_api_android.views


import com.example.vk_api_android.models.FriendModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsView : MvpView {
    fun setFriendsList(friendsList: ArrayList<FriendModel>)
    fun setEmptyList()
    fun showError(textKey: Int)
    fun startLoading()
    fun endLoading()

}