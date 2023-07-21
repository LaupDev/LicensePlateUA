package com.laupdev.licenseplateua.data.remote.dto

import com.squareup.moshi.Json

data class OperationNoteDto(
    @field:Json(name = "ua") val noteUa: String?,
    @field:Json(name = "ru") val noteRu: String?,
)