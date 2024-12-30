package com.example.fusionailabs

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.fusionailabs.ui.theme.FusionAiLabsTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Edge-to-edge rendering enable karna
        setContent {
            FusionAiLabsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WebViewScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun WebViewScreen(modifier: Modifier = Modifier) {
    // WebView ko AndroidView ke andar embed kiya
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true // JavaScript enable kiya
                webViewClient = WebViewClient() // WebViewClient set kiya
                loadUrl("https://fusionailabs.com/") // URL load kiya
            }
        },
        modifier = modifier.fillMaxSize(),
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FusionAiLabsTheme {
        Greeting(name = "Android")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
