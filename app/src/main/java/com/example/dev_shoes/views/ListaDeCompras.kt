package com.example.dev_shoes.views


import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.data.R
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dev_shoes.assets.generateListaDeCompraItems
import com.example.dev_shoes.assets.generateMaterialItems
import com.example.dev_shoes.components.ActionButton
import com.example.dev_shoes.components.MainButton
import com.example.dev_shoes.components.MainIconButton
import com.example.dev_shoes.components.SpaceH
import com.example.dev_shoes.components.TitleBar
import com.example.dev_shoes.components.TitleView
import com.example.dev_shoes.model.dto.RegistroDeComprasDTO
import com.example.dev_shoes.model.dto.listaDeComprasDTO

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaDeCompras(navController: NavController) {
    val itemsList = generateListaDeCompraItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Lista de compras") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color(0xFF131000)
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()

                    }
                }

            )
        }, floatingActionButton = {
            ActionButton()

        }
    ) {
        ContentListaDeComprasView(navController, itemsList)
    }
}

@Composable
fun ContentListaDeComprasView(navController: NavController, itemsList: List<listaDeComprasDTO>){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Greetings(itemsList)

    }
}



// list of items
@Composable
private fun Greetings(
    items: List<listaDeComprasDTO>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = items) {item ->
            Greeting(item = item)
        }
    }
}
// ui for card
@Composable
private fun Greeting(item: listaDeComprasDTO) {
    Card(colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.primary
    ), modifier = Modifier.padding(vertical = 4.dp, horizontal = 4.dp)) {
        CardContent(item = item)
    }
}

// ui for card content
@Composable
private fun CardContent(item: listaDeComprasDTO) {
    var expanded by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "ID: ${item.id}")
            Text(
                text =  item.name,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )
            if (expanded) {
                Text(text = "sdad")
                Text(text = "ID: ${item.id}")
            }


        }


        IconButton(onClick = { expanded = !expanded }) {
            Icon(imageVector = if(expanded) Icons.Filled.Edit else Icons.Filled.Home , contentDescription = if (expanded) {
                "show less"
            } else {
                "show more"
            })
        }


    }
}