package com.example.dev_shoes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dev_shoes.views.DetailView
import com.example.dev_shoes.views.HomeView
import com.example.dev_shoes.views.ListaDeCompras
import com.example.dev_shoes.views.LoginView
import com.example.dev_shoes.views.Materiales
import com.example.dev_shoes.views.MenuPrincipal
import com.example.dev_shoes.views.RegistroDeCompras


@Composable
fun NavManager(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home") {
        composable("Home"){
            HomeView(navController)
        }

        composable("Detail/{id}/?{opcional}", arguments = listOf(
            navArgument("id") {type = NavType.IntType},
            navArgument("opcional") {type  = NavType.StringType}
        )){
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional") ?: ""
            DetailView(navController, id, opcional)
        }

        composable("Login"){
            LoginView(navController)
        }

        composable("MenuPrincipal"){
            MenuPrincipal(navController)
        }

        composable("RegistroDeCompras"){
            RegistroDeCompras(navController)
        }

        composable("Materiales"){
            Materiales(navController)
        }

        composable("ListaDeCompras"){
            ListaDeCompras(navController)
        }

    }

}