package com.andersonzero0.postup.ui.route

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

val routes = listOf(
    Route.Home,
    Route.Profile,
    Route.Settings
)

sealed class Route(val name: String, val label: String = name) {
    data object Home : Route("home", "Home")
    data object Profile : Route("profile", "Perfil")
    data object Settings : Route("settings", "Configurações")
}

data class NavBarRoute(val name: String, val route: Route, val icon: ImageVector)

val navBarRoutes = listOf(
    NavBarRoute("Home", Route.Home, Icons.Default.Home),
    NavBarRoute("Profile", Route.Profile, Icons.Default.AccountCircle)
)