package com.laupdev.licenseplateua.data.repository

import com.laupdev.licenseplateua.data.remote.LicensePlateApi
import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.domain.repository.LicensePlateRepository
import com.laupdev.licenseplateua.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LicensePlateRepositoryImpl @Inject constructor(
    private val api: LicensePlateApi
) : LicensePlateRepository {

    override fun getLicensePlateInfo(licensePlate: String): Flow<Resource<LicensePlateInfo>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            val licensePlateInfoResponse = api.getLicensePlateInfoByLicensePlate(licensePlate = licensePlate)
            if (licensePlateInfoResponse.isSuccessful) {
                val licensePlateInfo = licensePlateInfoResponse.body()?.toLicensePlateInfo()

                if (licensePlateInfo == null) {
                    emit(Resource.Error("License plate info is empty")) //TODO: Add to strings.xml
                } else {
                    emit(Resource.Success(data = licensePlateInfo))
                }
            } else {
                val errorMessage = licensePlateInfoResponse.errorBody()?.string() ?: "Undefined error" //TODO: Add to strings.xml
                licensePlateInfoResponse.errorBody()?.close()
                emit(Resource.Error(message = errorMessage))
            }
        }
    }

}