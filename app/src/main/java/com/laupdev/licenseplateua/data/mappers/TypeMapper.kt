package com.laupdev.licenseplateua.data.mappers

import com.laupdev.licenseplateua.data.remote.dto.TypeDto
import com.laupdev.licenseplateua.domain.model.Type

fun TypeDto.toType(): Type =
    Type(
        nameUa = nameUa ?: "",
        nameRu = nameRu ?: "",
        slug = slug ?: "",
    )