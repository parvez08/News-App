package com.droid.smart_staff.newsapp.news.models

import com.google.gson.annotations.SerializedName


data class BookmarksResponseModel(

    @field:SerializedName("data")
    val data: Data? = null,

    @field:SerializedName("status")
    val status: Int? = null
)

data class Data(

    @field:SerializedName("message")
    val message: String? = null
)
