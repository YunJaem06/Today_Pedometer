package hs.project.today_pedometer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dagger.hilt.android.AndroidEntryPoint
import hs.project.today_pedometer.core.navigation.TodayPedometerAppRoot
import hs.project.today_pedometer.ui.theme.Today_PedometerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Today_PedometerTheme {
                TodayPedometerAppRoot()
            }
        }
    }
}
