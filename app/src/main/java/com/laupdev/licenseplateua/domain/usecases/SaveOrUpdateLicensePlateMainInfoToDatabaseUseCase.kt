package com.laupdev.licenseplateua.domain.usecases

import com.laupdev.licenseplateua.di.IoDispatcher
import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.domain.repository.LicensePlatesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveOrUpdateLicensePlateMainInfoToDatabaseUseCase @Inject constructor(
    private val licensePlatesRepository: LicensePlatesRepository,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(licensePlateInfo: LicensePlateInfo) {
        withContext(dispatcher) {
            val licensePlateMainInfo =
                licensePlatesRepository.getLicensePlateInfoByPlateNumber(licensePlateInfo.plateNumber)
            if (licensePlateMainInfo == null) {
                licensePlatesRepository.insertLicensePlateMainInfoToDatabase(licensePlateInfo)
            } else {
                licensePlatesRepository.updateLicensePlateMainInfoInDatabase(licensePlateInfo)
            }
        }
    }
}