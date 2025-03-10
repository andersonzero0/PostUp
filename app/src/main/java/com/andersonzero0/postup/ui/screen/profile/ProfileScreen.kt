package com.andersonzero0.postup.ui.screen.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.andersonzero0.postup.ui.components.profile.ProfileHeader
import com.andersonzero0.postup.ui.components.screen.Screen
import kotlinx.coroutines.launch
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Screen {

        Column {
            ProfileHeader()
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(modifier = Modifier.fillMaxWidth())
}