package com.example.orderupapp.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.orderupapp.model.Producto
import com.example.orderupapp.model.menuProductos

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    ordenItems: Map<Int, Int>,
    onAgregarProducto: (Producto) -> Unit,
    onVerOrden: () -> Unit,
    orderMap: MutableMap<Int, Int>,
    onAddProduct: Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("OrderUp! - Menú") },
                actions = {
                    androidx.compose.material3.IconButton(
                        onClick = onVerOrden
                    ) {
                        val totalItems = ordenItems.values.sum()
                        Text(text = "🛒 $totalItems", fontSize = 18.sp)
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(menuProductos.size) { index ->
                val producto = menuProductos[index]
                val cantidadActual = ordenItems[producto.id] ?: 0

                ProductoItem(
                    producto = producto,
                    cantidad = cantidadActual,
                    onClick = { onAgregarProducto(producto) }
                )
            }
        }
    }
}

@Composable
fun ProductoItem(
    producto: Producto,
    cantidad: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = producto.imagenUrl,
                contentDescription = producto.nombre,
                modifier = Modifier.size(60.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 12.dp)
            ) {
                Text(
                    text = producto.nombre,
                    fontSize = 16.sp
                )
                Text(
                    text = "$${producto.precio}",
                    fontSize = 14.sp
                )
            }

            if (cantidad > 0) {
                Text(
                    text = "x$cantidad",
                    fontSize = 18.sp
                )
            }
        }
    }
}