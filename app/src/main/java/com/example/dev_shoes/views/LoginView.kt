package com.example.dev_shoes.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import com.example.dev_shoes.R
import com.example.dev_shoes.components.MainButton
import com.example.dev_shoes.components.MainIconButton
import com.example.dev_shoes.components.SpaceH
import com.example.dev_shoes.components.TitleBar
import com.example.dev_shoes.components.TitleView


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Login") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Red
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()

                    }
                }

            )
        }
    ) {
        ContentLoginView(navController)
    }


}

@Composable
fun ContentLoginView(navController: NavController) {

    val passwordVector = painterResource(id = R.drawable.password_eye)
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TitleView(name = "INICIAR SESION")
        SpaceH()

       /* TextField(
            value = "opcional",
            onValueChange = { },
            label = { Text(text = "opcional") }
        )*/



        OutlinedTextField(
            value = emailValue.value,
            onValueChange = { emailValue.value = it },
            label = { Text(text = "Phone") },
            placeholder = { Text(text = "Enter the phone number") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.8f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        )

        SpaceH()
        OutlinedTextField(
            value = passwordValue.value,
            onValueChange = { passwordValue.value = it },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                    Icon(
                        painter = passwordVector, contentDescription = "Password icon",
                        tint = if (passwordVisibility.value) Color.Red else Color.Gray
                    )
                }
            },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Enter the password") },
            singleLine = true,
            visualTransformation = if (passwordVisibility.value) VisualTransformation.None
            else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(0.8f)
        )
        SpaceH()
        SpaceH()
        MainButton(name = "INICIAR SESION", backColor = Color.Red, color = Color.White) {
            navController.navigate("MenuPrincipal")
        }


    }


}