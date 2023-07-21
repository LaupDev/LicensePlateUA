package com.laupdev.licenseplateua.domain.model


data class LicensePlateMainInfo(
    val plateNumber: String,
    val carVendor: String,
    val carModel: String,
    val carModelYear: Int?,
    val carPhotoUrl: String?,
    val isCarStolen: Boolean?
)
