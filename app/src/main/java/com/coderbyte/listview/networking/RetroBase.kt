package com.coderbyte.listview.networking

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetroBase {
    companion object {
        var retrofit : Retrofit? = null

        fun create(): APIUser {
            if (retrofit == null) {

                retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .build()

                return retrofit!!.create(APIUser::class.java)
            }else
                return retrofit!!.create(APIUser::class.java)

        }
    }
}