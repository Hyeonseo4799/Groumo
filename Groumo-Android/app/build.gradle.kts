@file:Suppress("DSL_SCOPE_VIOLATION")

import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    kotlin("kapt")
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.ragdoll.groumo"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.ragdoll.groumo"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "KAKAO_NATIVE_APP_KEY", getApiKey("kakao_native_app_key"))
        resValue("string", "kakao_oauth_host", getApiKey("kakao_oauth_host"))
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":feature:login"))
    implementation(project(":feature:group"))
    implementation(project(":feature:search"))
    implementation(project(":feature:home"))
    implementation(project(":feature:mypage"))
    implementation(project(":feature:trading"))
    implementation(project(":core:designsystem"))
    implementation(project(":core:common"))

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.activity)
    implementation(libs.kakao.user)
    implementation(libs.hilt.android)
    implementation(libs.androidx.hilt)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.navigation.animation)
    implementation(libs.androidx.material.icons)
    kapt(libs.hilt.compiler)
}

fun getApiKey(propertyKey: String) = gradleLocalProperties(rootDir).getProperty(propertyKey)