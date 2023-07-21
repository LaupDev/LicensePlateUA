package com.laupdev.licenseplateua.domain.usecases

import com.laupdev.licenseplateua.domain.model.LicensePlateMainInfo
import com.laupdev.licenseplateua.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetLicensePlatesSearchHistoryUseCase {
    operator fun invoke(): Flow<Resource<List<LicensePlateMainInfo>>>
}