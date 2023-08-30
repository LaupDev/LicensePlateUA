package com.laupdev.licenseplateua.presentation.search_history

sealed class LicensePlatesSearchHistoryEvent {
    data class OnSearchQueryChange(val query: String): LicensePlatesSearchHistoryEvent()
    data object OnShowPlateNumberIsNotValidDialog: LicensePlatesSearchHistoryEvent()
    data object OnCloseDialog: LicensePlatesSearchHistoryEvent()
}
