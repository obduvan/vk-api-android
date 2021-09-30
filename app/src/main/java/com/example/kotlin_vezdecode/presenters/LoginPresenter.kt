package com.example.kotlin_vezdecode.presenters

import android.os.Handler
import com.example.kotlin_vezdecode.views.LoginView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class LoginPresenter: MvpPresenter<LoginView>() {


    fun login(isSuccess: Boolean){
        Handler().postDelayed({
            if (isSuccess)
                viewState.openFriends()
            else
                viewState.showError("ERROE")
        }, 500)

    }
}
