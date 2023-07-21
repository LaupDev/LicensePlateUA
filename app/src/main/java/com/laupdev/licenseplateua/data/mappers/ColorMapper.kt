package com.laupdev.licenseplateua.data.mappers

import com.laupdev.licenseplateua.data.remote.dto.ColorDto
import com.laupdev.licenseplateua.domain.model.Color

fun ColorDto.toColor(): Color =
    Color(
        nameUa = nameUa ?: "",
        nameRu = nameRu ?: "",
        nameSlug = nameSlug ?: "",
    )