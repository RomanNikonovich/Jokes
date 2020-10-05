package com.example.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.R
import com.example.presentation.databinding.FragmentJokesBinding


class FragmentJokes : Fragment() {
    lateinit var viewModelFragmentJokes: ViewModelFragmentJokes
    lateinit var binding: FragmentJokesBinding
    lateinit var recyclerView: RecyclerView

    companion object {
        fun getInstance(fragmentManager: FragmentManager): FragmentJokes {
            val fragmentJokes: FragmentJokes? =
                fragmentManager.findFragmentByTag(FragmentJokes::class.simpleName) as? FragmentJokes

            return fragmentJokes ?: FragmentJokes()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelFragmentJokes =
            ViewModelProviders.of(this).get(ViewModelFragmentJokes::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_jokes, container, false)
        binding.viewModel = viewModelFragmentJokes
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.rvJokes
        recyclerView.adapter = viewModelFragmentJokes.adaptRV
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                view.context,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onResume() {
        super.onResume()
        binding.editJokes.setText("")
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModelFragmentJokes.onDestroy()
    }

}