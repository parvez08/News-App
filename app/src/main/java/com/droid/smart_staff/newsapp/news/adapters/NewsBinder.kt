package com.droid.smart_staff.newsapp.news.adapters

import com.droid.smart_staff.newsapp.news.models.NewsDataItem
import com.example.newsapp.databinding.RowNewsItemBindingBinding

object NewsBinder {
    fun bindNewsData(rowBinding: RowNewsItemBindingBinding, rowData: NewsDataItem?) {
        rowBinding.tvTitle.text = rowData?.id.toString()
    }
}