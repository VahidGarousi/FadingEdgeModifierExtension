package dev.garousi.modifierextensions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import dev.garousi.modifierextensions.ui.theme.ModifierExtensionsTheme

@Composable
fun ProductList(
    products: List<Product>
) {
    val state = rememberLazyListState()
    LazyRow(
        state = state,
        modifier = Modifier
            .fillMaxWidth()
            .addFadingEdge(
                listState = state,
                colorStops = arrayOf(
                    0.0f to Color.Black,
                    0.5f to Color.Black,
                    1.0f to Color.Transparent
                )
            ),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(
            items = products,
            key = { it.id }
        ) { product ->
            Product(product = product)
        }
    }
}

@Composable
@Preview(name = "LTR", locale = "en")
@Preview(name = "RTL", locale = "fa")
fun ProductListPreview(
    @PreviewParameter(ProductListPreviewParameter::class) products: List<Product>
) {
    ModifierExtensionsTheme {
        ProductList(products = products)
    }
}









