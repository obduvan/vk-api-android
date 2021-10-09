package com.example.kotlin_vezdecode.presenters

import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.example.kotlin_vezdecode.R
import com.example.kotlin_vezdecode.views.LoginView
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.exceptions.VKAuthException
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {


    fun login(isSuccess: Boolean) {
        Handler(Looper.getMainLooper()).postDelayed({
            if (isSuccess)
                viewState.openFriends()
            else
                viewState.showError(textKey = R.string.login_error_credentials)
        }, 500)

    }

    fun loginVk(requestCode: Int, resultCode: Int, data: Intent?): Boolean {
        if (!VK.onActivityResult(requestCode, resultCode, data, object : VKAuthCallback {
                override fun onLogin(token: VKAccessToken) {
                    viewState.openFriends()
                }

                override fun onLoginFailed(authException: VKAuthException) {
                    viewState.showError(textKey = R.string.login_error_credentials)
                }

            })) {
            return false
        }
        return true
    }


}
