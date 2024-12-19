plugins {
    alias(libs.plugins.native.template.android)
    alias(libs.plugins.native.template.compose)
}

android {
    buildFeatures {
        androidResources = true
    }
}