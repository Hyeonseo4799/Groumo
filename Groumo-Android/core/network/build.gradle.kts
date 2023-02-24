@file:Suppress("DSL_SCOPE_VIOLATION")

import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    kotlin("kapt")
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.ragdoll.network"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        buildConfigField("String", "BASE_URL", gradleLocalProperties(rootDir).getProperty("base_url"))
    }
}

dependencies {

    implementation(project(":core:common"))

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt)
    implementation(libs.kotlinx.serialization)
    kapt(libs.hilt.compiler)
}