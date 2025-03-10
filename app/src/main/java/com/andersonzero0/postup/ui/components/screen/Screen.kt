package com.andersonzero0.postup.ui.components.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Screen(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
        Box (modifier = modifier.padding(top = 8.dp).padding(horizontal = 16.dp)) {
            content()
        }
}

@Preview
@Composable
fun ScreenPreview() {
    Screen {}
}