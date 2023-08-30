package com.laupdev.licenseplateua.presentation.search_history

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laupdev.licenseplateua.domain.usecases.GetLicensePlatesSearchHistoryUseCaseImpl
import com.laupdev.licenseplateua.presentation.search_history.LicensePlatesSearchHistoryEvent.OnCloseDialog
import com.laupdev.licenseplateua.presentation.search_history.LicensePlatesSearchHistoryEvent.OnSearchQueryChange
import com.laupdev.licenseplateua.presentation.search_history.LicensePlatesSearchHistoryEvent.OnShowPlateNumberIsNotValidDialog
import com.laupdev.licenseplateua.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LicensePlatesSearchHistoryViewModel @Inject constructor(
    private val getLicensePlatesSearchHistoryUseCase: GetLicensePlatesSearchHistoryUseCaseImpl
) : ViewModel() {

    var state by mutableStateOf(LicensePlatesSearchHistoryState())

    init {
        loadSearchHistory()
    }

    private fun loadSearchHistory() {
        viewModelScope.launch {
            getLicensePlatesSearchHistoryUseCase().collect {
                when (it) {
                    is Resource.Success -> {
                        state = state.copy(
                            licensePlates = it.data,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            isLoading = false,
                            shouldOpenAlertDialog = true,
                            error = it.exception
                        )
                    }
                    is Resource.Loading -> {
                        state = state.copy(
                            isLoading = it.isLoading,
                            error = null
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: LicensePlatesSearchHistoryEvent) {
        when(event) {
            is OnSearchQueryChange -> {
                state = state.copy(
                    searchQuery = event.query
                )
            }
            is OnShowPlateNumberIsNotValidDialog -> {
                state = state.copy(
                    searchQuery = "",
                    shouldOpenAlertDialog = true
                )
            }
            is OnCloseDialog -> {
                state = state.copy(
                    shouldOpenAlertDialog = false
                )
            }
        }
    }

    fun isValidPlateNumber(query: String): Boolean {
        val plateNumberRegex = Regex("^[a-zA-Z]{2}\\d{4}[a-zA-Z]{2}$")
        return query.matches(plateNumberRegex)
    }
}