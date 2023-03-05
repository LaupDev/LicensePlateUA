package com.laupdev.licenseplateua.domain.repository

import com.laupdev.licenseplateua.domain.model.LicensePlateInfo

interface LicensePlateRepository {

    suspend fun getLicensePlateInfo(licensePlate: String): LicensePlateInfo
}