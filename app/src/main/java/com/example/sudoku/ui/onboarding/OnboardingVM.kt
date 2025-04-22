package com.example.sudoku.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sudoku.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OnboardingVM @Inject constructor(

): ViewModel() {

    private val _navigateToNextScreen = MutableSharedFlow<String>()
    val navigateToNextScreen = _navigateToNextScreen.asSharedFlow()


    fun navigateToOnBoarding2() {
        viewModelScope.launch {
            _navigateToNextScreen.emit(Screen.Onboarding2.route)
        }
    }

    fun navigateToOnBoarding3() {
        viewModelScope.launch {
            _navigateToNextScreen.emit(Screen.Onboarding3.route)
        }
    }


    fun navigateToWelcomeScreen() {
        viewModelScope.launch {
            _navigateToNextScreen.emit(Screen.Main.route)
        }
    }

}