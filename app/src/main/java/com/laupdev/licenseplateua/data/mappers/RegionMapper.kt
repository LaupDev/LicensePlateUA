package com.laupdev.licenseplateua.data.mappers

import com.laupdev.licenseplateua.data.remote.dto.RegionDto
import com.laupdev.licenseplateua.domain.model.Region

fun RegionDto.toRegion(): Region =
    Region(
        nameUa = nameUa ?: "",
        nameRu = nameRu ?: "",
        newCode = newCode ?: "",
        oldCode = oldCode ?: "",
        slug = slug ?: "",
    )