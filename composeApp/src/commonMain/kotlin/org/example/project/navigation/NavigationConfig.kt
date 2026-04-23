package org.example.project.navigation

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic


val appSavedStateConfiguration : SavedStateConfiguration = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class){
            subclass(Screen.Home::class, Screen.Home.serializer())
            subclass(Screen.MapView::class, Screen.MapView.serializer())
            subclass(Screen.Compass::class, Screen.Compass.serializer())
            subclass(Screen.LiveStreetView::class, Screen.LiveStreetView.serializer())

            // Add these two
            subclass(Screen.MapDetail::class, Screen.MapDetail.serializer())
            subclass(Screen.MapSettings::class, Screen.MapSettings.serializer())
        }
    }
}