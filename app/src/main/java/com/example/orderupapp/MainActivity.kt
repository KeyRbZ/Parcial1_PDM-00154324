package com.example.orderupapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
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

const val pupusaImg = "https://comedera.com/wp-content/uploads/sites/9/2023/05/Pupusas-de-quesoshutterstock_1803502444.jpg"
const val cafeImg = "https://i.blogs.es/139e0f/cafe-americano2/840_560.jpeg"
const val chocoImg = "https://cocinaconcoqui.com/wp-content/uploads/2025/12/chocolate-calientecasero-500x500.jpg"
const val cocaImg = "https://d23esi1h40dfmi.cloudfront.net/wpcontent/uploads/2025/08/01124509/00732.jpg"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            "OrderUpApp"
                }
            }
        }

@Composable
fun MenuPupuseria() {
    var expanded by rememberSaveable() { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .padding(16.dp)
            .border(16.dp)
    ) {
        Boton(onClick = { expanded = !expanded }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Otra opción de pupusa o bebida")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Opcion 1") },
                onClick = { "Pupusa de queso" }
            )
            DropdownMenuItem(
                text = { Text("Opcion 2") },
                onClick = { "Pupusa de frijol con queso" }
            )
            DropdownMenuItem(
                text = { Text("Opcion 3") },
                onClick = { "Pupusa revuelta" }
            )
            DropdownMenuItem(
                text = { Text("Opcion 4") },
                onClick = { "Pupusa de frijol con queso" }
        }
    }
}


@Composable
fun Boton(onClick: () -> Unit, content: @Composable () -> Unit) {
    TODO("No se agrega contenido")
}


@Composable
fun Menu (name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Precio $name!",
        modifier = modifier
    )
}

@Composable
fun MiOrden(){

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OrderUpAppTheme {
        Greeting("Android")
    }
}