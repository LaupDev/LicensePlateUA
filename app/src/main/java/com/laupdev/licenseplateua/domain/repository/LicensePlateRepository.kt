package com.laupdev.licenseplateua.domain.repository

import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.util.Resource
import kotlinx.coroutines.flow.Flow

interface LicensePlateRepository {

    fun getLicensePlateInfo(licensePlate: String): Flow<Resource<LicensePlateInfo>>
}