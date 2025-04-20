package by.krivosheev.interview_manager.core.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

/**
 * Класс конфигурации для работы с Google таблицами.
 *
 * @param apiKey ключ для подключения к Google таблице
 * @param sheetId идентификатор Google таблицы
 */
@Configuration
@ConfigurationProperties(prefix = "google")
open class GoogleConfig(
    var apiKey: String = "null",
    var sheetId: String = "null"
)
