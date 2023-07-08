package com.droid.smart_staff.newsapp.news.models

import com.google.gson.annotations.SerializedName


data class NewsResponseModel(

    @field:SerializedName("data")
    val data: List<NewsDataItem?>? = null,

    @field:SerializedName("status")
    val status: Int? = null
)

data class NewsDataItem(

    @field:SerializedName("image_url")
    val imageUrl: String? = null,

    @field:SerializedName("is_bookmarked")
    var isBookmarked: Boolean? = null,

    @field:SerializedName("subtitle")
    val subtitle: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null
)
