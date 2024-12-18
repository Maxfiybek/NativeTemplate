dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
buildscript {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "build-logic"
include(":convention")