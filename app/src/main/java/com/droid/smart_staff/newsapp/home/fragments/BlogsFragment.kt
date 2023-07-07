package com.droid.smart_staff.newsapp.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.databinding.FragmentBlogsBinding


class BlogsFragment : Fragment() {
    private lateinit var binding: FragmentBlogsBinding

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