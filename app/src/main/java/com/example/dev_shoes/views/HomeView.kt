package com.example.dev_shoes.views


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.dev_shoes.components.ActionButton

import com.example.dev_shoes.components.BotonIcono
import com.example.dev_shoes.components.BotonNormal
import com.example.dev_shoes.components.BotonNormal2
import com.example.dev_shoes.components.BotonOutline
import com.example.dev_shoes.components.BotonTexto
import com.example.dev_shoes.components.MainButton
import com.example.dev_shoes.components.Space
import com.example.dev_shoes.components.Spacito
import com.example.dev_shoes.components.TitleBar
import com.example.dev_shoes.components.TitleView


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Home View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )

                )


        },
        floatingActionButton = {
            ActionButton()

        }
    ) {
        ContentHomeView(navController)
    }



}

@Composable
fun ContentHomeView(navController: NavController) {
    val id = 123
    var opcional by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
       TitleView(name = "Home View")
        Spacito()
        TextField(
            value = opcional,
            onValueChange = {opcional = it},
            label = {Text(text="opcional")}
        )

        MainButton(name = "Detail view", backColor = Color.Red, color = Color.White) {
         navController.navigate("Detail/${id}/?${opcional}")
        }
        /*BotonNormal()
        Space()
        BotonNormal2()
        Space()
        BotonTexto()
        Space()
        BotonOutline()
        Space()
        BotonIcono()*/
    }

}

