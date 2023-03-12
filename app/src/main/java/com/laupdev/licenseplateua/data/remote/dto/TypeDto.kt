package com.laupdev.licenseplateua.data.remote.dto

import com.laupdev.licenseplateua.domain.model.Type
import com.squareup.moshi.Json

data class TypeDto(
    @Json(name = "id") val id: Int?,
    @Json(name = "ua") val nameUa: String?,
    @Json(name = "ru") val nameRu: String?,
    @Json(name = "slug") val slug: String?,
) {
    fun toType(): Type =
        Type(
            nameUa = nameUa ?: "",
            nameRu = nameRu ?: "",
            slug = slug ?: "",
        )
}