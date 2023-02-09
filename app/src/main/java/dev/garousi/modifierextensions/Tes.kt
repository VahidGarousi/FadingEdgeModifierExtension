
package dev.garousi.modifierextensions
/*

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.graphics.drawscope.Fill

fun Modifier.addFadingEdge1(
    listState: LazyListState,
    colors: List<Color>,
    position: FadingEdgePosition
) = composed {
    val shouldDrawFadingEdge = listState.isScrolledToTheEnd()
    if (shouldDrawFadingEdge) {
        object : DrawModifier {
            override fun ContentDrawScope.draw() {
                val size: Size
                val topLeft: Offset
                val brush = Brush.horizontalGradient(
                    colors = colors,
                    endX = (this.size.width * 15) / 100
                )
                when (position) {
                    FadingEdgePosition.START -> {
                        size = Size(
                            width = (this.size.width * 15) / 100,
                            height = this.size.height
                        )
                        topLeft = Offset.Zero
                    }
                    FadingEdgePosition.END -> {
                        size = Size(
                            width = (this.size.width / 1f),
                            height = this.size.height
                        )
                        topLeft = Offset(
                            x = this.size.width,
                            y = 0f
                        )
                    }
                    FadingEdgePosition.BOTTOM -> {
                        size = Size(
                            width = (this.size.width / 1f),
                            height = this.size.height
                        )
                        topLeft = Offset(
                            x = this.size.width,
                            y = this.size.height
                        )
                    }
                }
                drawContent()
                this.drawRect(
                    brush = brush,
                    topLeft = topLeft,
                    size = size,
                    style = Fill,
                    blendMode = BlendMode.Overlay
                )

            }
        }
    } else {
        Modifier
    }
}
private enum class FadingEdgePosition {
    START, END, BOTTOM
}


private fun LazyListState.isScrolledToTheEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1*/
