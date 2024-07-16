package com.example.dev_shoes.views


import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dev_shoes.assets.generateMaterialItems
import com.example.dev_shoes.components.MainIconButton
import com.example.dev_shoes.components.TitleBar
import com.example.dev_shoes.model.dto.MaterialItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Materiales(navController: NavController) {
    val itemsList = generateMaterialItems()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Materiales") },
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
        ContentMaterialesView(navController, itemsList)
    }
}

@Composable
fun ContentMaterialesView(navController: NavController, itemsList: List<MaterialItem>) {
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
    items: List<MaterialItem>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(modifier = modifier.padding(vertical = 5.dp)) {
        items(items = items) { item ->
            Greeting(item = item)
        }
    }
}

// ui for card
@Composable
private fun Greeting(item: MaterialItem) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ), modifier = Modifier.padding(vertical = 5.dp, horizontal = 14.dp)
    ) {
        CardContent(item = item)
    }
}

// ui for card content
@Composable
private fun CardContent(item: MaterialItem) {
    var expanded by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .padding(2.dp)
            .animateContentSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = "ID: ${item.id}")
            Text(
                text = item.name,
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )
            if (expanded) {
                Box(
                    modifier = Modifier
                        //.background(Color.Gray) // Enciarra al cuadro
                        .fillMaxSize()
                ) {
                    Column {
                        Row {
                            InfoBox("ID")
                            Spacer(modifier = Modifier.width(4.dp)) // Espacio entre los cuadros
                            InfoBox(item.id.toString())
                        }
                        Spacer(modifier = Modifier.height(4.dp)) // Espacio entre las filas
                        Row {
                            InfoBox("Nombre")
                            Spacer(modifier = Modifier.width(4.dp)) // Espacio entre los cuadros
                            InfoBox(item.name)
                        }
                        Spacer(modifier = Modifier.height(4.dp)) // Espacio entre las filas
                        Row {
                            InfoBox("Descripcion")
                            Spacer(modifier = Modifier.width(4.dp)) // Espacio entre los cuadros
                            InfoBox(item.description)
                        }
                    }
                }

            }

        }

        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Filled.ArrowDropDown,
                contentDescription =
                if (expanded) {
                    "show less"
                } else {
                    "show more"
                }
            )
        }
    }
}

@Composable
fun InfoBox(info: String) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .border(1.dp, Color.Black)
            .width(125.dp).height(40.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = info)
    }
}


