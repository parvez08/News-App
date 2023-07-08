package com.droid.smart_staff.newsapp.news.utils

import com.droid.smart_staff.newsapp.news.models.BookmarksResponseModel
import com.droid.smart_staff.newsapp.news.models.NewsResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIInterface {
    @GET("b6373856-7f26-42ba-9915-4451ef7c6654")
    fun getNews(): Call<NewsResponseModel>

    @GET("60c29811-821d-4dac-843c-f5720dd121af")
    fun getBlogs(): Call<NewsResponseModel>

    @GET("263f8919-8167-4732-b40d-07e458e29063")
    fun getBookmarkStatus(
        @Query("id") id: Int,
        @Query("type") type: String
    ): Call<BookmarksResponseModel>
}