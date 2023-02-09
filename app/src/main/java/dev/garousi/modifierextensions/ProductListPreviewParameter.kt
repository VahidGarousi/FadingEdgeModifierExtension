package dev.garousi.modifierextensions

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class ProductListPreviewParameter : PreviewParameterProvider<List<Product>> {
    override val values: Sequence<List<Product>> = sequenceOf(arrayListOf<Product>().apply {
        repeat(10) { index ->
            add(Product(name = "Apple $index", price = 12344))
        }
    })
}