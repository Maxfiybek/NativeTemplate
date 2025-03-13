plugins {
    `kotlin-dsl`
}

group = "com.example.nativetemplate.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("application") {
            id = "android.plugin.id"
            implementationClass = "BaseAndroidLibraryConventionPlugin"
        }
        register("compose") {
            id = "compose.plugin.id"
            implementationClass = "ComposeConventionPlugin"
        }
        register("feature") {
            id = "feature.plugin.id"
            implementationClass = "FeatureConventionPlugin"
        }
    }
}