package com.example.repro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      MaterialTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
          val navController = rememberNavController()

          NavHost(
              navController = navController,
              startDestination = Screen1,
          ) {
            composable<Screen1> {
              Column {
                Text(text = "Screen 1")
                Button(onClick = { navController.navigate(Screen2("test")) }) {
                  Text(text = "Go to screen 2")
                }
              }
            }

            composable<Screen2> { Text(text = "Screen 2") }
          }
        }
      }
    }
  }
}

@Serializable data object Screen1

@Serializable data class Screen2(val text: String)
