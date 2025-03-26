plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
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

dependencies {
    implementation(project(":core"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude("org.junit.vintage", "junit-vintage-engine")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testImplementation("io.zonky.test:embedded-database-spring-test:2.6.0")
    testImplementation("io.zonky.test:embedded-postgres:2.1.0")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
