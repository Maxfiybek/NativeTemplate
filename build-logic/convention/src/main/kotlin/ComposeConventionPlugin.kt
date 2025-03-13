import com.example.nativetemplate.conventions.extensions.findLibrary
import com.example.nativetemplate.conventions.extensions.getPluginId
import com.example.nativetemplate.conventions.extensions.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import com.example.nativetemplate.conventions.extensions.libs

class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.getPluginId("kotlin.compose"))
            }
            dependencies {
                val composeBom = findLibrary("androidx.compose.bom")
                implementation(platform(composeBom))
                implementation(findLibrary("androidx.compose.ui.tooling.preview"))
                implementation(findLibrary("androidx.ui"))
                implementation(findLibrary("androidx.ui.graphics"))
                implementation(findLibrary("androidx.ui.tooling.preview"))
                implementation(findLibrary("androidx.material3"))
            }
        }
    }
}