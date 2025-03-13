import com.example.nativetemplate.conventions.extensions.findLibrary
import com.example.nativetemplate.conventions.extensions.getPluginId
import com.example.nativetemplate.conventions.extensions.implementation
import com.example.nativetemplate.conventions.extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class FeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.getPluginId("native.template.android"))
                apply(libs.getPluginId("native.template.compose"))
            }
            dependencies {
                implementation(project(":core:base"))
                implementation(project(":core:core-ui"))
                implementation(project(":core:data"))
                implementation(findLibrary("immutable-list"))
                implementation(findLibrary("navigation.compose"))
                implementation(findLibrary("ktor.client.core"))
            }
        }
    }
}