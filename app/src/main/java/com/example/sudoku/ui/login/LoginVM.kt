package com.example.sudoku.ui.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sudoku.data.repositories.UserRepository
import com.example.sudoku.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginVM @Inject constructor(
    val userRepository: UserRepository
): ViewModel() {

    private val _messageStateFlow = MutableStateFlow("")
    val messageStateFlow = _messageStateFlow.asStateFlow()

    private val _navigateToNextScreen = MutableSharedFlow<String>()
    val navigateToNextScreen = _navigateToNextScreen.asSharedFlow()

    fun signInWithEmail(email: String, password: String) {

        val patternEmail =
            "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$"
        val regex = Regex(pattern = patternEmail)

        if (email.isNotEmpty() && password.isNotEmpty()) {
            if (email.matches(regex)) {
                viewModelScope.launch {
                    when (val result = userRepository.signIn(email, password)) {

                        is UserRepository.AuthResult.Success -> {
                            //_messageStateFlow.value = "Successfully signed in"
                            _navigateToNextScreen.emit(Screen.Main.route)
                        }

                        is UserRepository.AuthResult.Failure -> {
                            _messageStateFlow.value = result.message
                            Log.e("SignIn", "Error: ${result.message}")
                        }
                    }
                }
            } else {
                _messageStateFlow.value = "Please enter a valid email"
            }
        } else {
            _messageStateFlow.value = "Please fill in all fields"
        }
    }

    fun navigateToRegisterScreen(){
        viewModelScope.launch {
            _navigateToNextScreen.emit(Screen.Register.route)
        }
    }

}