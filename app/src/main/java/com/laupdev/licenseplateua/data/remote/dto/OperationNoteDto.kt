package com.laupdev.licenseplateua.data.remote.dto

import com.squareup.moshi.Json

data class OperationNoteDto(
    @Json(name = "ua") val noteUa: String?,
    @Json(name = "ru") val noteRu: String?,
)