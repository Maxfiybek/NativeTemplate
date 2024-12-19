plugins {
    alias(libs.plugins.virtualbank.android)
    alias(libs.plugins.ksp)
}
android {
    dependencies {
        implementation(libs.room.runtime)
        ksp(libs.room.compiler)
        implementation(libs.room.ktx)
        implementation(libs.room.paging)
    }
}