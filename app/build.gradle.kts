import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization")
}

android {
    compileSdk = 30
    defaultConfig {
        applicationId = "com.minuk.lolapp"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            val key: String = gradleLocalProperties(rootDir).getProperty("riot_key")
            buildConfigField("String", "RIOT_API_KEY", key)
        }
        release {
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.1"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0")
    implementation(Lib.Compose.preview)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation(Lib.Compose.viewModel)
    implementation(Lib.Compose.liveData)
    implementation(Lib.Compose.activity)
    implementation(Lib.Compose.constraint)
    implementation(Lib.Compose.coil)
    implementation(Lib.Compose.material)

    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation(Lib.Compose.test)
    debugImplementation(Lib.Compose.tooling)

    implementation(Lib.Network.retrofit)
    implementation(Lib.Network.retrofit_gson)

    implementation(Lib.Hilt.hilt)
    kapt(Lib.Hilt.compiler)
}