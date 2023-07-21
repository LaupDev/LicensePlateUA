package com.laupdev.licenseplateua.data.mappers

import com.laupdev.licenseplateua.data.remote.dto.OperationGroupDto
import com.laupdev.licenseplateua.domain.model.OperationGroup

fun OperationGroupDto.toOperationGroup(): OperationGroup =
    OperationGroup(
        nameUa = nameUa ?: "",
        nameRu = nameRu ?: "",
    )