object Lib {
    const val Hilt_Version = "2.38.1"
    const val Retrofit_Version = "2.9.0"
    const val Compose_Version = "1.0.1"

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:$Retrofit_Version"
        const val retrofit_gson = "com.squareup.retrofit2:converter-gson:$Retrofit_Version"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:$Hilt_Version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$Hilt_Version"
    }

    object Compose {
        const val activity = "androidx.activity:activity-compose:1.3.1"
        const val test = "androidx.compose.ui:ui-test-junit4:$Compose_Version"
        const val tooling = "androidx.compose.ui:ui-tooling:$Compose_Version"
        const val preview = "androidx.compose.ui:ui-tooling-preview:$Compose_Version"
        const val material = "androidx.compose.material:material:$Compose_Version"
    }
}