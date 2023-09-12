package com.laupdev.licenseplateua.presentation.license_plate_info

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laupdev.licenseplateua.domain.usecases.GetLicensePlateInfoUseCaseImpl
import com.laupdev.licenseplateua.domain.usecases.SaveOrUpdateLicensePlateMainInfoToDatabaseUseCase
import com.laupdev.licenseplateua.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LicensePlateInfoViewModel @Inject constructor(
    private val savedStatesHandle: SavedStateHandle,
    private val getLicensePlateInfoUseCaseImpl: GetLicensePlateInfoUseCaseImpl,
    private val saveOrUpdateLicensePlateMainInfoToDatabaseUseCase: SaveOrUpdateLicensePlateMainInfoToDatabaseUseCase
) : ViewModel() {

    var state by mutableStateOf(LicensePlateInfoState())

    init {
        viewModelScope.launch {
            val licensePlate = savedStatesHandle.get<String>("licensePlate") ?: ""
            getLicensePlateInfoUseCaseImpl(licensePlate).collect {
                when(it) {
                    is Resource.Success -> {
                        state = state.copy(
                            licensePlateInfo = it.data,
                            error = null,
                            isLoading = false
                        )
                        saveOrUpdateLicensePlateMainInfoToDatabaseUseCase.invoke(it.data)
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            error = it.exception,
                            isLoading = false
                        )
                    }
                    is Resource.Loading -> {
                        state = state.copy(
                            isLoading = it.isLoading
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: LicensePlateInfoEvent) {
        when(event) {
            is LicensePlateInfoEvent.OnCloseDialog -> {
                state = state.copy(
                    error = null
                )
            }
        }
    }
}