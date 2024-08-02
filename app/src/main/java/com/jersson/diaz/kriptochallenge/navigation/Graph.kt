package com.jersson.diaz.kriptochallenge.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jersson.diaz.kriptochallenge.MainViewModel
import com.jersson.diaz.kriptochallenge.ui.AddApplicationScreen
import com.jersson.diaz.kriptochallenge.ui.ApplicationDetailsScreen
import com.jersson.diaz.kriptochallenge.ui.DashboardScreen
import com.jersson.diaz.kriptochallenge.ui.HomeScreen
import com.jersson.diaz.kriptochallenge.ui.SettingsScreen

fun NavGraphBuilder.graph(
    viewModel: MainViewModel,
    goBack: Runnable,
) {
    navigation(
        startDestination = NavigationScreen.HomeScreen.screen,
        route = NavigationHost.InitNavHost.route
    ) {
        composable(NavigationScreen.HomeScreen.screen) {
            HomeScreen(
                onAddApplicationClick = { viewModel.goAddApplicationClick() },
                onViewDashboardClick = { viewModel.goViewDashboardClick() },
                onSettingsClick = { viewModel.goSettingsClick() }
            )
        }
        composable(NavigationScreen.AddApplicationScreen.screen) {
            AddApplicationScreen(
                onSaveClick = { viewModel.insertApplicationData(it) },
                onCancelClick = goBack
            )
        }
        composable(NavigationScreen.DashboardScreen.screen) {
            DashboardScreen(
                applications = viewModel.state.value.listApplications,
                recommendations = viewModel.state.value.recommendations,
                goDetail = { viewModel.goApplicationDetail(it) }
            )
        }
        composable(NavigationScreen.SettingsScreen.screen) {
            SettingsScreen(
                onSaveSettingsClick = viewModel.state.value.mainFunctions.onSaveSettingsClick,
                onSettingsCancelClick = goBack
            )
        }
        composable(NavigationScreen.ApplicationDetailsScreen.screen) {
            ApplicationDetailsScreen(
                application = viewModel.state.value.application,
                onDeleteClick = {
                    viewModel.deleteApplicationData()
                }
            )
        }
    }
}