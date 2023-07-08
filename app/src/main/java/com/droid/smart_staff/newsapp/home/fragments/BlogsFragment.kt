package com.droid.smart_staff.newsapp.home.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.droid.smart_staff.newsapp.blogs.adapters.BlogsAdapter
import com.droid.smart_staff.newsapp.blogs.adapters.OnBlogsSelectedListenerCallback
import com.droid.smart_staff.newsapp.news.models.NewsDataItem
import com.droid.smart_staff.newsapp.news.utils.NewsViewModel
import com.example.newsapp.databinding.FragmentBlogsBinding


class BlogsFragment : Fragment() {
    private lateinit var binding: FragmentBlogsBinding
    private var newsList: ArrayList<NewsDataItem> = arrayListOf()
    private lateinit var mNewsAdapter: BlogsAdapter
    private val newsViewModel: NewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentBlogsBinding.inflate(layoutInflater).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newsLiveDataObserver()
        bookmarkLiveDataObserver()
        binding.pullToRefresh.isRefreshing = true
        newsViewModel.fetchBlogs()
        setUpRecyclerView()
        binding.pullToRefresh.setOnRefreshListener {
            binding.pullToRefresh.isRefreshing = true
            newsViewModel.fetchBlogs()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun bookmarkLiveDataObserver() {
        newsViewModel.getBookmarkStatusLiveData().observe(viewLifecycleOwner) {
            binding.pullToRefresh.isRefreshing = false
            if (!it.success) return@observe
            mNewsAdapter.notifyDataSetChanged()
            Toast.makeText(requireContext(), it.data?.data?.message, Toast.LENGTH_SHORT).show()
        }
    }

    private fun newsLiveDataObserver() {
        newsViewModel.getBlogsLiveData().observe(viewLifecycleOwner) {
            binding.pullToRefresh.isRefreshing = false
            if (!it.success) return@observe
            if (it.data?.data == null) return@observe
            newsList = it.data.data as ArrayList<NewsDataItem>
            mNewsAdapter.setNewsItems(newsList)
        }
    }

    private fun setUpRecyclerView() {
        mNewsAdapter = BlogsAdapter(
            newsList,
            requireContext(),
            object : OnBlogsSelectedListenerCallback {
                override fun onSelected(position: Int) {
                    binding.pullToRefresh.isRefreshing = true
                    newsViewModel.fetchBookmarkStatus(position, "blog")
                }

            })
        binding.rvNews.apply {
            adapter = mNewsAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    companion object {
        val TAG2: String? = BlogsFragment::class.java.canonicalName

        @JvmStatic
        fun newInstance() =
            BlogsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}