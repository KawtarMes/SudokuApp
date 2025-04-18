package com.example.sudoku.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sudoku.ui.main.MainVM
import com.example.sudoku.ui.onboarding.OnboardingVM
import com.example.sudoku.ui.splash.Splash1Screen
import com.example.sudoku.ui.splash.SplashScreen
import com.example.sudoku.ui.splash.SplashVM

sealed class Screen(val route : String){
    object Splash : Screen("splash")
    object Splash1 : Screen("splash1")
    object Main : Screen("main")
    object Onboarding: Screen("onboarding")
    object Level : Screen("level")
    object Register : Screen("register")
    object Login: Screen("login")
    object Result: Screen("result")

}

@Composable
fun MyNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splash.route)
    {
        composable(Screen.Splash.route){
            val splashVM: SplashVM = hiltViewModel()
            SplashScreen(navController = navController, viewModel = splashVM)
        }

        composable(Screen.Splash1.route){
            val splashVM: SplashVM = hiltViewModel()
            Splash1Screen(navController = navController, viewModel = splashVM)
        }

        composable(Screen.Register.route){
            // val registerVM: RegisterVM = hiltViewModel()
            // RegisterScreen(navController = navController, viewModel = registerVM)
        }

        composable(Screen.Onboarding.route){
            val onboardingVM: OnboardingVM = hiltViewModel()
          // OnboardingScreen(navController = navController, viewModel = onboardingVM)
        }

        composable(Screen.Main.route){
            val mainVM: MainVM = hiltViewModel()
           // MainScreen(navController = navController, viewModel = mainVM)
        }

        composable(Screen.Login.route){
           // val mainVM: LoginVM = hiltViewModel()
            // LoginScreen(navController = navController, viewModel = loginVM)
        }

        composable(Screen.Result.route){
            //val resultVM: ResultVM = hiltViewModel()
            // ResultScreen(navController = navController, viewModel = resultVM)
        }
        composable(Screen.Level.route){
            //val levelVM: LevelVM = hiltViewModel()
            // LevelScreen(navController = navController, viewModel = levelVM)
        }
    }


}