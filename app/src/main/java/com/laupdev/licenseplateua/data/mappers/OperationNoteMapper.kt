package com.laupdev.licenseplateua.data.mappers

import com.laupdev.licenseplateua.data.remote.dto.OperationNoteDto
import com.laupdev.licenseplateua.domain.model.OperationNote

fun OperationNoteDto.toOperationNote(): OperationNote =
    OperationNote(
        noteUa = noteUa ?: "",
        noteRu = noteRu ?: "",
    )