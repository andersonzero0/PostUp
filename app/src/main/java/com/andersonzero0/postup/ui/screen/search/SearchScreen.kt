package com.andersonzero0.postup.ui.screen.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.andersonzero0.postup.ui.components.posts.PostList
import com.andersonzero0.postup.ui.components.screen.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    Screen {
        Column {
            SearchBar(
                inputField = {
                    SearchBarDefaults.InputField(
                        query = "",
                        onQueryChange = {},
                        onSearch = {},
                        expanded = false,
                        onExpandedChange = {},
                        leadingIcon = {
                            Icon(Icons.Default.Search, contentDescription = null)
                        },
//                    trailingIcon = {
//                        Icon(Icons.Default.Clear, contentDescription = null)
//                    }

                    )
                },
                expanded = false,
                onExpandedChange = {},
                shape = SearchBarDefaults.inputFieldShape,
                tonalElevation = SearchBarDefaults.TonalElevation,
                windowInsets = WindowInsets.ime,
                modifier = Modifier.height(56.dp)
            ) {}

            Spacer(modifier = Modifier.height(8.dp))

            PostList()
        }
    }
}
