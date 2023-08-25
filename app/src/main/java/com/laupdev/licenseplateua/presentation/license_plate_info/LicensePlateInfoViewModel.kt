package com.laupdev.licenseplateua.presentation.license_plate_info

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laupdev.licenseplateua.domain.model.LicensePlateInfo
import com.laupdev.licenseplateua.domain.usecases.GetLicensePlateInfoUseCaseImpl
import com.laupdev.licenseplateua.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LicensePlateInfoViewModel @Inject constructor(
    private val savedStatesHandle: SavedStateHandle,
    private val getLicensePlateInfoUseCaseImpl: GetLicensePlateInfoUseCaseImpl
) : ViewModel() {

    private val _uiState = MutableStateFlow<Resource<LicensePlateInfo>>(Resource.Loading(isLoading = true))
    val uiState: StateFlow<Resource<LicensePlateInfo>>
        get() = _uiState

    init {
        viewModelScope.launch {
            val licensePlate = savedStatesHandle.get<String>("licensePlate")
            // TODO: Regex check for LicensePlate
            if (licensePlate.isNullOrBlank()) {
                // TODO: Create custom exception
                _uiState.value = Resource.Error(exception = Exception("NO LICENSE PLATE"))
                return@launch
            }
            getLicensePlateInfoUseCaseImpl(licensePlate).collect {
                when(it) {
                    is Resource.Success -> {
                        _uiState.value = Resource.Success(data = it.data)
                    }
                    is Resource.Error -> {
                        _uiState.value = Resource.Error(exception = it.exception)
                    }
                    is Resource.Loading -> {
                        _uiState.value = Resource.Loading(isLoading = it.isLoading)
                    }
                }
            }
        }
    }
}