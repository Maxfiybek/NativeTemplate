import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import com.example.convention.findLibrary
import com.example.convention.getPluginId
import com.example.convention.implementation
import uz.cdti.convention.libs

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