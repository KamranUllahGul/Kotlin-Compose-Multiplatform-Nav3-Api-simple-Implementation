package org.example.project.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import org.example.project.screens.CompassScreen
import org.example.project.screens.HomeScreen
import org.example.project.screens.LiveStreetViewScreen
import org.example.project.screens.MapViewScreen

@Composable
fun MainNavigationGraph(
    backStack: NavBackStack<NavKey>,
    modifier: Modifier = Modifier
){
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
       /** transitionSpec = {
            slideInHorizontally { it } + fadeIn() togetherWith slideOutHorizontally { -it } + fadeOut()
        },

        popTransitionSpec = {
            slideInHorizontally { -it } + fadeIn() togetherWith slideOutHorizontally { it } + fadeOut()
        },*/
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Screen.Home> {
                HomeScreen(backStack = backStack)
            }
            entry<Screen.MapView> {
                MapNavigationGraph(
                    onBackToHome = { backStack.removeLastOrNull() }
                )
            }
            entry<Screen.Compass> {
                CompassScreen(onBack = { backStack.removeLastOrNull() })
            }
            entry<Screen.LiveStreetView> {
                LiveStreetViewScreen(onBack = { backStack.removeLastOrNull() })
            }
        }
    )
}