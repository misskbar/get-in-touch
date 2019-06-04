package com.karenbarreto.data.network

import com.codesign.karenbarreto.getintouch.core.helpers.Either
import com.codesign.karenbarreto.getintouch.core.helpers.Either.*
import com.codesign.karenbarreto.getintouch.core.helpers.Failure
import com.codesign.karenbarreto.getintouch.core.helpers.Failure.*
import com.codesign.karenbarreto.getintouch.core.helpers.NetworkHandler
import com.karenbarreto.domain.entities.Repository
import com.karenbarreto.domain.repositories.HomeRepository
import javax.inject.Inject
import retrofit2.Call

class HomeDataRepository
@Inject constructor(private val networkHandler: NetworkHandler,
                    private val service: HomeService) : HomeRepository {

    override fun home(): Either<Failure, List<Repository>> {
        return when (networkHandler.isConnected) {
            true -> request(service.repositories(), { it.map { Repository(it.repositoryName, it.description, it.forks, it.stars) } }, emptyList())
            false, null -> Left(NetworkConnection())
        }
    }

    private fun <T, R> request(call: Call<T>, transform: (T) -> R, default: T): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Right(transform((response.body() ?: default)))
                false -> Left(ServerError())
            }
        } catch (exception: Throwable) {
            Left(ServerError())
        }
    }
}