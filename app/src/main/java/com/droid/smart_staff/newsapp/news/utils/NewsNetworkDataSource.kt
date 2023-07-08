package com.droid.smart_staff.newsapp.news.utils

import androidx.lifecycle.MutableLiveData
import com.droid.smart_staff.newsapp.news.models.BookmarksResponseModel
import com.droid.smart_staff.newsapp.news.models.NewsResponseModel
import com.droid.smart_staff.newsapp.utils.GenericResponse
import com.droid.smart_staff.newsapp.utils.RestAPIClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsNetworkDataSource {

    fun fetchNews(
        data: MutableLiveData<GenericResponse<NewsResponseModel>>
    ) = RestAPIClass().getClient().create(NewsAPIInterface::class.java)
        .getNews()
        .enqueue(object : Callback<NewsResponseModel> {
            override fun onResponse(
                call: Call<NewsResponseModel>,
                response: Response<NewsResponseModel>
            ) {
                if (response.isSuccessful) {
                    data.value =
                        GenericResponse(
                            response.body(),
                            true,
                            null
                        )
                } else {
                    data.value = GenericResponse(
                        null,
                        false,
                        response.message()
                    )
                }
            }

            override fun onFailure(call: Call<NewsResponseModel>, t: Throwable) {
                data.value = GenericResponse(
                    null,
                    false,
                    t.message
                )
            }

        })

    fun fetchBlogs(
        data: MutableLiveData<GenericResponse<NewsResponseModel>>
    ) = RestAPIClass().getClient().create(NewsAPIInterface::class.java)
        .getBlogs()
        .enqueue(object : Callback<NewsResponseModel> {
            override fun onResponse(
                call: Call<NewsResponseModel>,
                response: Response<NewsResponseModel>
            ) {
                if (response.isSuccessful) {
                    data.value =
                        GenericResponse(
                            response.body(),
                            true,
                            null
                        )
                } else {
                    data.value = GenericResponse(
                        null,
                        false,
                        response.message()
                    )
                }
            }

            override fun onFailure(call: Call<NewsResponseModel>, t: Throwable) {
                data.value = GenericResponse(
                    null,
                    false,
                    t.message
                )
            }

        })

    fun fetchBookmarkStatus(
        id: Int,
        type: String,
        data: MutableLiveData<GenericResponse<BookmarksResponseModel>>
    ) = RestAPIClass().getClient().create(NewsAPIInterface::class.java)
        .getBookmarkStatus(id, type)
        .enqueue(object : Callback<BookmarksResponseModel> {
            override fun onResponse(
                call: Call<BookmarksResponseModel>,
                response: Response<BookmarksResponseModel>
            ) {
                if (response.isSuccessful) {
                    data.value =
                        GenericResponse(
                            response.body(),
                            true,
                            null
                        )
                } else {
                    data.value = GenericResponse(
                        null,
                        false,
                        response.message()
                    )
                }
            }

            override fun onFailure(call: Call<BookmarksResponseModel>, t: Throwable) {
                data.value = GenericResponse(
                    null,
                    false,
                    t.message
                )
            }

        })
}