package com.example.cryptocoins.util

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Validar( error: Boolean, text :String){
    val assistiveElementText = if (error) "Error: ${text}" else "*Obligatorio"
    val assistiveElementColor = if (error) {
        MaterialTheme.colors.error
    } else {
        MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium)
    }

    Text(
        text = assistiveElementText,
        color = assistiveElementColor,
        style = MaterialTheme.typography.caption,
        modifier = Modifier.padding(start = 16.dp)
    )

}