plugins {
    `kotlin-dsl`
}

group = "uz.cdti.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("application") {
            id = "virtualbank.android"
            implementationClass = "BaseAndroidLibraryConventionPlugin"
        }
        register("compose") {
            id = "virtualbank.compose"
            implementationClass = "ComposeConventionPlugin"
        }
        register("feature") {
            id = "virtualbank.feature"
            implementationClass = "FeatureConventionPlugin"
        }
    }
}