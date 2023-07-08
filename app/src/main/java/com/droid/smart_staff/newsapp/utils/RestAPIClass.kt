package com.droid.smart_staff.newsapp.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestAPIClass {
    private lateinit var retrofit: Retrofit
    private val baseUrl = "https://www.mocki.io/v1/"

    fun getClient(): Retrofit {
        retrofit = Retrofit
            .Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }
}
