package com.kodeco.android.coordplot.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.coordplot.R
import com.kodeco.android.coordplot.ui.theme.MyApplicationTheme

@Composable
fun Map(xPercent: Float, yPercent: Float) {
    Box(
        Modifier
            .size(width = 300.dp, height = 300.dp)
            .background(Color.Yellow)
    ) {
        Image(
            painter = painterResource(id = R.drawable.resource_super),
            contentDescription = "Super man",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(36.dp)
                .offset((xPercent * 300 - 18).dp, (yPercent * 300 - 18).dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    MyApplicationTheme {
        Map(xPercent = 0.5f, yPercent = 0.5f)
    }
}