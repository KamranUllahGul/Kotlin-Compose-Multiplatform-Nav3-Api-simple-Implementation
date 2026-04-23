package org.example.project.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen : NavKey{

    @Serializable
    data object Home: Screen

    @Serializable
    data object MapView: Screen
    @Serializable
    data object Compass: Screen
    @Serializable
    data object LiveStreetView : Screen

    /**      ===  MapView Sub-Screens ===   */
    @Serializable
    data object MapDetail : Screen

    @Serializable
    data object MapSettings : Screen



}
