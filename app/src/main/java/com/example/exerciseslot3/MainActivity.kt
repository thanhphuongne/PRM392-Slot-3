package com.example.exerciseslot3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.exerciseslot3.ui.home.HomePage
import com.example.exerciseslot3.ui.productdetail.ProductDetailPage
import com.example.exerciseslot3.ui.theme.ExerciseSlot3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExerciseSlot3Theme {
                Surface(
                    modifier = Modifier,
                    color = colorResource(id = R.color.martfury_background)
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    var currentScreen by remember { mutableStateOf("home") }

    when (currentScreen) {
        "home" -> HomePage(onNavigateToProductDetail = { currentScreen = "product_detail" })
        "product_detail" -> ProductDetailPage(onNavigateBack = { currentScreen = "home" })
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    ExerciseSlot3Theme { AppNavigation() }
}