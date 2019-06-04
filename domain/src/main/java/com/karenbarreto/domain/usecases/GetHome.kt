package com.karenbarreto.domain.usecases

import com.codesign.karenbarreto.getintouch.core.helpers.UseCase
import com.karenbarreto.domain.entities.Repository
import com.karenbarreto.domain.repositories.HomeRepository
import javax.inject.Inject

class GetHome
@Inject constructor(private val homeRepository: HomeRepository) : UseCase<List<Repository>, UseCase.None>() {

    override suspend fun run(params: UseCase.None) = homeRepository.home()

}
