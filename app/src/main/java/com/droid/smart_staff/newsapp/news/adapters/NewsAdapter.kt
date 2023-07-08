package com.droid.smart_staff.newsapp.news.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.droid.smart_staff.newsapp.news.models.NewsDataItem
import com.example.newsapp.R
import com.example.newsapp.databinding.RowNewsItemBindingBinding

internal class NewsAdapter(
    private var selectedNews: ArrayList<NewsDataItem>,
    private var context: Context,
    private var mOnSelectedListenerCallback: OnNewsSelectedListenerCallback
) :
    RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder>() {

    inner class NewsItemViewHolder(private val newsBinding: RowNewsItemBindingBinding) :
        RecyclerView.ViewHolder(newsBinding.root) {

        fun bind(newsSource: NewsDataItem) {
            newsBinding.apply {
                Glide.with(context)
                    .load(newsSource.imageUrl)
                    .placeholder(R.drawable.news_random)
                    .into(ivNewsImage)
                tvTitle.text = newsSource.title
                tvSubtitle.text = newsSource.subtitle
                val isBookMarked = newsSource.isBookmarked
                ivCtaBookmark.setOnClickListener {
                    selectedNews[adapterPosition].isBookmarked = isBookMarked?.not()
                    mOnSelectedListenerCallback.onSelected(adapterPosition)
                }
                if (newsSource.isBookmarked!!) {
                    ivCtaBookmark.setImageResource(R.drawable.ic_bookmark)
                    ivCtaBookmark.imageTintList = ContextCompat.getColorStateList(
                        context,
                        R.color.book_mark_color
                    )
                } else {
                    ivCtaBookmark.setImageResource(R.drawable.ic_bookmark_border)
                    ivCtaBookmark.imageTintList = ContextCompat.getColorStateList(
                        context,
                        R.color.book_mark_color
                    )
                }
                root.setOnClickListener {

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val newsBinding = RowNewsItemBindingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsItemViewHolder(newsBinding)
    }


    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        val dealsItemModel = selectedNews[position]
        holder.bind(dealsItemModel)
    }

    override fun getItemCount(): Int {
        return selectedNews.size
    }

    fun addItemAtLast(newsModel: NewsDataItem) {
        selectedNews.add(newsModel)
        notifyItemInserted(selectedNews.size - 1)
    }

    fun setNewsItems(newsFeedItems: ArrayList<NewsDataItem>) {
        this.selectedNews.clear()
        this.selectedNews.addAll(newsFeedItems)
        this.notifyDataSetChanged()
    }

}

interface OnNewsSelectedListenerCallback {
    fun onSelected(position: Int)
}