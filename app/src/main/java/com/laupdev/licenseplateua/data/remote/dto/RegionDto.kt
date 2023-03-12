package com.laupdev.licenseplateua.data.remote.dto

import com.laupdev.licenseplateua.domain.model.Region
import com.squareup.moshi.Json

data class RegionDto(
    @Json(name = "name_ua") val nameUa: String?,
    @Json(name = "name") val nameRu: String?,
    @Json(name = "new_code") val newCode: String?,
    @Json(name = "old_code") val oldCode: String?,
    @Json(name = "slug") val slug: String?,
) {
    fun toRegion(): Region =
        Region(
            nameUa = nameUa ?: "",
            nameRu = nameRu ?: "",
            newCode = newCode ?: "",
            oldCode = oldCode ?: "",
            slug = slug ?: "",
        )
}