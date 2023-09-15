package com.kodeco.android.coordplot.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun TaggedSlider(
    title: String,
    percentage: Float,
    onValueChanged: (Float) -> Unit
) {
    fun getRounded(value: Float) : String? {
        val format = DecimalFormat("#.#")
        format.roundingMode = RoundingMode.DOWN
        return format.format(value)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "$title: ${getRounded(percentage)}",
            modifier = Modifier
                .padding(8.dp)
                .width(120.dp)
        )
        Slider(
            value = percentage,
            valueRange = 0f..1.0f,
            onValueChange = {
                onValueChanged(it)
            },
            modifier = Modifier
                .padding(16.dp)
        )
    }
}