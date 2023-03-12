package com.laupdev.licenseplateua.data.remote.dto

import com.laupdev.licenseplateua.domain.model.OperationNote
import com.squareup.moshi.Json

data class OperationNoteDto(
    @Json(name = "ua") val noteUa: String?,
    @Json(name = "ru") val noteRu: String?,
) {
    fun toOperationNote(): OperationNote =
        OperationNote(
            noteUa = noteUa ?: "",
            noteRu = noteRu ?: "",
        )
}