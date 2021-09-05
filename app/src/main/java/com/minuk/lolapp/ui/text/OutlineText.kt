package com.minuk.lolapp.ui.text

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun OutLinedText(
    modifier: Modifier,
    text: String,
    textColor: Color = Color.White,
    outlineColor: Color = Color.Black,
    textSize: TextUnit,
    strokeWidth: Dp = 3.dp
) {
    with(LocalDensity.current) {
        val textPaintStroke = Paint().asFrameworkPaint().apply {
            isAntiAlias = true
            style = android.graphics.Paint.Style.STROKE
            this.textSize = textSize.toPx()
            color = outlineColor.toArgb()
            this.strokeWidth = strokeWidth.toPx()
            strokeMiter = 10f
            strokeJoin = android.graphics.Paint.Join.ROUND
        }

        val textPaint = Paint().asFrameworkPaint().apply {
            isAntiAlias = true
            style = android.graphics.Paint.Style.FILL
            this.textSize = textSize.toPx()
            this.color = textColor.toArgb()
        }

        Canvas(modifier = modifier) {
            drawIntoCanvas {
                it.nativeCanvas.drawText(
                    text,
                    0f,
                    0f,
                    textPaintStroke
                )
                it.nativeCanvas.drawText(
                    text,
                    0f,
                    0f,
                    textPaint
                )
            }
        }
    }
}