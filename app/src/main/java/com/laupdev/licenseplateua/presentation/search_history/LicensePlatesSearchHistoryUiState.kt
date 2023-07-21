package com.laupdev.licenseplateua.presentation.search_history

import com.laupdev.licenseplateua.domain.model.LicensePlateMainInfo

sealed class LicensePlatesSearchHistoryUiState {
    data class Success(val licensePlatesList: List<LicensePlateMainInfo>) : LicensePlatesSearchHistoryUiState()
    data class Error(val exception: Exception) : LicensePlatesSearchHistoryUiState()
    data class Loading(val isLoading: Boolean) : LicensePlatesSearchHistoryUiState()
}
