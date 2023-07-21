package com.laupdev.licenseplateua.data.mappers

import com.laupdev.licenseplateua.data.local.entities.license_plate.LicensePlateMainInfoEntity
import com.laupdev.licenseplateua.data.remote.dto.LicensePlateInfoDto
import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.domain.model.LicensePlateMainInfo

fun LicensePlateInfo.toLicensePlateMainInfoEntity(): LicensePlateMainInfoEntity =
    LicensePlateMainInfoEntity(
        plateNumber = plateNumber,
        carVendor = carVendor,
        carModel = carModel,
        carModelYear = carModelYear,
        carPhotoUrl = carPhotoUrl,
        isCarStolen = isCarStolen
    )

fun LicensePlateInfoDto.toLicensePlateInfo(): LicensePlateInfo =
    LicensePlateInfo(
        plateNumber = plateNumber ?: "",
        vin = vin ?: "",
        carVendor = carVendor ?: "",
        carModel = carModel ?: "",
        carModelYear = carModelYear,
        carPhotoUrl = carPhotoUrl,
        operations = operations?.map { it.toOperation() },
        region = region?.toRegion(),
        isCarStolen = isCarStolen,
        comments = comments?.map { it.toComment() }
    )

fun LicensePlateMainInfoEntity.toLicensePlateMainInfo(): LicensePlateMainInfo =
    LicensePlateMainInfo(
        plateNumber = plateNumber,
        carVendor = carVendor,
        carModel = carModel,
        carModelYear = carModelYear,
        carPhotoUrl = carPhotoUrl,
        isCarStolen = isCarStolen
    )