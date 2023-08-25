package com.laupdev.licenseplateua.domain.usecases

import com.laupdev.licenseplateua.di.IoDispatcher
import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.domain.repository.LicensePlatesRepository
import com.laupdev.licenseplateua.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetLicensePlateInfoUseCaseImpl @Inject constructor(
    private val licensePlatesRepository: LicensePlatesRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {

    operator fun invoke(licensePlate: String): Flow<Resource<LicensePlateInfo>> {
        return licensePlatesRepository.getLicensePlateInfo(licensePlate).flowOn(dispatcher)
    }
}