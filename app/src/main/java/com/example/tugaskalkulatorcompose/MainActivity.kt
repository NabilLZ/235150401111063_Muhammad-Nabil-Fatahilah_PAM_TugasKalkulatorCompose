package com.example.tugaskalkulatorcompose // Pastikan ini paket Anda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorApp()
        }
    }
}

@Composable
fun CalculatorApp() {
    val buttonLayout = listOf(
        listOf("C", "%", "/"),
        listOf("7", "8", "9", "*"),
        listOf("4", "5", "6", "-"),
        listOf("1", "2", "3", "+"),
        listOf("0", ".", "=")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "0",
            fontSize = 80.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            textAlign = TextAlign.End
        )
        buttonLayout.forEach { rowButtons ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowButtons.forEach { buttonSymbol ->
                    val modifier = if (buttonSymbol == "0" || buttonSymbol == "C") {
                        Modifier
                            .weight(2f)
                            .aspectRatio(2f)
                    } else {
                        Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                    }
                    CalculatorButton(symbol = buttonSymbol, modifier = modifier)
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(symbol: String, modifier: Modifier) {
    val buttonColor = when (symbol) {
        in "0".."9", "." -> Color(0xFF343434)
        in listOf("C", "%") -> Color.LightGray
        else -> Color(0xFFFF9800)
    }
    val textColor = when (symbol) {
        in listOf("C", "%") -> Color.Black
        else -> Color.White
    }
    Button(
        onClick = {},
        modifier = modifier.clip(CircleShape),
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
    ) {
        Text(text = symbol, fontSize = 32.sp, color = textColor)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorApp()
}