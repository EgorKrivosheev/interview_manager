plugins {
    kotlin("jvm")
    kotlin("plugin.jpa")
    kotlin("plugin.allopen")
}

val javaVersion: String by project

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(javaVersion)
    }
}

kotlin {
    jvmToolchain(JavaLanguageVersion.of(javaVersion).asInt())
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.liquibase:liquibase-core")

    runtimeOnly("org.postgresql:postgresql")
}

tasks {
    bootJar {
        enabled = false
    }
}
