plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")

}

kotlin {
    android()

    listOf(
        iosX64(),
        iosArm64(),
        //iosSimulatorArm64() sure all ios dependencies support this target
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("io.insert-koin:koin-core:3.1.4")
                implementation("com.squareup.sqldelight:coroutines-extensions:${findProperty("version.sqlDelight")}")
                implementation("io.ktor:ktor-client-core:${findProperty("version.ktor")}")
                implementation("io.ktor:ktor-client-serialization:${findProperty("version.ktor")}")
                implementation("io.ktor:ktor-client-logging:${findProperty("version.ktor")}")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${findProperty("version.kotlinx.coroutines")}")
                //JSON
                implementation("io.ktor:ktor-client-mock:${findProperty("version.ktor")}")

                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:${findProperty("version.kotlinx.coroutines")}")
                implementation("io.insert-koin:koin-test:3.1.4")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:android-driver:${findProperty("version.sqlDelight")}")
                implementation("io.ktor:ktor-client-okhttp:${findProperty("version.ktor")}")
            }
        }
        val androidTest by getting {
            dependencies {

                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        //val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            //iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                //Network
                implementation("com.squareup.sqldelight:native-driver:${findProperty("version.sqlDelight")}")
                implementation("io.ktor:ktor-client-ios:${findProperty("version.ktor")}")
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        //val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            //iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 31
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 31
    }
    lint {
        isWarningsAsErrors = true
        isAbortOnError = true
    }
}

sqldelight {
    database("InstantMenuDB") {
        packageName = "com.bobafett.instantmenu.db"
    }
}