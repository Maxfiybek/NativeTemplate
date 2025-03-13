package com.example.nativetemplate.core_ui.components.dialogs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.nativetemplate.core.coreui.R
import com.example.nativetemplate.core_ui.components.composables.PrimaryButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VirtualBankDatePicker(
    visibility: Boolean,
    onDismiss: () -> Unit,
    onDismissButtonClicked: () -> Unit,
    onConfirm: (mills: Long?) -> Unit,
    datePickerState: DatePickerState,
    dismissOnClickOutside: Boolean = false,
    dismissOnBackPress: Boolean = false,
) {
    if (visibility) {
        DatePickerDialog(
            onDismissRequest = onDismiss,
            dismissButton = {
                PrimaryButton(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                    text = stringResource(R.string.cancel),
                    onClick = onDismissButtonClicked
                )
            },
            confirmButton = {
                PrimaryButton(
                    text = stringResource(R.string.select_current_time),
                    onClick = { onConfirm(datePickerState.selectedDateMillis) },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .height(50.dp)
                )
            },
            properties = DialogProperties(
                dismissOnBackPress = dismissOnBackPress,
                dismissOnClickOutside = dismissOnClickOutside
            )
        ) {
            DatePicker(state = datePickerState)
        }
    }
}