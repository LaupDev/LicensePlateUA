package com.laupdev.licenseplateua.data.remote.dto

import com.squareup.moshi.Json

data class RegionDto(
    @field:Json(name = "name_ua") val nameUa: String?,
    @field:Json(name = "name") val nameRu: String?,
    @field:Json(name = "new_code") val newCode: String?,
    @field:Json(name = "old_code") val oldCode: String?,
    @field:Json(name = "slug") val slug: String?,
)