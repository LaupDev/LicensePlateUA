package com.laupdev.licenseplateua.data.remote.dto

import com.laupdev.licenseplateua.domain.model.OperationGroup
import com.squareup.moshi.Json

data class OperationGroupDto(
    @Json(name = "id") val id: Int?,
    @Json(name = "ua") val nameUa: String?,
    @Json(name = "ru") val nameRu: String?,
) {
    fun toOperationGroup(): OperationGroup =
        OperationGroup(
            nameUa = nameUa ?: "",
            nameRu = nameRu ?: "",
        )
}