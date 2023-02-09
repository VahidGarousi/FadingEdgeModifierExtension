package dev.garousi.modifierextensions

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp

private const val TAG = "FadingEdgeModifier"
fun Modifier.addFadingEdge(
    listState: LazyListState,
    vararg colorStops: Pair<Float, Color>,
) = composed {
    val shouldDrawFadingEdge = !listState.isScrolledToTheEnd()
    val alpha by animateFloatAsState(
        targetValue = if (shouldDrawFadingEdge) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000,
            easing = LinearOutSlowInEasing
        )
    )
    val layoutInfo = derivedStateOf { listState.layoutInfo }
    val orientation = remember { layoutInfo.value.orientation }
    val isReserveLayout = remember { layoutInfo.value.reverseLayout }
    val direction = LocalLayoutDirection.current
    val density = LocalDensity.current
    object : DrawModifier {
        override fun ContentDrawScope.draw() {
            val endSize: Size
            val endTopEndLeft: Offset

            val startSize: Size
            val startTopEndLeft: Offset


            val brush = Brush.horizontalGradient(
                colorStops = colorStops
            )
            val x1 = ((0.90f) * this.size.width)
            val y1 = 0f

            val x2 = this.size.width
            val y2 = this.size.height


            endTopEndLeft = Offset(
                x = x1,
                y = y1
            )

            endSize = Size(
                width = this.size.width - x1, // 100
                height = this.size.height
            )

            startTopEndLeft = Offset(
                x = 0f,
                y = 0f
            )

            startSize = Size(
                width = ((0.1f) * this.size.width),
                height = this.size.height
            )

            drawRect(Color.DarkGray)
            drawCircle(
                color = Color.Yellow,
                radius = density.run { 4.dp.toPx() },
                center = center
            )
            drawEndCircles(x1, y1, x2)
            drawStartCircles(x1, y1, x2)
//            drawContent()
            // end rect
            this.drawRect(
                brush = brush,
                topLeft = endTopEndLeft,
                size = endSize,
                style = Fill,
                blendMode = BlendMode.Overlay,
                alpha = alpha
            )
            // start rect
            this.drawRect(
                brush = brush,
                topLeft = startTopEndLeft,
                size = startSize,
                style = Fill,
                blendMode = BlendMode.Overlay,
                alpha = alpha
            )
        }
    }
}

private fun ContentDrawScope.drawStartCircles(x1: Float, y1: Float, x2: Float) {
    // x1,y1
    drawCircle(
        color = Color.White,
        radius = density.run { 4.dp.toPx() },
        center = Offset(
            x = 0f,
            y = 0f
        )
    )
    // x2,x3
    drawCircle(
        color = Color.Red,
        radius = density.run { 4.dp.toPx() },
        center = Offset(
            x = ((0.1f) * this.size.width),
            y = 0f
        )
    )
    //x3,y3
    drawCircle(
        color = Color.Blue,
        radius = density.run { 4.dp.toPx() },
        center = Offset(
            x = 0f,
            y = this.size.height
        )
    )
    // x4,y4
    drawCircle(
        color = Color.Green,
        radius = density.run { 4.dp.toPx() },
        center = Offset(
            x = ((0.1f) * this.size.width),
            y = this.size.height
        )
    )
}

private fun ContentDrawScope.drawEndCircles(
    x1: Float,
    y1: Float,
    x2: Float
) {
    // x1,y1
    drawCircle(
        color = Color.White,
        radius = density.run { 4.dp.toPx() },
        center = Offset(
            x = x1,
            y = y1
        )
    )
    // x2,x3
    drawCircle(
        color = Color.Red,
        radius = density.run { 4.dp.toPx() },
        center = Offset(
            x = x2,
            y = 0f
        )
    )
    //x3,y3
    drawCircle(
        color = Color.Blue,
        radius = density.run { 4.dp.toPx() },
        center = Offset(
            x = x1,
            y = this.size.height
        )
    )
    // x4,y4
    drawCircle(
        color = Color.Green,
        radius = density.run { 4.dp.toPx() },
        center = Offset(
            x = x2,
            y = this.size.height
        )
    )
}

enum class FadingEdgePosition {
    START, END, BOTTOM
}


fun LazyListState.isScrolledToTheEnd() =
    layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1