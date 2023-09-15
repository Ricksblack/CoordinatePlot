package com.kodeco.android.coordplot.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun PlotSurface() {
    var xPercentage: Float by rememberSaveable { mutableFloatStateOf(0.5f) }
    var yPercentage: Float by rememberSaveable { mutableFloatStateOf(0.5f) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            Map(
                xPercent = xPercentage,
                yPercent = yPercentage
            )
            TaggedSlider(title = "X axis: ", percentage = xPercentage) { value ->
                xPercentage = value
            }
            TaggedSlider(title = "Y axis: ", percentage = yPercentage) { value ->
                yPercentage = value
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