plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-android")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "com.bobafett.instantmenu.android"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
        kotlinCompilerVersion = "1.5.21"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation( "io.insert-koin:koin-android:3.1.4")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")
    implementation("com.google.android.gms:play-services-instantapps:18.0.0")
    implementation("androidx.compose.ui:ui:${findProperty("version.compose")}")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:${findProperty("version.compose")}")
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:${findProperty("version.compose")}")
    // Material Design
    implementation("androidx.compose.material:material:${findProperty("version.compose")}")
    // Material design icons
    implementation("androidx.compose.material:material-icons-core:${findProperty("version.compose")}")
    implementation("androidx.compose.material:material-icons-extended:${findProperty("version.compose")}")
    // Integration with observables
    implementation("androidx.compose.runtime:runtime-livedata:${findProperty("version.compose")}")
    implementation("androidx.compose.runtime:runtime-rxjava2:${findProperty("version.compose")}")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.compose.ui:ui-tooling-preview:${findProperty("version.compose")}")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.navigation:navigation-compose:2.4.0-rc01")

    api("androidx.navigation:navigation-fragment-ktx:2.3.5")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${findProperty("version.compose")}")

}