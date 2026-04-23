package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.rememberNavBackStack
import org.example.project.navigation.MainNavigationGraph
import org.example.project.navigation.Screen
import org.example.project.navigation.appSavedStateConfiguration


@Composable
@Preview
fun App() {
    val backStack = rememberNavBackStack(
        configuration = appSavedStateConfiguration,
        elements = arrayOf(Screen.Home)
    )
    MaterialTheme {
        MainNavigationGraph(backStack = backStack)
    }
}