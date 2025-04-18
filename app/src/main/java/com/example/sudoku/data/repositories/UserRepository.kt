package com.example.sudoku.data.repositories

import android.util.Log
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import kotlinx.serialization.json.buildJsonObject
import javax.inject.Inject
//import io.github.jan.supabase.auth.providers.Email
class UserRepository @Inject constructor(
    private val auth: Auth,
   val supabase : SupabaseClient
) {

    /* pour  rajouter username , usermetadata
    val user = supabase.auth.signUpWith(Email) {
        email = "example@email.com"
        password = "example-password"
        data = buildJsonObject {
            put("username", "Kawtar")

        }
    }*/
    suspend fun  signUpNewUser(email: String, password: String){
          try {
            val result = supabase.auth.signUpWith(Email){
                this.email = email
                this.password = password
            }
              if (result != null) {
                  Log.i("Register", "RegisterResult not null")

              }
        }catch (e: Exception){
              Log.i("Register", "RegisterException ${e.message}")

          }

    }

    suspend fun  signIn(email: String, password: String){
        try {
            supabase.auth.signInWith(Email){
                this.email = email
                this.password = password
            }

        }catch (e: Exception){

        }

    }

}


//    //register
//
//    // login


