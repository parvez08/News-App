package com.droid.smart_staff.newsapp.news.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.droid.smart_staff.newsapp.news.models.BookmarksResponseModel
import com.droid.smart_staff.newsapp.news.models.NewsResponseModel
import com.droid.smart_staff.newsapp.utils.GenericResponse

class NewsViewModel : ViewModel() {

    private val newsRepository: NewsRepository by lazy {
        NewsRepository()
    }

    private val newsLiveData: MutableLiveData<GenericResponse<NewsResponseModel>> by lazy {
        MutableLiveData<GenericResponse<NewsResponseModel>>()
    }

    private val blogsLiveData: MutableLiveData<GenericResponse<NewsResponseModel>> by lazy {
        MutableLiveData<GenericResponse<NewsResponseModel>>()
    }

    private val bookmarkStatusLiveData: MutableLiveData<GenericResponse<BookmarksResponseModel>> by lazy {
        MutableLiveData<GenericResponse<BookmarksResponseModel>>()
    }

    fun getBlogsLiveData(): LiveData<GenericResponse<NewsResponseModel>> =
        blogsLiveData

    fun getNewsLiveData(): LiveData<GenericResponse<NewsResponseModel>> =
        newsLiveData

    fun getBookmarkStatusLiveData(): LiveData<GenericResponse<BookmarksResponseModel>> =
        bookmarkStatusLiveData

    fun fetchNews() {
        newsRepository.fetchNews(newsLiveData)
    }

    fun fetchBlogs() {
        newsRepository.fetchBlogs(blogsLiveData)
    }

    fun fetchBookmarkStatus(id: Int, type: String) {
        newsRepository.fetchBookmarkStatus(id, type, bookmarkStatusLiveData)
    }
}