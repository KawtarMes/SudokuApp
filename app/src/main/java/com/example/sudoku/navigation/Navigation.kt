package com.example.sudoku.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sudoku.ui.game.GameScreen
import com.example.sudoku.ui.game.GameVM
import com.example.sudoku.ui.level.LevelScreen
import com.example.sudoku.ui.level.LevelVM
import com.example.sudoku.ui.login.LoginScreen
import com.example.sudoku.ui.login.LoginVM
import com.example.sudoku.ui.main.MainScreen
import com.example.sudoku.ui.main.MainVM
import com.example.sudoku.ui.onboarding.OnBoardingScreen
import com.example.sudoku.ui.onboarding.OnboardingScreen2
import com.example.sudoku.ui.onboarding.OnboardingScreen3
import com.example.sudoku.ui.onboarding.OnboardingVM
import com.example.sudoku.ui.register.RegisterScreen
import com.example.sudoku.ui.register.RegisterVM
import com.example.sudoku.ui.splash.Splash1Screen
import com.example.sudoku.ui.splash.SplashScreen
import com.example.sudoku.ui.splash.SplashVM

sealed class Screen(val route : String){
    object Splash : Screen("splash")
    object Splash1 : Screen("splash1")
    object Main : Screen("main")
    object Onboarding: Screen("onboarding")
    object Onboarding2 : Screen("onboarding2")
    object Onboarding3 : Screen("onboarding3")
    object Level : Screen("level")
    object Game : Screen("game")
    object Register : Screen("register")
    object Login: Screen("login")
    object Result: Screen("result")

}

@Composable
fun MyNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Level.route)
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
            val registerVM: RegisterVM = hiltViewModel()
            RegisterScreen(navController = navController, viewModel = registerVM)
        }

        composable(Screen.Onboarding.route){
            val onboardingVM: OnboardingVM = hiltViewModel()
           OnBoardingScreen(navController = navController, viewModel = onboardingVM)
        }

        composable(Screen.Onboarding2.route) {
            val onboardingVM: OnboardingVM = hiltViewModel()
            OnboardingScreen2(navController = navController, viewmodel = onboardingVM)
        }

        composable(Screen.Onboarding3.route) {
            val onboardingVM: OnboardingVM = hiltViewModel()
            OnboardingScreen3(navController = navController, viewmodel = onboardingVM)
        }

        composable(Screen.Main.route){
            val mainVM: MainVM = hiltViewModel()
            MainScreen(navController = navController, viewmodel = mainVM)
        }

        composable(Screen.Login.route){
           val loginVM: LoginVM = hiltViewModel()
            LoginScreen(navController = navController, viewModel = loginVM)
        }

        composable(Screen.Result.route){
            //val resultVM: ResultVM = hiltViewModel()
            // ResultScreen(navController = navController, viewModel = resultVM)
        }
        composable(Screen.Level.route){
            val levelVM: LevelVM = hiltViewModel()
            LevelScreen(navController = navController, viewModel = levelVM)
        }

        composable(Screen.Level.route) {
            val levelVM: LevelVM = hiltViewModel()
            LevelScreen(navController = navController, viewModel = levelVM)
        }

        composable(
            Screen.Game.route + "/{gridLevel}",
            arguments = listOf(
                navArgument(name = "gridLevel") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val gameVM: GameVM = hiltViewModel()

            navBackStackEntry.arguments?.getString("gridLevel")?.let {
                val gridLevel = it
                GameScreen(navController = navController, viewModel = gameVM, gridLevel = gridLevel)
            }

        }
    }


}