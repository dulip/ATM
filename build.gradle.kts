
group = "jago"
version = "0.0.1-SNAPSHOT"

buildscript {
    val springBootVersion = "2.7.4"
    val kotlinVersion = "1.7.10"
    extra["kotlinVersion"] = kotlinVersion
    extra["springBootVersion"] = springBootVersion

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
        classpath("org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

val kotlinVersion = extra["kotlinVersion"] as String
val springBootVersion = extra["springBootVersion"] as String

apply {
    plugin("kotlin")
    plugin("kotlin-spring")
    plugin("org.springframework.boot")
    plugin("application") // used to build the jar.
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
    flatDir{
        dirs("libs")
    }
}

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-data-couchbase:$springBootVersion")

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
    implementation("org.apache.commons:commons-lang3:3.3.1")

    testImplementation(kotlin("stdlib"))
    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaExec> {
    standardInput = System.`in`
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

// Define where is the main class
application {
    mainClass.set("MainKt")
}
