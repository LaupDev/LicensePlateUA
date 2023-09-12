package com.laupdev.licenseplateua.presentation.search_history

sealed class LicensePlatesSearchHistoryEvent {
    data class OnSearchQueryChange(val query: String): LicensePlatesSearchHistoryEvent()
    data object OnPlateNumberIsNotValid: LicensePlatesSearchHistoryEvent()
    data object OnCloseDialog: LicensePlatesSearchHistoryEvent()
}
