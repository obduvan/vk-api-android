package com.example.vk_api_android.activities


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vk_api_android.R
import com.example.vk_api_android.adapters.FriendsAdapter
import com.example.vk_api_android.models.FriendModel
import com.example.vk_api_android.presenters.FriendsPresenter
import com.example.vk_api_android.views.FriendsView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class FriendsActivity : MvpAppCompatActivity(), FriendsView {

    private lateinit var friendAdapter: FriendsAdapter
    private lateinit var tvSearchError: TextView
    private lateinit var rvFriends: RecyclerView

    @InjectPresenter
    lateinit var friendsPresenter: FriendsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_friends)

        rvFriends = findViewById(R.id.friends_RV)
        tvSearchError = findViewById(R.id.txt_search_error)

        val etSearchField: AppCompatEditText = findViewById(R.id.search_field)
        etSearchField.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                    friendAdapter.filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })


        friendsPresenter.loadFriends()

        friendAdapter = FriendsAdapter()
        rvFriends.adapter = friendAdapter
        rvFriends.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        rvFriends.setHasFixedSize(true)
    }

    override fun setFriendsList(friendsList: ArrayList<FriendModel>) {
        tvSearchError.visibility = View.GONE
        rvFriends.visibility = View.VISIBLE

        friendAdapter.setupFriends(friendsListFromPres=friendsList)
    }

    override fun setEmptyList() {
        rvFriends.visibility = View.GONE
        tvSearchError.visibility = View.VISIBLE
    }

    override fun showError(textKey: Int) {
        tvSearchError.text = getString(textKey)


    }

    override fun startLoading() {

    }

    override fun endLoading() {

    }

}

