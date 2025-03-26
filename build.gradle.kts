import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
}

plugins {
    val kotlinVersion = "1.9.25"

    kotlin("jvm") version kotlinVersion apply false
    kotlin("plugin.spring") version kotlinVersion apply false
    kotlin("plugin.jpa") version kotlinVersion apply false

    id("org.springframework.boot") version "3.3.10" apply false
    id("io.spring.dependency-management") version "1.1.7" apply false
}

allprojects {
    group = "by.krivosheev"
    version = "1.0.0"

    val javaVersion: String by project

    tasks {
        withType(JavaCompile::class) {
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
        }

        withType(KotlinCompile::class) {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = javaVersion
                incremental = false
            }
        }

        withType<Test> {
            useJUnitPlatform()
        }
    }
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }
}
