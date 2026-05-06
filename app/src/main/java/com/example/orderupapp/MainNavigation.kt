package com.example.orderupapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.orderupapp.model.Producto
import com.example.orderupapp.model.menuProductos
import com.example.orderupapp.screen.MenuScreen
import com.example.orderupapp.screen.OrdenScreen
import com.example.orderupapp.screen.OrderItem

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    val orderMap = rememberSaveable { mutableStateOf(mutableMapOf<Int, Int>()) }
    val mostrarDialogo = rememberSaveable { mutableStateOf(false) }

    NavHost(
        navController = navController,
        startDestination = Routes.Menu
    ) {
        composable<Routes.Menu> {
            MenuScreen(
                ordenItems = orderMap.value,
                onAgregarProducto = { producto: Producto ->
                    val actual = orderMap.value[producto.id] ?: 0
                    val nuevoMapa = orderMap.value.toMutableMap()
                    nuevoMapa[producto.id] = actual + 1
                    orderMap.value = nuevoMapa
                },
                onVerOrden = {
                    navController.navigate(Routes.Orden)
                },
                orderMap = orderMap.value.toMutableMap(),
                onAddProduct = Unit
            )
        }

        composable<Routes.Orden> {
            val orderItems = orderMap.value.toList().mapNotNull { (id, cantidad) ->
                menuProductos.find { it.id == id }?.let { OrderItem(it, cantidad) }
            }

            OrdenScreen(
                orderItems = orderItems,
                onEliminarProducto = { productId: Int ->
                    val nuevoMapa = orderMap.value.toMutableMap()
                    nuevoMapa.remove(productId)
                    orderMap.value = nuevoMapa
                },
                onConfirmarOrden = {
                    mostrarDialogo.value = true
                },
                onRegresar = {
                    navController.popBackStack()
                }
            )
        }
    }

    if (mostrarDialogo.value) {
        AlertDialog(
            onDismissRequest = { mostrarDialogo.value = false },
            title = { Text("¡Orden Confirmada!") },
            text = { Text("La orden ha sido creada exitosamente.") },
            confirmButton = {
                Button(
                    onClick = {
                        orderMap.value = mutableMapOf()
                        mostrarDialogo.value = false
                        navController.popBackStack()
                    }
                ) {
                    Text("Aceptar")
                }
            }
        )
    }
}