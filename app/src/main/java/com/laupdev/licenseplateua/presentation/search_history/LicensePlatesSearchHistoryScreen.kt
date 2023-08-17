package com.laupdev.licenseplateua.presentation.search_history

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
@Destination(start = true)
fun LicensePlatesSearchHistoryScreen(
    navigator: DestinationsNavigator,
    viewModel: LicensePlatesSearchHistoryViewModel = hiltViewModel()
) {
    var text by remember { mutableStateOf("") }

    val state = viewModel.uiState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .consumeWindowInsets(it)
                .padding(it),
        ) {
            SearchBar(
                query = text,
                onQueryChange = {
                    text = it
                },
                onSearch = {
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
            when (val currentsState = state.value) {
                is LicensePlatesSearchHistoryUiState.Success -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(start = 16.dp, top = 100.dp, end = 16.dp, bottom = 16.dp)
                    ) {
                        items(currentsState.licensePlatesList.size) {index ->
                            val licensePlateMainInfo = currentsState.licensePlatesList[index]
                            LicensePlatesSearchHistoryItem(
                                item = licensePlateMainInfo,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(180.dp)
                            )
                            if (index < currentsState.licensePlatesList.size - 1) {
                                Spacer(modifier = Modifier.height(22.dp))
                            }
                        }
                    }
                }
                is LicensePlatesSearchHistoryUiState.Error -> {

                }
                is LicensePlatesSearchHistoryUiState.Loading -> {

                }
            }

        }
    }
}