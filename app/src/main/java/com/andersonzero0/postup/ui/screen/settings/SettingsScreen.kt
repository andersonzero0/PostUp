package com.andersonzero0.postup.ui.screen.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SettingsScreen(onNavigateBack: () -> Unit) {
    Column {
        Text(text = "Settings Screen")
        Button(onClick = onNavigateBack) {
            Text(text = "Go back")
        }
    }
}