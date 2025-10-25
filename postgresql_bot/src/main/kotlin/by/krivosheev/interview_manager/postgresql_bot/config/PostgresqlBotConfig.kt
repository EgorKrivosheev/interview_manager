package by.krivosheev.interview_manager.postgresql_bot.config

import by.krivosheev.interview_manager.core.config.AbstractBotConfig
import by.krivosheev.interview_manager.postgresql_bot.component.PostgresqlBotComponent
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

/**
 * Класс регистрации Postgresql бота.
 */
@Configuration
@Profile("!test")
class PostgresqlBotConfig : AbstractBotConfig() {

    @Bean
    fun registerPostgresqlBot(bot: PostgresqlBotComponent) = register(bot)
}
