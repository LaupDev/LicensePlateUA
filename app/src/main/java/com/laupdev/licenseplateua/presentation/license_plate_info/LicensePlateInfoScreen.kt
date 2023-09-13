package com.laupdev.licenseplateua.presentation.license_plate_info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.laupdev.licenseplateua.presentation.common.ErrorAlertDialog
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@Composable
@Destination
fun LicensePlateInfoScreen(
    licensePlate: String,
    navigator: DestinationsNavigator,
    viewModel: LicensePlateInfoViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        if (state.licensePlateInfo != null) {
            LicensePlateMainInfoCard(
                item = state.licensePlateInfo,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            LicensePlateAdditionalInfoCard(
                item = state.licensePlateInfo,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        if (state.error != null) {
            ErrorAlertDialog(
                onDismiss = {
                    viewModel.onEvent(LicensePlateInfoEvent.OnCloseDialog)
                    navigator.popBackStack()
                },
                onConfirmClicked = {
                    viewModel.onEvent(LicensePlateInfoEvent.OnCloseDialog)
                    navigator.popBackStack()
                }
            )
        }
    }
}


@Preview
@Composable
fun LicensePlateInfoScreenPreview(
    viewModel: LicensePlateInfoViewModel = hiltViewModel()
) {
    LicensePlateInfoScreen(
        licensePlate = "АО4468ЕХ",
        EmptyDestinationsNavigator,
        viewModel = viewModel)
}