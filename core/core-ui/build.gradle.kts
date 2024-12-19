plugins {
    alias(libs.plugins.virtualbank.android)
    alias(libs.plugins.virtualbank.compose)
}

android {
    buildFeatures {
        androidResources = true
    }
}