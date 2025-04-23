package com.example.sudoku.ui.register

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sudoku.R
import com.example.sudoku.ui.composables.RedButton
import com.example.sudoku.ui.composables.YellowTextField
import com.example.sudoku.ui.theme.SudokuFontFamily


@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterVM){

    var username  by remember { mutableStateOf("") }
    var email  by remember { mutableStateOf("") }
    var password  by remember { mutableStateOf("") }

    val toastMessage by viewModel.messageStateFlow.collectAsState()

    val context = LocalContext.current
    LaunchedEffect( toastMessage){
        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
    }

    LaunchedEffect(Unit){
        viewModel.navigateToNextScreen.collect{ route->
            navController.navigate(route)
        }
    }

     RegisteContent(
         email =email,
         password= password,
         username= username,
         onUsernameChange = {username = it},
         onEmailChange =  {email = it},
         onPasswordChange = {password= it},
         onClick = {
             viewModel.signUpWithEmail(
                 email,
                 password,
                 username
             )
         }
     )
}

//@Preview
@Composable
fun RegisteContent(
                   email : String,
                   password: String,
                   username: String,
                   onEmailChange: (String) -> Unit,
                   onUsernameChange: (String) -> Unit,
                   onPasswordChange: (String) -> Unit,
                   onClick: () -> Unit
) {

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        RegisterBackground()

        Column(
            Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Spacer(Modifier)
            Image(
                painter = painterResource(id = R.drawable.text_logo),
                contentDescription = null,
            )

            Image(
                painter = painterResource(id = R.drawable.logo_owl),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )
            Text(
                text = stringResource(R.string.register_name),
                fontFamily = SudokuFontFamily
            )

            YellowTextField(username, onUsernameChange, stringResource(R.string.username), false)
            YellowTextField(email, onEmailChange, stringResource(R.string.email), false)
            YellowTextField(password, onPasswordChange, stringResource(R.string.password), true)

            RedButton(
                onClick,
                text = stringResource(R.string.next_button_text),
                modifier = Modifier
            )
        }
    }

}


@Composable
fun RegisterBackground(){
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.vector_enter_name),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PreviewContent() {
    RegisteContent(
        "email",
        "pass",
        "username",
        { "it" },
        { "it" },
        { "it" },
        onClick = {}
    )
}

