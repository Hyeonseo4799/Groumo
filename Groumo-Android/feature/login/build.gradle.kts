@file:Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("kapt")
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
}

android {
    namespace = "com.ragdoll.login"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
}

dependencies {

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.kakao.user)
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt)
    kapt(libs.hilt.compiler)
}