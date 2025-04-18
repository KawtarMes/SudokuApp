package com.example.sudoku.ui.register

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sudoku.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.jan.supabase.SupabaseClient

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterVM @Inject constructor(
    val userRepository: UserRepository
): ViewModel() {
    //toast$
    private val _messageStateFlow = MutableStateFlow("")
    val messageStateFlow = _messageStateFlow.asStateFlow()

    //signup with email

    fun signUpWithEmail(email: String, password: String){
        //verifie regex email
        //champs pas vide
        //min 8 caractere pass
        val patternEmail = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)\$"
        val regex = Regex(pattern = patternEmail)
        if (email.isNotEmpty() && password.isNotEmpty()){
            if (email.matches(regex)){
                viewModelScope.launch {
                   val response =  userRepository.signUpNewUser(email, password)

                }
            }else{
                Log.i("SignUP", "Please enter an email")
            }

        }else{
            Log.i("SignUP", "Please enter all fields")
        }


    }

}