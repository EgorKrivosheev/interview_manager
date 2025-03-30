package by.krivosheev.interview_manager.core.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

/**
 * Класс конфигурации с текстовыми сообщениями для пользователя.
 *
 * @param error текст сообщение при возникновении ошибки
 * @param notFoundCommand текст сообщения при некорректной команде
 */
@Configuration
@ConfigurationProperties(prefix = "message")
open class MessageConfig(
    var start: String = "Нажмите на команду в меню.",
    var error: String = "Извините, что-то пошло не так, попробуйте позже...",
    var notFoundCommand: String = "Извините, мне не доступна такая команда..."
)
