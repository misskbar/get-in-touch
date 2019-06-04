package com.codesign.karenbarreto.getintouch.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.codesign.karenbarreto.getintouch.adapters.RepositoryView
import com.codesign.karenbarreto.getintouch.core.helpers.UseCase
import com.codesign.karenbarreto.getintouch.base.BaseViewModel
import com.karenbarreto.domain.entities.Repository
import com.karenbarreto.domain.usecases.GetHome
import javax.inject.Inject

class HomeViewModel
@Inject constructor(private val getHome: GetHome) : BaseViewModel() {

    var data: MutableLiveData<List<RepositoryView>> = MutableLiveData()

    fun loadData() = getHome(UseCase.None()) { it.either(::handleFailure, ::handleData) }

    private fun handleData(data: List<Repository>) {
        this.data.value = data.map { RepositoryView(it.repositoryName, it.description, it.forks, it.stars) }
    }
}

