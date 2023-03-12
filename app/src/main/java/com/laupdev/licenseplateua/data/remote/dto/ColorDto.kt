package com.laupdev.licenseplateua.data.remote.dto

import com.laupdev.licenseplateua.domain.model.Color
import com.squareup.moshi.Json

data class ColorDto(
    @field:Json(name = "ua") val nameUa: String?,
    @field:Json(name = "ru") val nameRu: String?,
    @field:Json(name = "slug") val nameSlug: String?,
) {
    fun toColor(): Color =
        Color(
            nameUa = nameUa ?: "",
            nameRu = nameRu ?: "",
            nameSlug = nameSlug ?: "",
        )
}