package com.laupdev.licenseplateua.presentation.license_plate_info

sealed class LicensePlateInfoEvent {
    data object OnCloseDialog : LicensePlateInfoEvent()
}