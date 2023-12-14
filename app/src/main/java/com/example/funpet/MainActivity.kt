package com.example.funpet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.funpet.ui.theme.FunpetTheme
import com.example.funpet.ui.theme.Screens.FunPetsNavigationGraph
import com.example.funpet.ui.theme.Screens.Routes
import com.example.funpet.ui.theme.Screens.UserInputScreen
import com.example.funpet.ui.theme.Screens.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            FunpetTheme {
                // A surface container using the 'background' color from the theme
                   FunpetApp()
            }
        }
    }
    @Composable
    fun FunpetApp(){
        FunPetsNavigationGraph()

    }


}

