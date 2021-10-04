package com.example.kotlin_vezdecode.presenters

import android.os.Handler
import android.os.Looper
import com.example.kotlin_vezdecode.R
import com.example.kotlin_vezdecode.views.LoginView
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class LoginPresenter: MvpPresenter<LoginView>() {


    fun login(isSuccess: Boolean){
        Handler(Looper.getMainLooper()).postDelayed({
            if (isSuccess)
                viewState.openFriends()
            else
                viewState.showError(keyText = R.string.login_error_credentials)
        }, 500)

    }
}
