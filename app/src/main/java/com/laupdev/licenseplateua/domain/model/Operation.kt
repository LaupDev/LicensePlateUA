package com.laupdev.licenseplateua.domain.model

data class Operation(
    val address: String,
    val carColor: Color?,
    val department: String,
    val isLast: Boolean?,
    val isRegisteredToCompany: Boolean?,
    val type: Type?,
    val koatuu: Long,
    val carModel: String,
    val carModelYear: Int,
    val operationNote: OperationNote?,
    val operationGroup: OperationGroup?,
    val registeredAt: String,
    val carVendor: String,
    val carVendorSlug: String,
)