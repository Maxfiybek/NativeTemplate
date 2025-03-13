package com.example.nativetemplate.conventions.extensions

import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.MinimalExternalModuleDependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope

internal fun VersionCatalog.getPluginId(id: String) = findPlugin(id).get().get().pluginId

internal fun DependencyHandlerScope.implementation(dependencyNotation: Any): Dependency? {
    return add("implementation", dependencyNotation)
}

internal fun Project.findLibrary(libraryName: String): Provider<MinimalExternalModuleDependency> {
    return libs.findLibrary(libraryName).get()
}