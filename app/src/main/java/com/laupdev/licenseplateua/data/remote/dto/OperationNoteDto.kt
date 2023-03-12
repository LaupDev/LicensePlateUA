package com.laupdev.licenseplateua.data.remote.dto

import com.laupdev.licenseplateua.domain.model.OperationNote
import com.squareup.moshi.Json

data class OperationNoteDto(
    @field:Json(name = "ua") val noteUa: String?,
    @field:Json(name = "ru") val noteRu: String?,
) {
    fun toOperationNote(): OperationNote =
        OperationNote(
            noteUa = noteUa ?: "",
            noteRu = noteRu ?: "",
        )
}