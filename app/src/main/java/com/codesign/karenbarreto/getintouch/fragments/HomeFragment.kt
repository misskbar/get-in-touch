package com.codesign.karenbarreto.getintouch.fragments

import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.codesign.karenbarreto.getintouch.R
import com.codesign.karenbarreto.getintouch.adapters.HomeListAdapter
import com.codesign.karenbarreto.getintouch.adapters.RepositoryView
import com.codesign.karenbarreto.getintouch.core.helpers.Failure
import com.codesign.karenbarreto.getintouch.core.helpers.observe
import com.codesign.karenbarreto.getintouch.core.helpers.*
import com.codesign.karenbarreto.getintouch.base.BaseFragment
import com.codesign.karenbarreto.getintouch.base.viewModel
import com.codesign.karenbarreto.getintouch.viewmodel.HomeViewModel
import com.karenbarreto.core.helpers.invisible
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class HomeFragment() : BaseFragment() {

    @Inject
    lateinit var homeListAdapter: HomeListAdapter

    override fun layoutId() = R.layout.fragment_main

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)

        homeViewModel = viewModel(viewModelFactory) {
            observe(data, :: renderMoviesList)
            failure(failure, ::handleFailure)
        }
    }

    private fun renderMoviesList(repositories: List<RepositoryView>?) {
        homeListAdapter.collection = repositories.orEmpty()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.loadData()

        homeList.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        homeList.adapter = homeListAdapter
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.NetworkConnection -> renderFailure("Fallo 1")
            is Failure.ServerError -> renderFailure("Fallo 2")
        }
    }

    private fun renderFailure(message: String) {
        homeList.invisible()
    }

}

