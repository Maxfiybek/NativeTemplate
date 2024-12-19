import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import com.example.convention.findLibrary
import com.example.convention.getPluginId
import com.example.convention.implementation
import uz.cdti.convention.libs

class BaseAndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.getPluginId("android.library"))
                apply(libs.getPluginId("kotlin.android"))
                apply(libs.getPluginId("kotlin.serialization"))
                apply("kotlin-parcelize")
            }
            val androidExtension = extensions.getByType<LibraryExtension>()
            val packageName = libs.findVersion("packageName").get().toString()

            with(androidExtension) {
                namespace = packageName + getNameSpace(project.path)
                compileSdk = libs.findVersion("compileSdk").get().toString().toIntOrNull()
                defaultConfig {
                    minSdk = libs.findVersion("minSdk").get().toString().toIntOrNull()
                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_21
                        targetCompatibility = JavaVersion.VERSION_21
                    }
                }
                buildFeatures {
                    androidResources = false
                }
            }
            dependencies {
                implementation(findLibrary("kotlinx.serialization.json"))
                implementation(findLibrary("koin.compose"))
                implementation(findLibrary("koin.compose.navigation"))
            }
        }
    }

    private fun getNameSpace(projectPath: String) =
        projectPath.replace(oldChar = ':', newChar = '.').replace("-", "")
}