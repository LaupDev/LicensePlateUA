package com.laupdev.licenseplateua.data.repository

import com.laupdev.licenseplateua.data.remote.LicensePlateApi
import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.domain.repository.LicensePlateRepository
import com.laupdev.licenseplateua.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
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
                    emit(Resource.Error(exception = Exception("License plate info is empty")))
                } else {
                    emit(Resource.Success(data = licensePlateInfo))
                    emit(Resource.Loading(isLoading = false))
                }
            } else {
                val errorMessage = licensePlateInfoResponse.errorBody()?.string() ?: "Undefined error"
                licensePlateInfoResponse.errorBody()?.close()
                emit(Resource.Error(exception = Exception(errorMessage))) //Todo: Handle all possible error codes
            }
        }
    }

}