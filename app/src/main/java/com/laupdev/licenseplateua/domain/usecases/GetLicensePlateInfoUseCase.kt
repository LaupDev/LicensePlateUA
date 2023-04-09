package com.laupdev.licenseplateua.domain.usecases

import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetLicensePlateInfoUseCase {
    fun execute(licensePlate: String): Flow<Resource<LicensePlateInfo>>
}