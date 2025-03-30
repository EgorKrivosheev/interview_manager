package by.krivosheev.interview_manager.core

/**
 * Команды бота.
 */
enum class CommandBotEnum(val command: String, val description: String) {
    START("start", "Создать профиля пользователя"),
    RANDOM("random", "Получить случайный вопрос-ответ")
}
