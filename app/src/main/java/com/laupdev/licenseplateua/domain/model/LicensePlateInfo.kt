package com.laupdev.licenseplateua.domain.model

data class LicensePlateInfo(
    val plateNumber: String,
    val vin: String,
    val carVendor: String,
    val carModel: String,
    val carModelYear: Int,
    val carPhotoUrl: String,
    val operations: List<Operation>,
    val region: Region,
    val isCarStolen: Boolean,
    val stolenDetails: Any, // TODO: Add stolenDetails
    val comments: List<Comment>?,
)