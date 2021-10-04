package com.example.kotlin_vezdecode.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.kotlin_vezdecode.R
import com.example.kotlin_vezdecode.presenters.LoginPresenter
import com.example.kotlin_vezdecode.views.LoginView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class LoginActivity : MvpAppCompatActivity(), LoginView{
    private lateinit var button_10: Button

    @InjectPresenter
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)


        button_10 = findViewById(R.id.button_10)


        button_10.setOnClickListener {
            loginPresenter.login(isSuccess = true)

        }
    }
    override fun showError(keyText: Int) {
        Toast.makeText(applicationContext, getString(keyText), Toast.LENGTH_SHORT).show()
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