@file:Suppress("DSL_SCOPE_VIOLATION")
plugins {
    kotlin("kapt")
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.ragdoll.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
}

dependencies {

    implementation(project(":core:network"))
    implementation(project(":core:model"))
    implementation(project(":core:common"))

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt)
    implementation(libs.androidx.paging.runtime)
    kapt(libs.hilt.compiler)
}