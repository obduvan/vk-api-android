package com.example.kotlin_vezdecode.views


import com.example.kotlin_vezdecode.models.FriendModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(value = AddToEndSingleStrategy::class)
interface FriendsView : MvpView {
    fun setFriendsList(friendsList: ArrayList<FriendModel>)
    fun setEmptyList()
    fun showError(keyText: Int)
    fun startLoading()
    fun endLoading()

}