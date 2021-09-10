object Lib {
    const val kotlinVersion = "1.5.21"
    const val hiltVersion = "2.38.1"
    const val retrofitVersion = "2.9.0"
    const val composeVersion = "1.0.1"

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val retrofit_gson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
        const val compiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
    }

    object Compose {
        const val activity = "androidx.activity:activity-compose:1.3.1"
        const val test = "androidx.compose.ui:ui-test-junit4:$composeVersion"
        const val coil = "io.coil-kt:coil-compose:1.3.2"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:1.0.0-alpha07"
        const val liveData = "androidx.compose.runtime:runtime-livedata:$composeVersion"
        const val tooling = "androidx.compose.ui:ui-tooling:$composeVersion"
        const val preview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"
        const val material = "androidx.compose.material:material:$composeVersion"
        const val constraint = "androidx.constraintlayout:constraintlayout-compose:1.0.0-beta02"
    }
}