plugins {
    alias(libs.plugins.native.template.android)
    alias(libs.plugins.native.template.compose)
}

android {
    dependencies {
        implementation(libs.ktor.client.core)
        implementation(libs.ktor.client.cio)
        implementation(libs.ktor.client.okhttp)
        implementation(libs.ktor.client.logging)
        implementation(libs.ktor.client.contentNegotiation)
        implementation(libs.ktor.client.serialization.json)
        implementation(projects.core.coreUi)

        implementation(projects.core.data)
    }
}