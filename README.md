# NativeTemplate

This is an Android application built with Kotlin and Jetpack Compose. It serves as a template to kickstart your new project with a modular architecture.

## Project Structure

The project follows a modular approach:

-   **app**: The main application module.
-   **core**: Contains core functionalities like UI components, data handling, and base classes.
    -   `core-ui`: Shared Jetpack Compose UI elements and themes.
    -   `data`: Repositories, data sources, and network clients.
    -   `base`: Common utility classes and base Android components.
-   **feature**: Contains individual feature modules.
    -   `splash`: The splash screen feature.
-   **build-logic**: Custom Gradle convention plugins for consistent build configurations across modules.

## Convention Plugins

The `build-logic` module houses custom convention plugins to ensure consistency and simplify build configurations across different modules. Key plugins include:

-   **`BaseAndroidLibraryConventionPlugin.kt`**: Applied to Android library modules (e.g., `core-ui`, `data`, `base`). It likely configures common Android settings, Kotlin Android extensions, and default dependencies.
-   **`ComposeConventionPlugin.kt`**: Used by modules that implement Jetpack Compose UIs. This plugin typically enables Jetpack Compose, sets up Compose options, and adds common Compose dependencies.
-   **`FeatureConventionPlugin.kt`**: Designed for feature modules (e.g., `splash`). It might configure dependencies common to all feature modules, such as navigation components or ViewModel support, and apply other feature-specific settings.

To use these plugins, apply them in the `plugins {}` block of a module's `build.gradle.kts` file. For example, a feature module might have:
```kotlin
plugins {
    id("my.project.template.feature") // Assuming 'my.project.template' is the base for your plugin IDs
    id("my.project.template.compose")
}
```
*(Note: The exact plugin IDs will depend on how they are defined in `build-logic/build.gradle.kts` and the `*-gradle-plugin.kts` files).*

## Getting Started

1.  Clone the repository.
2.  Open the project in Android Studio.
3.  Build and run the application.

## Customizing the Template

This project is designed to be a starting point. Here are some common areas you'll want to customize:

-   **Application ID & Naming**:
    -   Change the `applicationId` in `app/build.gradle.kts`.
    -   Rename packages to reflect your project's naming convention.
    -   Update the application name in `app/src/main/res/values/strings.xml`.
-   **Theme & Styling**:
    -   Modify colors, typography, and shapes in the `core/core-ui` module, typically within files like `Theme.kt`, `Color.kt`, `Type.kt`, and `Shape.kt`.
-   **Data Sources**:
    -   Adapt or replace the example data sources, repositories, and network clients in the `core/data` module to fit your application's data requirements.
-   **Feature Modules**:
    -   Remove or modify the example `splash` feature module.
    -   Add new feature modules under the `feature` directory as outlined below.
-   **Icons & Branding**:
    -   Replace the default launcher icons in `app/src/main/res/mipmap-*` directories with your own app icons.

## Further Development

To add new features, create a new module under the `feature` directory. Apply the necessary convention plugins from `build-logic` to ensure consistency.

