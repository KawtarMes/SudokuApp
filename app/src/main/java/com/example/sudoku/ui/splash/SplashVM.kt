package com.example.sudoku.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sudoku.MyPrefs
import com.example.sudoku.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashVM @Inject constructor(
    val myPrefs: MyPrefs,
): ViewModel() {

    private val _navigateToSecondSplash = MutableStateFlow<Boolean>(false)
    val navigateToSecondSplash : StateFlow<Boolean> get() = _navigateToSecondSplash

    private val _navigateToNextScreen = MutableSharedFlow<String>()
    val navigateToNextScreen = _navigateToNextScreen.asSharedFlow()

    init {
        navigateAfterDelayToSplash1()
    }

    private fun navigateAfterDelayToSplash1() {
        viewModelScope.launch {
            delay(2000)
            _navigateToSecondSplash.value = true
        }
    }

    fun checkIsUserLogged() {
        viewModelScope.launch {
            delay(2000)
            val nextScreen = if (myPrefs.userId.isNotEmpty() && myPrefs.token?.isNotEmpty()== true) {
                Screen.Main.route
            } else {
                Screen.Login.route
            }
            _navigateToNextScreen.emit(nextScreen)
        }
    }


}