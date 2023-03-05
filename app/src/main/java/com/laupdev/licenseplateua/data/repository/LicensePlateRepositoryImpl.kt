package com.laupdev.licenseplateua.data.repository

import com.laupdev.licenseplateua.data.remote.LicensePlateApi
import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.domain.repository.LicensePlateRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LicensePlateRepositoryImpl @Inject constructor(
    private val api: LicensePlateApi
) : LicensePlateRepository {

    override suspend fun getLicensePlateInfo(licensePlate: String): LicensePlateInfo {
        TODO("Not yet implemented")
    }

}