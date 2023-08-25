package com.laupdev.licenseplateua.domain.usecases

import com.laupdev.licenseplateua.di.IoDispatcher
import com.laupdev.licenseplateua.domain.model.LicensePlateMainInfo
import com.laupdev.licenseplateua.domain.repository.LicensePlatesRepository
import com.laupdev.licenseplateua.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetLicensePlatesSearchHistoryUseCaseImpl @Inject constructor(
    private val licensePlatesRepository: LicensePlatesRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    operator fun invoke(): Flow<Resource<List<LicensePlateMainInfo>>> {
        return licensePlatesRepository.getLicensePlatesSearchHistory().flowOn(dispatcher)
    }
}