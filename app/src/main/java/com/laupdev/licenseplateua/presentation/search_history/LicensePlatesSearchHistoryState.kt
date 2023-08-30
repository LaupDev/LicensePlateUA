package com.laupdev.licenseplateua.presentation.search_history

import com.laupdev.licenseplateua.domain.model.LicensePlateMainInfo

data class LicensePlatesSearchHistoryState(
    val licensePlates: List<LicensePlateMainInfo> = emptyList(),
    val isLoading: Boolean = false,
    val searchQuery: String = "",
    val shouldOpenAlertDialog: Boolean = false,
    val error: Exception? = null
)
