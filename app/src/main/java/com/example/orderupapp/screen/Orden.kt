package com.example.orderupapp.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.orderupapp.components.PedidoItem
import com.example.orderupapp.screen.OrderItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdenScreen(
    orderItems: List<OrderItem>,  // ← OrderItem importado
    onEliminarProducto: (Int) -> Unit,
    onConfirmarOrden: () -> Unit,
    onRegresar: () -> Unit
) {
    val totalGeneral = orderItems.sumOf { it.producto.precio * it.cantidad }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mi Orden") },
                navigationIcon = {
                    IconButton(onClick = onRegresar) {
                        Text("←", fontSize = 24.sp)
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (orderItems.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text("No hay productos en la orden")
                    Text("Agrega pupusas desde el menú")
                }
            } else {
                LazyColumn(
                    modifier = Modifier.weight(1f),
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(8.dp)
                ) {
                    items(orderItems.size) { index ->
                        val item = orderItems[index]
                        PedidoItem(
                            producto = item.producto,
                            cantidad = item.cantidad,
                            onEliminar = { onEliminarProducto(item.producto.id) }
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Total: $${String.format("%.2f", totalGeneral)}",
                        fontSize = 20.sp
                    )
                    Button(
                        onClick = onConfirmarOrden,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Confirmar Orden")
                    }
                }
            }
        }
    }
}