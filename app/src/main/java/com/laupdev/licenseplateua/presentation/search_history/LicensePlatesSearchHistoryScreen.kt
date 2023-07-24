package com.laupdev.licenseplateua.presentation.search_history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Destination(start = true)
fun LicensePlatesSearchHistoryScreen(
    navigator: DestinationsNavigator,
    viewModel: LicensePlatesSearchHistoryViewModel = hiltViewModel()
) {
    var text by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchBar(
            query = text,
            onQueryChange = {
                text = it
            },
            onSearch = {
                     active = false
            },
            active = active,
            onActiveChange = {
                active = it
            }
        ) {

        }
    }
}