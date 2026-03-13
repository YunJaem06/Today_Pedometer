package hs.project.today_pedometer.core.navigation

sealed class AppDestination(val route: String) {
    data object Splash : AppDestination("splash")
    data object Onboarding : AppDestination("onboarding")
}
