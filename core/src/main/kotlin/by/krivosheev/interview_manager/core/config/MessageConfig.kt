package by.krivosheev.interview_manager.core.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "message")
open class MessageConfig(
    val error: String = "Извините, что-то пошло не так, попробуйте позже..."
)
