package com.laupdev.licenseplateua.domain.usecases

import com.laupdev.licenseplateua.domain.model.LicensePlateMainInfo
import com.laupdev.licenseplateua.domain.repository.LicensePlatesRepository
import com.laupdev.licenseplateua.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetLicensePlatesSearchHistoryUseCaseImpl @Inject constructor(
    private val licensePlatesRepository: LicensePlatesRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : GetLicensePlatesSearchHistoryUseCase {
    override fun invoke(): Flow<Resource<List<LicensePlateMainInfo>>> {
        return licensePlatesRepository.getLicensePlatesSearchHistory().flowOn(dispatcher)
    }
}