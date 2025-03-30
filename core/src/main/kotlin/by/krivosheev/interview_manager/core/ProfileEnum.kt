package by.krivosheev.interview_manager.core

/**
 * Типы сущности "Профиль пользователя".
 */
enum class ProfileEnum(val value: String) {
    JAVA("java"),
    KOTLIN("kotlin"),
    SPRING("spring"),
    POSTGRESQL("postgresql"),
    DOCKER("docker"),
    PATTERN("pattern")
}
