// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("org.jlleitschuh.gradle.ktlint") version "11.6.1"
    id("com.android.application") version "8.1.2" apply false
    id("com.android.library") version "8.1.2" apply false
    id("com.android.test") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
    id("com.github.ben-manes.versions") version "0.49.0"
    id("nl.littlerobots.version-catalog-update") version "0.8.1"
}

tasks.register("clean", Delete::class) {
    group = "root"
    description = "solution"
    delete(rootProject.buildDir)
    subprojects {
        delete(rootProject.layout.buildDirectory)
    }
}