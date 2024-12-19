import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import com.example.convention.findLibrary
import com.example.convention.getPluginId
import com.example.convention.implementation
import uz.cdti.convention.libs

class FeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.getPluginId("virtualbank.android"))
                apply(libs.getPluginId("virtualbank.compose"))
            }
            dependencies {
//                implementation(project(":core:base"))
//                implementation(project(":core:core-ui"))
//                implementation(project(":core:data"))
                implementation(findLibrary("immutable-list"))
                implementation(findLibrary("navigation.compose"))
                implementation(findLibrary("ktor.client.core"))
            }
        }
    }
}