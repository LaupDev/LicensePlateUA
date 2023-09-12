package com.laupdev.licenseplateua.presentation.license_plate_info

import com.laupdev.licenseplateua.domain.model.LicensePlateInfo

data class LicensePlateInfoState(
    val licensePlateInfo: LicensePlateInfo? = null,
    val error: Exception? = null,
    val isLoading: Boolean = false
)
