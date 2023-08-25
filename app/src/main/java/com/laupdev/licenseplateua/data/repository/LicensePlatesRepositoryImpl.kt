package com.laupdev.licenseplateua.data.repository

import com.laupdev.licenseplateua.data.local.LicensePlatesDatabase
import com.laupdev.licenseplateua.data.mappers.toLicensePlateInfo
import com.laupdev.licenseplateua.data.mappers.toLicensePlateMainInfo
import com.laupdev.licenseplateua.data.mappers.toLicensePlateMainInfoEntity
import com.laupdev.licenseplateua.data.remote.LicensePlateApi
import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.domain.model.LicensePlateMainInfo
import com.laupdev.licenseplateua.domain.repository.LicensePlatesRepository
import com.laupdev.licenseplateua.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LicensePlatesRepositoryImpl @Inject constructor(
    private val api: LicensePlateApi,
    private val licensePlatesDatabase: LicensePlatesDatabase
) : LicensePlatesRepository {

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
                    licensePlatesDatabase.licensePlatesDao()
                        .insertLicensePlate(licensePlateInfo = licensePlateInfo.toLicensePlateMainInfoEntity()) // TODO: Move caching out of this function
                }
            } else {
                val errorMessage = licensePlateInfoResponse.errorBody()?.string() ?: "Undefined error"
                licensePlateInfoResponse.errorBody()?.close()
                emit(Resource.Error(exception = Exception(errorMessage))) //Todo: Handle all possible error codes
            }
        }
    }

    override fun getLicensePlatesSearchHistory(): Flow<Resource<List<LicensePlateMainInfo>>> {
        return flow {
            emit(Resource.Loading(isLoading = true))
            licensePlatesDatabase.licensePlatesDao().getAllLicensePlates()
                .catch { exception ->
                    emit(Resource.Error(exception = Exception(exception)))
                }
                .collect {
                    emit(Resource.Success(it.map { licensePlateMainInfoEntity -> licensePlateMainInfoEntity.toLicensePlateMainInfo() }))
                }
            emit(Resource.Loading(isLoading = false))
        }
    }
}