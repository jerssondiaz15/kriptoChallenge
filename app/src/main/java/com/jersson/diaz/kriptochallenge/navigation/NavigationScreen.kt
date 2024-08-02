package com.jersson.diaz.kriptochallenge.navigation

sealed class NavigationScreen(val screen: String) {
    data object HomeScreen: NavigationScreen("home_screen")
    data object AddApplicationScreen: NavigationScreen("add_application_screen")
    data object DashboardScreen: NavigationScreen("dashboard_screen")
    data object SettingsScreen: NavigationScreen("settings_screen")
    data object ApplicationDetailsScreen: NavigationScreen("application_details_screen")
}