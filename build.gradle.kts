plugins {
    kotlin("jvm") version "2.0.10"
    application
    id("org.openjfx.javafxplugin") version "0.0.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.openjfx:javafx-controls:18")
    implementation("org.openjfx:javafx-fxml:18")
    implementation("org.openjfx:javafx-graphics:18")
    implementation("org.openjfx:javafx-base:18")
    implementation("org.openjfx:javafx-media:18")
    implementation("org.openjfx:javafx-swing:18")
    implementation("org.openjfx:javafx-web:18")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "18"
}

application {
    mainClass.set("MainKt")
}

javafx {
    version = "18"
    modules = listOf(
        "javafx.controls",
        "javafx.fxml",
        "javafx.graphics",
        "javafx.base",
        "javafx.media",
        "javafx.swing",
        "javafx.web"
    )
}