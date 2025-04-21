package com.example.sudoku.ui.register


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
class RegisterVM @Inject constructor(
    val userRepository: UserRepository
): ViewModel() {
    //toast
    private val _messageStateFlow = MutableStateFlow("")
    val messageStateFlow = _messageStateFlow.asStateFlow()

    private val _navigateToNextScreen = MutableSharedFlow<String>()
    val navigateToNextScreen = _navigateToNextScreen.asSharedFlow()

    fun signUpWithEmail(email: String, password: String, username: String) {
        val patternEmail = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$"
        val regex = Regex(pattern = patternEmail)

        if (email.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty()) {
            if (email.matches(regex)) {
                viewModelScope.launch {
                    when (val result = userRepository.signUpNewUser(email, password, username)) {
                        is UserRepository.AuthResult.Success -> {
                            _messageStateFlow.value = "Successfully signed up"
                            _navigateToNextScreen.emit(Screen.Onboarding.route)
                        }
                        is UserRepository.AuthResult.Failure -> {
                            _messageStateFlow.value = result.message
                        }
                    }
                }
            } else {
                _messageStateFlow.value = "Please enter a valid email"
            }
        } else {
            _messageStateFlow.value = "Please enter all fields"
        }
    }




}