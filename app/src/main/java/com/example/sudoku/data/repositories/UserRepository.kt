package com.example.sudoku.data.repositories

import android.util.Log
import com.example.sudoku.MyPrefs
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import javax.inject.Inject
class UserRepository @Inject constructor(
    val supabase : SupabaseClient,
    val myPrefs: MyPrefs
) {
    //gestion d'erreur
    sealed class AuthResult {
        object Success : AuthResult()
        data class Failure(val message: String) : AuthResult()
    }

    suspend fun signUpNewUser(email: String, password: String, username: String): AuthResult {
        try {
            val response = supabase.auth.signUpWith(Email) {
                this.email = email
                this.password = password
                data = buildJsonObject { put("username", username) }
            }
            val session = supabase.auth.currentSessionOrNull()

            if (session != null && response != null) {
                myPrefs.userId = session.user?.id ?: ""
                myPrefs.token = session.accessToken
            }//dans le else je suis quand meme en succes le user se crée en bdd


            //fetch profil si auth, pour avoir username


            return AuthResult.Success
        } catch (e: Exception) {
            Log.e("Register", "RegisterException ${e.message}")
            return AuthResult.Failure(e.message ?: " error")
        }
    }

    suspend fun signIn(email: String, password: String): AuthResult {
        return try {
            supabase.auth.signInWith(Email) {
                this.email = email
                this.password = password
            }

            val session =  supabase.auth.currentSessionOrNull()
            val user = session?.user

            if (session != null && user != null ) {
                AuthResult.Success
            } else {
                AuthResult.Failure("Invalid email or password")
            }
        } catch (e: Exception) {
            AuthResult.Failure(e.message ?: "Unknown error")
        }
    }

    suspend fun logout(){
        try {
            supabase.auth.signOut()
            myPrefs.userId = ""
            myPrefs.token = ""
        }catch (e: Exception){
            Log.i("LOGOUT","logout err  : ${e.message}")
        }
    }

}


