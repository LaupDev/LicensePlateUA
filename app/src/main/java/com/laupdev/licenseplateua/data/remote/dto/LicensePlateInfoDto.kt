package com.laupdev.licenseplateua.data.remote.dto

import com.squareup.moshi.Json

data class LicensePlateInfoDto(
    @field:Json(name = "digits") val plateNumber: String?,
    @field:Json(name = "vin") val vin: String?,
    @field:Json(name = "vendor") val carVendor: String?,
    @field:Json(name = "model") val carModel: String?,
    @field:Json(name = "model_year") val carModelYear: Int?,
    @field:Json(name = "photo_url") val carPhotoUrl: String?,
    @field:Json(name = "operations") val operations: List<OperationDto>?,
    @field:Json(name = "region") val region: RegionDto?,
    @field:Json(name = "is_stolen") val isCarStolen: Boolean?,
    @field:Json(name = "stolen_details") val stolenDetails: Any?, // TODO: Add stolenDetails
    @field:Json(name = "comments") val comments: List<CommentDto>?,
)