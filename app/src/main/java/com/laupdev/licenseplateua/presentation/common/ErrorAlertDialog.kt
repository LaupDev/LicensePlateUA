package com.laupdev.licenseplateua.presentation.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.laupdev.licenseplateua.R

@Composable
fun ErrorAlertDialog(
    onDismiss: () -> Unit,
    onConfirmClicked: () -> Unit,
    title: String = stringResource(id = R.string.default_error_title),
    message: String = stringResource(id = R.string.default_error_message)
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = onConfirmClicked
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