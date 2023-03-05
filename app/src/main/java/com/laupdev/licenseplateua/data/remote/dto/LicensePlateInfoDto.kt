package com.laupdev.licenseplateua.data.remote.dto

import com.squareup.moshi.Json

data class LicensePlateInfoDto(
    @Json(name = "digits") val plateNumber: String?,
    @Json(name = "vin") val vin: String?,
    @Json(name = "vendor") val carVendor: String?,
    @Json(name = "model") val carModel: String?,
    @Json(name = "model_year") val carModelYear: Int?,
    @Json(name = "photo_url") val carPhotoUrl: String?,
    @Json(name = "operations") val operations: List<OperationDto>?,
    @Json(name = "region") val region: RegionDto?,
    @Json(name = "is_stolen") val isCarStolen: Boolean?,
    @Json(name = "stolen_details") val stolenDetails: Any?, // TODO: Add stolenDetails
    @Json(name = "comments") val comments: List<CommentDto>?,
)