package com.laupdev.licenseplateua.presentation.search_history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laupdev.licenseplateua.domain.usecases.GetLicensePlatesSearchHistoryUseCaseImpl
import com.laupdev.licenseplateua.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LicensePlatesSearchHistoryViewModel @Inject constructor(
    private val getLicensePlatesSearchHistoryUseCase: GetLicensePlatesSearchHistoryUseCaseImpl
) : ViewModel() {

    private val _uiState = MutableStateFlow<LicensePlatesSearchHistoryUiState>(LicensePlatesSearchHistoryUiState.Success(emptyList()))
    val uiState: StateFlow<LicensePlatesSearchHistoryUiState>
        get() = _uiState

    init {
        loadSearchHistory()
    }

    private fun loadSearchHistory() {
        viewModelScope.launch {
            getLicensePlatesSearchHistoryUseCase().collect {
                when (it) {
                    is Resource.Success -> {
                        _uiState.value = LicensePlatesSearchHistoryUiState.Success(licensePlatesList = it.data)
                    }
                    is Resource.Error -> {
                        _uiState.value = LicensePlatesSearchHistoryUiState.Error(exception = it.exception)
                    }
                    is Resource.Loading -> {
                        _uiState.value = LicensePlatesSearchHistoryUiState.Loading(isLoading = it.isLoading)
                    }
                }
            }
        }
    }
}