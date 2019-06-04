package com.karenbarreto.data.network

import com.karenbarreto.domain.entities.Repository
import retrofit2.Call
import retrofit2.http.GET


internal interface PruebaAPI {
    companion object {
        private const val REPOSITORIES = "repositories.json"
    }

    @GET(REPOSITORIES) fun repositories(): Call<List<Repository>>
}
