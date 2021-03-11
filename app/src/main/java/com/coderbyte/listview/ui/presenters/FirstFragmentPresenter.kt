package com.coderbyte.listview.ui.presenters

import com.coderbyte.listview.networking.UserHandler
import com.coderbyte.listview.pojo.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragmentPresenter {

    fun getUserList(presenter:UserPresenter){
        UserHandler.getUserList(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful && response.body()!=null) {
                    presenter.onSuccess(response.body()!!)
                }else{
                    presenter.onFailure(response.code())
                }
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                presenter.onFailure(t.message);
            }

        })
    }

    interface UserPresenter{
        fun onSuccess(userList:List<User>)
        fun onFailure(msg:String?)
        fun onFailure(code:Int)
    }
}