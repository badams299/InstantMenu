buildscript {
    val compose_version by extra("1.0.5")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("org.jetbrains.kotlin:kotlin-serialization:${findProperty("version.kotlin")}")
        classpath("com.android.tools.build:gradle:${findProperty("version.androidGradlePlugin")}")
        classpath("com.squareup.sqldelight:gradle-plugin:${findProperty("version.sqlDelight")}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}