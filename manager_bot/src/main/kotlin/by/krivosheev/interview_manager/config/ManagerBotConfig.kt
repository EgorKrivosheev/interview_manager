package by.krivosheev.interview_manager.config

import by.krivosheev.interview_manager.component.ManagerBotComponent
import by.krivosheev.interview_manager.core.config.AbstractBotConfig
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

/**
 * Класс регистрации "Manager" бота.
 */
@Configuration
@Profile("!test")
class ManagerBotConfig : AbstractBotConfig() {

    @Bean
    fun registerManagerBot(bot: ManagerBotComponent) = register(bot)
}
