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
    val telegramApiVersion = "6.9.7.1"

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.liquibase:liquibase-core")

    implementation("org.telegram:telegrambots-spring-boot-starter:$telegramApiVersion")
    implementation("org.telegram:telegrambotsextensions:$telegramApiVersion")

    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude("org.junit.vintage", "junit-vintage-engine")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    api(kotlin("reflect"))
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.telegram:telegrambots-spring-boot-starter:$telegramApiVersion")
    api("org.telegram:telegrambotsextensions:$telegramApiVersion")
}

tasks {
    bootJar {
        enabled = false
    }
}
