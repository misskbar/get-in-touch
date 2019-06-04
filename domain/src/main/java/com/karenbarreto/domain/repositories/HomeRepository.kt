package com.karenbarreto.domain.repositories

import com.codesign.karenbarreto.getintouch.core.helpers.Either
import com.codesign.karenbarreto.getintouch.core.helpers.Either.*
import com.codesign.karenbarreto.getintouch.core.helpers.Failure
import com.codesign.karenbarreto.getintouch.core.helpers.Failure.*
import com.codesign.karenbarreto.getintouch.core.helpers.NetworkHandler
import com.karenbarreto.domain.entities.Repository
import javax.inject.Inject
import retrofit2.Call

interface HomeRepository {
    fun home(): Either<Failure, List<Repository>>
}