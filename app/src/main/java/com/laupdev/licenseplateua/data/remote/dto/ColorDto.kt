package com.laupdev.licenseplateua.data.remote.dto

import com.squareup.moshi.Json

data class ColorDto(
    @field:Json(name = "ua") val nameUa: String?,
    @field:Json(name = "ru") val nameRu: String?,
    @field:Json(name = "slug") val nameSlug: String?,
)