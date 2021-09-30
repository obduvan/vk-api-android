//package com.example.kotlin_vezdecode.activities
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import com.example.kotlin_vezdecode.R
//import com.vk.api.sdk.VK
//import com.vk.api.sdk.auth.VKAccessToken
//import com.vk.api.sdk.auth.VKAuthCallback
//import com.vk.api.sdk.auth.VKScope
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        Log.d("INFO", "login!")
//
//        VK.login(this, arrayListOf(VKScope.WALL, VKScope.PHOTOS))
//
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        val callback = object : VKAuthCallback {
//            override fun onLogin(token: VKAccessToken) {
//                VK.execute(VKUsersCommand(), object : VKApiCallback<List<VKUser>> {
//                    override fun success(result: List<VKUser>) {
//                        if (!isFinishing && !result.isEmpty()) {
//                            val nameTV = findViewById<TextView>(R.id.nameTV)
//                            val user = result[0]
//                            Log.d("INFO", user)
//                        }
//                    }
//                })
//
//            }
//
//            override fun onLoginFailed(errorCode: Int) {
//                // User didn't pass authorization
//            }
//        }
//        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
//            super.onActivityResult(requestCode, resultCode, data)
//        }
//    }
//
//
//}