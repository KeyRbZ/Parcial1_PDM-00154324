package com.example.orderupapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orderupapp.ui.theme.OrderUpAppTheme


data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val imagenUrl: String,
    val tipo: TipoProducto
)

enum class TipoProducto {
    PUPUSA,
    BEBIDA
}

val menu = listOf(
    Producto(1, "Pupusa de queso", 0.75, pupusaImg, TipoProducto.PUPUSA),
    Producto(2, "Pupusa de frijol con queso", 0.75, pupusaImg, TipoProducto.PUPUSA),
    Producto(3, "Pupusa revuelta", 1.00, pupusaImg, TipoProducto.PUPUSA),
    Producto(4, "Pupusa de chicharrón", 1.00, pupusaImg, TipoProducto.PUPUSA),
    Producto(5, "Pupusa de loroco con queso", 1.00, pupusaImg, TipoProducto.PUPUSA),
    Producto(6, "Pupusa de ayote", 0.75, pupusaImg, TipoProducto.PUPUSA),
    Producto(7, "Pupusa de espinaca", 0.85, pupusaImg, TipoProducto.PUPUSA),
    Producto(8, "Pupusa de jalapeño con queso", 1.00, pupusaImg, TipoProducto.PUPUSA),
    Producto(9, "Café", 1.00, cafeImg, TipoProducto.BEBIDA),
    Producto(10, "Chocolate", 1.50, chocoImg, TipoProducto.BEBIDA),
    Producto(11, "Coca-Cola", 1.25, cocaImg, TipoProducto.BEBIDA)
)

const val pupusaImg =
    "https://comedera.com/wp-content/uploads/sites/9/2023/05/Pupusas-de-quesoshutterstock_1803502444.jpg"
const val cafeImg = "https://i.blogs.es/139e0f/cafe-americano2/840_560.jpeg"
const val chocoImg =
    "https://cocinaconcoqui.com/wp-content/uploads/2025/12/chocolate-calientecasero-500x500.jpg"
const val cocaImg =
    "https://d23esi1h40dfmi.cloudfront.net/wpcontent/uploads/2025/08/01124509/00732.jpg"


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrderUpApp()
        }
    }
}

@Composable
fun OrderUpApp() {
    var nombre by rememberSaveable() { mutableStateOf("welcome") }
    var precio by rememberSaveable() { mutableStateOf(0) }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ScaffoldMenu() {
        var presses by rememberSaveable() { mutableIntStateOf(0) }

        Scaffold(
            topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("OrderUpApp")
                    }
                )
            },

            floatingActionButton = {
                FloatingActionButton(onClick = { presses++ }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text =
                        """
                    Pupuseria OrdeUp!
                     
                     Presiona el boton despues antes que el tiempó acabe $presses times.
                """.trimIndent(),
                )
            }
        }
    }

    @Composable
    fun WelcomeScreen(onStart: () -> Unit) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFAE0FF)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("OrderUpApp", style = MaterialTheme.typography.headlineLarge)
            Text("Ordena pupusas y bebidas")

            Spacer(modifier = Modifier.height(16.dp))

            Text("Keyri Margarita Zelada Barrientos - 00154324")

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = onStart) {
                Text("Ver menu")
            }
        }
    }


    @Composable
    fun Boton(onClick: () -> Unit, content: @Composable () -> Unit) {
        TODO("No se agrega contenido")
    }


    @Composable
    fun Menu(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Precio $name!",
            modifier = modifier
        )
    }
}
