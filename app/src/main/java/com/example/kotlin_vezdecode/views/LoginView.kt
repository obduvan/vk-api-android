package com.example.kotlin_vezdecode.views


import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(value = AddToEndSingleStrategy::class)
interface LoginView : MvpView {
    fun showError(textKey: Int)
    fun openFriends()
    fun startLoading()
    fun endLoading()
}