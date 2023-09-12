package com.kodeco.android.coordplot.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun PlotSurface() {
    var xPercentage: Float by remember { mutableStateOf(0.5f) }
    var yPercentage: Float by remember { mutableStateOf(0.5f) }

    fun getRounded(value: Float) : String? {
        val format = DecimalFormat("#.#")
        format.roundingMode = RoundingMode.DOWN
        return format.format(value)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Map(
                xPercent = xPercentage,
                yPercent = yPercentage
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "X axis: ${getRounded(xPercentage)}",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(
                            width = 120.dp,
                            height = 20.dp
                        )
                )
                Slider(
                    value = xPercentage,
                    valueRange = 0f..1.0f,
                    onValueChange = { xValue ->
                        xPercentage = xValue
                        println(xValue)
                    },
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Y axis: ${getRounded(yPercentage)}",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(
                            width = 120.dp,
                            height = 20.dp
                        )
                )
                Slider(
                    value = yPercentage,
                    valueRange = 0f..1.0f,
                    onValueChange = { yValue ->
                        yPercentage = yValue
                        println(yValue)
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PlotSurfacePreview() {
    MyApplicationTheme {
        PlotSurface()
    }
}