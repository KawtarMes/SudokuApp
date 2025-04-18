package com.example.sudoku.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.sudoku.navigation.Screen

@Composable
fun Splash1Screen(navController: NavController, viewModel : SplashVM) {
    LaunchedEffect(Unit) {
        viewModel.checkIsUserLogged()
    }

    LaunchedEffect(Unit) {
        viewModel.navigateToNextScreen.collect { nextScreen ->
            navController.navigate(nextScreen) {
                popUpTo(Screen.Splash.route) { inclusive = true }
            }
        }
    }

    Splash1Content()
}

@Preview
@Composable
fun Splash1Content() {
    Box(
        Modifier.fillMaxSize().background(Color.White),
    ) {
        BackGround()
        Splash1Column()
    }
}