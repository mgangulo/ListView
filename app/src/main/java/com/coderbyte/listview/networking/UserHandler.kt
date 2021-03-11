package com.coderbyte.listview.networking

import com.coderbyte.listview.pojo.User
import retrofit2.Callback

class UserHandler {
    companion object {
        fun getUserList(callback: Callback<List<User>>) {
            RetroBase.create().getUserList().enqueue(callback)
        }
    }
}