package com.laupdev.licenseplateua.domain.repository

import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.domain.model.LicensePlateMainInfo
import com.laupdev.licenseplateua.util.Resource
import kotlinx.coroutines.flow.Flow

interface LicensePlatesRepository {

    fun getLicensePlateInfo(licensePlate: String): Flow<Resource<LicensePlateInfo>>

    fun getLicensePlatesSearchHistory(): Flow<Resource<List<LicensePlateMainInfo>>>

    fun insertLicensePlateMainInfoToDatabase(licensePlateInfo: LicensePlateInfo): Long

    fun updateLicensePlateMainInfoInDatabase(licensePlateInfo: LicensePlateInfo)

    fun getLicensePlateInfoByPlateNumber(plateNumber: String): LicensePlateMainInfo?
}