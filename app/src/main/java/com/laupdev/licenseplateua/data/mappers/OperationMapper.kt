package com.laupdev.licenseplateua.data.mappers

import com.laupdev.licenseplateua.data.remote.dto.OperationDto
import com.laupdev.licenseplateua.domain.model.Operation

fun OperationDto.toOperation(): Operation =
    Operation(
        address = address ?: "",
        carColor = carColor?.toColor(),
        department = department ?: "",
        isLast = isLast,
        isRegisteredToCompany = isRegisteredToCompany,
        type = type?.toType(),
        koatuu = koatuu ?: -1L,
        carModel = carModel ?: "",
        carModelYear = carModelYear ?: -1,
        operationNote = operationNote?.toOperationNote(),
        operationGroup = operationGroup?.toOperationGroup(),
        registeredAt = registeredAt ?: "",
        carVendor = carVendor ?: "",
        carVendorSlug = carVendorSlug ?: ""
    )