package com.laupdev.licenseplateua.data.remote.dto

import com.squareup.moshi.Json

data class RegionDto(
    @Json(name = "name_ua") val nameUa: String?,
    @Json(name = "name") val nameRu: String?,
    @Json(name = "new_code") val newCode: String?,
    @Json(name = "old_code") val oldCode: String?,
    @Json(name = "slug") val slug: String?,
)