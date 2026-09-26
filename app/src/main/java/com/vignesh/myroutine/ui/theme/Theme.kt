package com.vignesh.myroutine.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val NotebookColors = lightColorScheme(
    primary = Color(0xFF2F7D4A),
    onPrimary = Color.White,
    secondary = Color(0xFF2D73C9),
    background = Color(0xFFF7F1E5),
    surface = Color(0xFFFFFBF2),
    onBackground = Color(0xFF1E1E1E),
    onSurface = Color(0xFF1E1E1E)
)

@Composable
fun MyRoutineTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = NotebookColors,
        typography = MaterialTheme.typography,
        content = content
    )
}
