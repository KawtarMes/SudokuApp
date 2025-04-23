package com.example.sudoku.ui.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sudoku.R
import com.example.sudoku.ui.composables.RedButton
import com.example.sudoku.ui.composables.YellowTextField
import com.example.sudoku.ui.theme.SudokuFontFamily

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginVM) {

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

    LoginContent(
        email =email,
        password= password,
        onEmailChange =  {email = it},
        onPasswordChange = {password= it},
        onClick = {
            viewModel.signInWithEmail(
                email,
                password,
            )
        },
        onNavToRegister = { viewModel.navigateToRegisterScreen() },
    )
}


@Composable
fun LoginContent(
    email : String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onClick: () -> Unit,
    onNavToRegister: ()-> Unit,
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Image(
            painter = painterResource(R.drawable.vector_enter_name),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally

            ) {


            Image(
                painter = painterResource(id = R.drawable.text_logo),
                contentDescription = null,
            )

            Column(
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(Modifier.size(30.dp))

                YellowTextField(
                    email,
                    onEmailChange,
                    stringResource(R.string.email),
                    false
                )

                Spacer(Modifier.size(30.dp))

                YellowTextField(
                    password,
                    onPasswordChange,
                    stringResource(R.string.password),
                    true
                )

                Spacer(Modifier.size(20.dp))

                Text(
                    text = stringResource(R.string.create_account),
                    fontWeight = FontWeight.Bold,
                    fontFamily = SudokuFontFamily,
                    modifier = Modifier
                        .clickable { onNavToRegister() }
                        .padding(10.dp)
                )

            }

            RedButton(
                onClick,
                text = stringResource(R.string.continue_button_text),
                modifier = Modifier
            )
        }

    }
}

@Preview
@Composable
fun Previewfunc() {
    LoginContent("", "", { "" }, { "" }, {}) { }
}

