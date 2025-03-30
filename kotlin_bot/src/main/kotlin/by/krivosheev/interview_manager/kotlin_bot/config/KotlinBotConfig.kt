package by.krivosheev.interview_manager.kotlin_bot.config

import by.krivosheev.interview_manager.core.config.AbstractBotConfig
import by.krivosheev.interview_manager.kotlin_bot.component.KotlinBotComponent
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

/**
 * Класс регистрации "Kotlin" бота.
 */
@Configuration
@Profile("!test")
class KotlinBotConfig : AbstractBotConfig() {

    @Bean
    fun registerKotlinBot(bot: KotlinBotComponent) = register(bot)
}
