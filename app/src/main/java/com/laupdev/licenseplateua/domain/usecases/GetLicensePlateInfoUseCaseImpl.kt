package com.laupdev.licenseplateua.domain.usecases

import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.domain.repository.LicensePlatesRepository
import com.laupdev.licenseplateua.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetLicensePlateInfoUseCaseImpl(
    private val licensePlatesRepository: LicensePlatesRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : GetLicensePlateInfoUseCase {

    override fun execute(licensePlate: String): Flow<Resource<LicensePlateInfo>> {
        return licensePlatesRepository.getLicensePlateInfo(licensePlate).flowOn(dispatcher)
    }
}