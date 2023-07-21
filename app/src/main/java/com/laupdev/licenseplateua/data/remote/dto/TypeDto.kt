package com.laupdev.licenseplateua.data.remote.dto

import com.squareup.moshi.Json

data class TypeDto(
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "ua") val nameUa: String?,
    @field:Json(name = "ru") val nameRu: String?,
    @field:Json(name = "slug") val slug: String?,
)