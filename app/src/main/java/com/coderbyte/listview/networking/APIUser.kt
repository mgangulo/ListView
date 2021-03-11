package com.coderbyte.listview.networking

import com.coderbyte.listview.pojo.User
import retrofit2.Call
import retrofit2.http.GET

interface APIUser {
    @GET("users")
    fun getUserList(): Call<List<User>>
}