package hs.project.today_pedometer.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import hs.project.today_pedometer.feature.onboarding.OnboardingRoute
import hs.project.today_pedometer.feature.progress.ProgressRoute
import hs.project.today_pedometer.feature.settings.SettingsRoute
import hs.project.today_pedometer.feature.splash.SplashRoute
import hs.project.today_pedometer.feature.stats.StatsRoute

@Composable
fun TodayPedometerAppRoot() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination
    val isMainDestination = TopLevelDestination.items.any { destination ->
        currentDestination?.hierarchy?.any { it.route == destination.route } == true
    }

    Scaffold(
        bottomBar = {
            if (isMainDestination) {
                NavigationBar {
                    TopLevelDestination.items.forEach { destination ->
                        val selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true
                        NavigationBarItem(
                            selected = selected,
                            onClick = {
                                navController.navigate(destination.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = {},
                            label = { Text(destination.label) }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppDestination.Splash.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppDestination.Splash.route) {
                SplashRoute(
                    onNavigateToOnboarding = {
                        navController.navigate(AppDestination.Onboarding.route) {
                            popUpTo(AppDestination.Splash.route) { inclusive = true }
                        }
                    },
                    onNavigateToMain = {
                        navController.navigate(TopLevelDestination.Progress.route) {
                            popUpTo(AppDestination.Splash.route) { inclusive = true }
                        }
                    }
                )
            }
            composable(AppDestination.Onboarding.route) {
                OnboardingRoute(
                    onFinished = {
                        navController.navigate(TopLevelDestination.Progress.route) {
                            popUpTo(AppDestination.Onboarding.route) { inclusive = true }
                        }
                    }
                )
            }
            composable(TopLevelDestination.Progress.route) {
                ProgressRoute()
            }
            composable(TopLevelDestination.Stats.route) {
                StatsRoute()
            }
            composable(TopLevelDestination.Settings.route) {
                SettingsRoute()
            }
        }
    }
}
