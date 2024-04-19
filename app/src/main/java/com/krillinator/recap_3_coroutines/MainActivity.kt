package com.krillinator.recap_3_coroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.krillinator.recap_3_coroutines.ui.theme.Recap_3_CoroutinesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            Recap_3_CoroutinesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Greeting("")
                        GreetingTWO(name = "")
                    }
                }
            }
        }
    }
}

@Composable
fun GreetingTWO(name: String, modifier: Modifier = Modifier) {

    // DEBUGGING COROUTINE TODO - This runs immediately on LAUNCH
    // CoroutinePractice.testONE()
    // CoroutinePractice.main()

    LaunchedEffect(key1 = true) {
        CoroutinePractice.jobTest()
        CoroutinePractice.jobTest()
    }

    Text(
        text = "Greeting TWO",
        modifier = modifier
    )



}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Text(
        text = "Greeting ONE",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Recap_3_CoroutinesTheme {
        Greeting("Android")
    }
}