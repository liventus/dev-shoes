package com.example.dev_shoes.views


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dev_shoes.components.ButtonMenuCustomizeHeight
import com.example.dev_shoes.components.MainButton
import com.example.dev_shoes.components.MainIconButton
import com.example.dev_shoes.components.SpaceH
import com.example.dev_shoes.components.SpaceW
import com.example.dev_shoes.components.TitleBar
import com.example.dev_shoes.components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuPrincipal(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Menu Principal") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF131000)
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()

                    }
                }

            )
        }
    ) {
        ContentMenuPrincipalView(navController)
    }
}

@Composable
fun ContentMenuPrincipalView(navController: NavController) {
    Row(
        //line for center horizontal
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(vertical = 70.dp, horizontal = 5.dp)
            .fillMaxSize()

    ) {
        ButtonMenuCustomizeHeight(
            name = "Compras",
            backColor = Color(0xFF131000),
            color = Color.White,
            modifier = Modifier
                .height(200.dp)
                .weight(1f)
        ) {
            navController.navigate("RegistroDeCompras")
        }
        SpaceW()

        ButtonMenuCustomizeHeight(
            name = "materiales",
            backColor = Color(0xFF131000),
            color = Color.White,
            modifier = Modifier
                .height(150.dp)
                .weight(1f)
        ) {
            navController.navigate("Materiales")
        }

    }
}