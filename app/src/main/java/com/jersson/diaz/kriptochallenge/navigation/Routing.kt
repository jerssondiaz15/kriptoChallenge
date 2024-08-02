package com.jersson.diaz.kriptochallenge.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun Routing(
    navController: NavController,
    uiEvents: SharedFlow<UIEvents>,
) {

    LaunchedEffect(key1 = null) {
        uiEvents.collect { uiEvents ->
            when(uiEvents) {
                UIEvents.GoAddApplicationScreen -> {
                    navController.navigate(NavigationScreen.AddApplicationScreen.screen)
                }
                UIEvents.GoDashboardScreen -> {
                    navController.navigate(NavigationScreen.DashboardScreen.screen)
                }
                UIEvents.GoSettingsScreen -> {
                    navController.navigate(NavigationScreen.SettingsScreen.screen)
                }
                UIEvents.GoApplicationDetailsScreen -> {
                    navController.navigate(NavigationScreen.ApplicationDetailsScreen.screen)
                }
            }
        }
    }
}