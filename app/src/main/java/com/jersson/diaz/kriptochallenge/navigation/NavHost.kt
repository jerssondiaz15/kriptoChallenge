package com.jersson.diaz.kriptochallenge.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.jersson.diaz.kriptochallenge.MainViewModel
import androidx.navigation.compose.NavHost

@Composable
fun NavHost(
    viewModel: MainViewModel = hiltViewModel(),
    goBack: Runnable,
) {

    val navController= rememberNavController()

    Routing(navController = navController, uiEvents = viewModel.events)

    NavHost(
        navController = navController,
        startDestination = NavigationHost.InitNavHost.route,
    ) {
        graph(
            viewModel = viewModel,
            goBack = goBack,
        )
    }
}