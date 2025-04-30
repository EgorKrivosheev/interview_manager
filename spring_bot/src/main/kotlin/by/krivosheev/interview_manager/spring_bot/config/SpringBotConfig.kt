package by.krivosheev.interview_manager.spring_bot.config

import by.krivosheev.interview_manager.core.config.AbstractBotConfig
import by.krivosheev.interview_manager.spring_bot.component.SpringBotComponent
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

/**
 * Класс регистрации Spring бота.
 */
@Configuration
@Profile("!test")
class SpringBotConfig : AbstractBotConfig() {

    @Bean
    fun registerSpringBot(bot: SpringBotComponent) = register(bot)
}
