package dev.garousi.modifierextensions

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.util.UUID

@Composable
fun Product(
    product: Product
) {
    Card(
        modifier = Modifier
            .size(96.dp)
            .padding(end = 8.dp),
        backgroundColor = Color.DarkGray
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            Text(text = product.name)
            Text(text = product.price.toString())
        }
    }
}



data class Product(
    val name: String = "",
    val price: Long = 0,
    val id: String = UUID.randomUUID().toString()
)
