// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
}

tasks.register("createFeatureModule") {
    group = "feature"
    description = "Creates new simple feature module"

    doLast {
        val moduleName = project.properties["featureName"]?.toString()
            ?: throw GradleException("Please specify the feature module name by using -PfeatureName=featureName")
        val projectBasePackage = libs.versions.packageName.get()
        val featurePath = "feature/$moduleName"
        val modulePackageName = "$projectBasePackage/$moduleName".replace(".", "/")
        val featureGradleContent = """
            plugins {
                alias(libs.plugins.native.template.feature)
            }
        """.trimIndent()
        createModule(dir = file(featurePath), buildContent = featureGradleContent, packagePath = modulePackageName)
        registerToSettingsFile(moduleName)
        println("Feature module '$moduleName' created successfully at $featurePath")
    }
}
private fun createModule(dir: File, buildContent: String, packagePath: String) {
    dir.apply {
        mkdirs()
        file("$this/build.gradle.kts").writeText(buildContent)
        file("$this/src/commonMain/kotlin/$packagePath").mkdirs()
    }
}

private fun registerToSettingsFile(moduleName: String) {
    val settingsFile = file("settings.gradle.kts")
    val includeLines = """
        include(":feature:$moduleName")
    """.trimIndent()
    if (!settingsFile.readText().contains("feature:$moduleName")){
        settingsFile.appendText("\n$includeLines")
    }
}
