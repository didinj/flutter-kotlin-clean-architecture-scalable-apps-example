plugins {
    id("com.android.application")
    id("kotlin-android")
    // The Flutter Gradle Plugin must be applied after the Android and Kotlin Gradle plugins.
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.example.flutter_clean_arch_notes"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        // TODO: Specify your own unique Application ID (https://developer.android.com/studio/build/application-id.html).
        applicationId = "com.example.flutter_clean_arch_notes"
        // You can update the following values to match your application needs.
        // For more information, see: https://flutter.dev/to/review-gradle-config.
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            // TODO: Add your own signing config for the release build.
            // Signing with the debug keys for now, so `flutter run --release` works.
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

flutter {
    source = "../.."
}

dependencies {
    // Core
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.5")

    // Compose
    implementation("androidx.compose.ui:ui:1.7.3")
    implementation("androidx.compose.material3:material3:1.3.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.7.3")
    debugImplementation("androidx.compose.ui:ui-tooling:1.7.3")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.8.3")

    // ViewModel for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.5")

    // Activity Compose integration
    implementation("androidx.activity:activity-compose:1.9.3")

    // Unit tests
    testImplementation("junit:junit:4.13.2")

    // Android instrumented UI tests
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:1.5.0"
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    // Optional: for compose debug test manifest
    debugImplementation "androidx.compose.ui:ui-test-manifest:1.5.4"
}
