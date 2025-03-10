package com.andersonzero0.postup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.andersonzero0.postup.ui.screen.home.HomeScreen
import com.andersonzero0.postup.ui.theme.PostUpTheme
import com.andersonzero0.postup.ui.components.navbar.Navbar
import com.andersonzero0.postup.ui.route.Route.Search
import com.andersonzero0.postup.ui.route.Route.Home
import com.andersonzero0.postup.ui.route.Route.Profile
import com.andersonzero0.postup.ui.route.Route.Settings
import com.andersonzero0.postup.ui.route.navBarRoutes
import com.andersonzero0.postup.ui.route.routes
import com.andersonzero0.postup.ui.screen.profile.ProfileScreen
import com.andersonzero0.postup.ui.screen.search.SearchScreen
import com.andersonzero0.postup.ui.screen.settings.SettingsScreen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PostUpTheme {
                val navController = rememberNavController()

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                Scaffold(
                    topBar = {
                        if (currentDestination?.route in listOf(Settings.name)) {
                            TopAppBar(
//                                colors = TopAppBarDefaults.topAppBarColors(
//                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
//                                    titleContentColor = MaterialTheme.colorScheme.primary,
//                                ),
                                title = {
                                    Text(
                                        text = routes.find { it.name == currentDestination?.route }?.label
                                            ?: ""
                                    )
                                },
                                navigationIcon = {
                                    IconButton(onClick = { navController.popBackStack() }) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                            contentDescription = "Voltar"
                                        )
                                    }
                                },
                            )
                        }
                    },

                    bottomBar = {
                        if (currentDestination?.route in listOf(Home.name, Profile.name, Search.name)) {
                            Navbar(navController, navBarRoutes)
                        }
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Home.name,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Home.name) {
                            HomeScreen(onNavigateToSettings = {
                                navController.navigate(Settings.name)
                            })
                        }
                        composable(Profile.name) { ProfileScreen() }
                        composable(Settings.name) {
                            SettingsScreen(onNavigateBack = {
                                navController.popBackStack()
                            })
                        }
                        composable(Search.name) {
                            SearchScreen()
                        }
                    }
                }
            }
        }
    }
}

