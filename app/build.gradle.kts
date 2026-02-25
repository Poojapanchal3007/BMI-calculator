plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.bmicalculator"
    compileSdk = 36 // Correct way to specify compile SDK version

    defaultConfig {
        applicationId = "com.example.bmicalculator"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Core KTX and lifecycle libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.activity.compose)

    // Compose libraries with BOM for version management
    implementation(platform(libs.androidx.compose.bom)) // BOM for Compose version management
    implementation(libs.androidx.compose.ui)  // Core Compose UI components
    implementation(libs.androidx.compose.ui.graphics)  // For graphics in Compose
    implementation(libs.androidx.compose.ui.tooling.preview)  // For Compose Preview
    implementation(libs.androidx.compose.material3)  // Material3 UI components

    // Testing dependencies
    testImplementation(libs.junit)  // JUnit for unit testing
    androidTestImplementation(libs.androidx.junit)  // JUnit for Android tests
    androidTestImplementation(libs.androidx.espresso.core)  // Espresso for UI testing
    androidTestImplementation(platform(libs.androidx.compose.bom)) // Ensure Compose versions in tests
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)  // UI tests for Compose with JUnit

    // Debugging tools for Compose
    debugImplementation(libs.androidx.compose.ui.tooling)  // UI tooling support
    debugImplementation(libs.androidx.compose.ui.test.manifest)  // Manifest for testing
}