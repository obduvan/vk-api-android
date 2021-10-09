package com.example.kotlin_vezdecode.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.kotlin_vezdecode.R
import com.example.kotlin_vezdecode.presenters.LoginPresenter
import com.example.kotlin_vezdecode.views.LoginView
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.utils.VKUtils
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class LoginActivity : MvpAppCompatActivity(), LoginView{
    private lateinit var button_10: Button

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
//
//        val fingerprints = VKUtils.getCertificateFingerprint(this, this.getPackageName())!!
//        Log.e("TAG", fingerprints[0].toString())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        button_10 = findViewById(R.id.button_10)
        button_10.setOnClickListener {
            VK.login(this@LoginActivity, listOf(VKScope.FRIENDS))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
       if (!loginPresenter.loginVk(requestCode=requestCode, resultCode = resultCode, data=data))
           super.onActivityResult(requestCode, resultCode, data)
    }

    override fun showError(textKey: Int) {
        Toast.makeText(applicationContext, getString(textKey), Toast.LENGTH_SHORT).show()
    }

    override fun openFriends() {
        startActivity(Intent(applicationContext, FriendsActivity::class.java))
    }

    override fun startLoading() {
        TODO("Not yet implemented")
    }

    override fun endLoading() {
        TODO("Not yet implemented")
    }

}