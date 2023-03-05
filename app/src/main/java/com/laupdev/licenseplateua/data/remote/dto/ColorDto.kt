package com.laupdev.licenseplateua.data.remote.dto

import com.squareup.moshi.Json

data class ColorDto(
    @Json(name = "ua") val nameUa: String?,
    @Json(name = "ru") val nameRu: String?,
    @Json(name = "slug") val nameSlug: String?,
)