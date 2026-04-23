This is a Kotlin Multiplatform project targeting Android, iOS.

# 📱 Compose Multiplatform Navigation Sample (Nav3 + Nested Navigation)

A modern **Compose Multiplatform (CMP)** sample demonstrating how to implement **Navigation 3 API** with **nested navigation graphs**.

---

## 🚀 Features
- 🧭 Navigation 3 API integration
- 🔀 Nested Navigation (Graph inside Graph)
- 📱 Multiple Screens (Home, Details, Profile, etc.)
- ⚡ Clean architecture for navigation handling
- 🌍 Compose Multiplatform ready

---

## 🧱 Tech Stack
- Kotlin
- Jetpack Compose / Compose Multiplatform
- Navigation 3 (Nav3)

---

## 📂 Dependencies Uesed
in libs.toml [versions]
```kotlin
# For native Android
navigation3 = "1.0.0"
# For Compose Multiplatform
cmpNavigation3 = "1.0.0-alpha05"
```

in libs.toml  [libraries]
```kotlin
# For Compose Multiplatform
jetbrains-navigation3-ui = { module = "org.jetbrains.androidx.navigation3:navigation3-ui", version.ref = "cmpNavigation3" }
jetbrains-lifecycle-viewmodel-nav3 = { module = "org.jetbrains.androidx.lifecycle:lifecycle-viewmodel-navigation3", version.ref = "androidx-lifecycle" }
jetbrains-lifecycle-viewmodel = { module = "org.jetbrains.androidx.lifecycle:lifecycle-viewmodel", version.ref = "androidx-lifecycle"}

# For native Android
androidx-navigation3-runtime = { module = "androidx.navigation3:navigation3-runtime", version.ref = "navigation3" }
androidx-navigation3-ui = { module = "androidx.navigation3:navigation3-ui", version.ref = "navigation3" }

kotlinx-serialization-json = { module = "org.jetbrains.kotlinx:kotlinx-serialization-json", version = "1.9.0" }
```
in libs.toml [plugins]
```kotlin
kotlin-serialization = { id = "org.jetbrains.kotlin.plugin.serialization", version.ref = "kotlin" }
```

in common gradle
```kotlin
            implementation(libs.jetbrains.navigation3.ui)
            implementation(libs.jetbrains.lifecycle.viewmodel.nav3)
            implementation(libs.jetbrains.lifecycle.viewmodel)
            implementation(libs.kotlinx.serialization.json)
```

### Build and Run Android Application

To build and run the development version of the Android app, use the run configuration from the run widget
in your IDE’s toolbar or build it directly from the terminal:
- on macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug
  ```

### Build and Run iOS Application

To build and run the development version of the iOS app, use the run configuration from the run widget
in your IDE’s toolbar or open the [/iosApp](./iosApp) directory in Xcode and run it from there.

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…
