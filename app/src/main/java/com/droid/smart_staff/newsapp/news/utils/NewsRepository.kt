package com.droid.smart_staff.newsapp.news.utils

import androidx.lifecycle.MutableLiveData
import com.droid.smart_staff.newsapp.news.models.BookmarksResponseModel
import com.droid.smart_staff.newsapp.news.models.NewsResponseModel
import com.droid.smart_staff.newsapp.utils.GenericResponse

class NewsRepository {

    private var newsNetworkDataSource: NewsNetworkDataSource = NewsNetworkDataSource()

    fun fetchNews(
        data: MutableLiveData<GenericResponse<NewsResponseModel>>
    ) = newsNetworkDataSource.fetchNews(data)

    fun fetchBlogs(
        data: MutableLiveData<GenericResponse<NewsResponseModel>>
    ) = newsNetworkDataSource.fetchBlogs(data)

    fun fetchBookmarkStatus(
        id: Int,
        type: String,
        data: MutableLiveData<GenericResponse<BookmarksResponseModel>>
    ) = newsNetworkDataSource.fetchBookmarkStatus(id, type, data)

}