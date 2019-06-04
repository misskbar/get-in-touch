package com.karenbarreto.data.network

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeService
@Inject constructor(retrofit: Retrofit) : PruebaAPI {
    private val pruebaApi by lazy { retrofit.create(PruebaAPI::class.java) }

    override fun repositories() = pruebaApi.repositories()
}
