package com.laupdev.licenseplateua.data.remote.dto

import com.laupdev.licenseplateua.domain.model.Color
import com.squareup.moshi.Json

data class ColorDto(
    @Json(name = "ua") val nameUa: String?,
    @Json(name = "ru") val nameRu: String?,
    @Json(name = "slug") val nameSlug: String?,
) {
    fun toColor(): Color =
        Color(
            nameUa = nameUa ?: "",
            nameRu = nameRu ?: "",
            nameSlug = nameSlug ?: "",
        )
}