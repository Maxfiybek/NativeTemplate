# NativeTemplate

This is an Android application built with Kotlin and Jetpack Compose.

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

## Getting Started

1.  Clone the repository.
2.  Open the project in Android Studio.
3.  Build and run the application.

## Further Development

To add new features, create a new module under the `feature` directory. Apply the necessary convention plugins from `build-logic` to ensure consistency.
