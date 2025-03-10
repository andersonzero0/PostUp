package com.andersonzero0.postup.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.andersonzero0.postup.ui.components.screen.Screen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToSettings: () -> Unit
) {
    Screen {
        Column {
            Button(onClick = onNavigateToSettings) {
                Text(text = "Go to Settings")
            }
            Text(text = "Home Screen")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(onNavigateToSettings = {})
}