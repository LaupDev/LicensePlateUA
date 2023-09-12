package com.laupdev.licenseplateua.presentation.search_history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.laupdev.licenseplateua.R
import com.laupdev.licenseplateua.domain.exception.PlateNumberIsNotValidException
import com.laupdev.licenseplateua.presentation.destinations.LicensePlateInfoScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination(start = true)
fun LicensePlatesSearchHistoryScreen(
    navigator: DestinationsNavigator,
    viewModel: LicensePlatesSearchHistoryViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
        ) {
            SearchBar(
                query = state.searchQuery,
                onQueryChange = {query ->
                    viewModel.onEvent(
                        LicensePlatesSearchHistoryEvent.OnSearchQueryChange(query = query)
                    )
                },
                onSearch = { query ->
                    if (viewModel.isValidPlateNumber(query)) {
                        navigator.navigate(
                            LicensePlateInfoScreenDestination(
                                licensePlate = query
                            )
                        )
                        viewModel.onEvent(
                            LicensePlatesSearchHistoryEvent.OnSearchQueryChange(query = "")
                        )
                    } else {
                        viewModel.onEvent(LicensePlatesSearchHistoryEvent.OnPlateNumberIsNotValid)
                    }
                },
                active = false,
                onActiveChange = {
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 10.dp, end = 16.dp, bottom = 16.dp),
                placeholder = {
                    Text(text = "XX0000XX")
                },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.Close, contentDescription = "Clear")
                },
                colors = SearchBarDefaults.colors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                shadowElevation = 6.dp
            ) {

            }
            if (state.licensePlates.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(start = 16.dp, top = 100.dp, end = 16.dp, bottom = 16.dp)
                ) {
                    val licensePlatesList = state.licensePlates
                    items(licensePlatesList.size) {index ->
                        val licensePlateMainInfo = licensePlatesList[index]
                        LicensePlatesSearchHistoryItem(
                            item = licensePlateMainInfo,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp)
                                .clickable {
                                    navigator.navigate(
                                        LicensePlateInfoScreenDestination(
                                            licensePlate = licensePlateMainInfo.plateNumber
                                        )
                                    )
                                }
                        )
                        if (index < licensePlatesList.size - 1) {
                            Spacer(modifier = Modifier.height(22.dp))
                        }
                    }
                }
            }
        }
        if (state.shouldOpenAlertDialog) {
            val title: String
            val message: String
            when (state.error) {
                is PlateNumberIsNotValidException -> {
                    title = stringResource(id = R.string.wrong_plate_number_format_title)
                    message = stringResource(id = R.string.wrong_plate_number_format_message)
                }
                else -> {
                    title = stringResource(id = R.string.default_error_title)
                    message = stringResource(id = R.string.default_error_message)
                }
            }
            AlertDialog(
                onDismissRequest = {
                    viewModel.onEvent(LicensePlatesSearchHistoryEvent.OnCloseDialog)
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            viewModel.onEvent(LicensePlatesSearchHistoryEvent.OnCloseDialog)
                        }
                    ) {
                        Text(text = stringResource(id = R.string.ok))
                    }
                },
                icon = {
                    Icon(imageVector = Icons.Default.Info, contentDescription = null)
                },
                title = {
                    Text(text = title)
                },
                text = {
                    Text(text = message)
                }
            )
        }
    }
}