package com.example.clipper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clipper.ui.theme.ClipperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClipperTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "there",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    fun process(processor: (String) -> Int) {
        val result = processor("one")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var count by remember { mutableIntStateOf(0) }
    Spacer(modifier = Modifier.height(66.dp))
    Row(modifier = Modifier.padding(44.dp)) {
        Button(onClick = { count++ }, modifier = Modifier.width(88.dp)) { }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = "Tune on $name")
            Text(text = "wherever you go!")
            Text(text = "score is $count")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClipperTheme {
        Greeting("Android")
    }
}