package com.jersson.diaz.kriptochallenge.navigation

sealed class NavigationHost(val route: String) {
    data object InitNavHost : NavigationHost("navigation_host")
}