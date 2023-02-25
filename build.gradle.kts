import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.typesense:typesense-java:0.0.6")
}

tasks.withType(KotlinCompile::class.java).all {
    kotlinOptions {
        jvmTarget = "11"
    }
}