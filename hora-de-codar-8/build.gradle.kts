plugins {
    kotlin("jvm") version "2.0.20" // or kotlin("multiplatform") or any other kotlin plugin
    kotlin("plugin.serialization") version "2.0.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // Kotlin coroutine dependency
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    // MongoDB Kotlin driver dependency
    implementation("org.mongodb:mongodb-driver-kotlin-coroutine:4.10.1")

    // MongoDB Logging
    //implementation("ch.qos.logback:logback-classic:1.2.11")

    // JSON serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}