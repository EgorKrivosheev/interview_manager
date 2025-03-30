package by.krivosheev.interview_manager.java_bot.config

import by.krivosheev.interview_manager.core.config.AbstractBotConfig
import by.krivosheev.interview_manager.java_bot.component.JavaBotComponent
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

/**
 * Класс регистрации "Java" бота.
 */
@Configuration
@Profile("!test")
class JavaBotConfig : AbstractBotConfig() {

    @Bean
    fun registerJavaBot(bot: JavaBotComponent) = register(bot)
}
