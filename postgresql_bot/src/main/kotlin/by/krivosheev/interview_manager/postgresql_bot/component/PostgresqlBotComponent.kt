package by.krivosheev.interview_manager.postgresql_bot.component

import by.krivosheev.interview_manager.core.component.AbstractBotComponent
import by.krivosheev.interview_manager.core.config.MessageConfig
import by.krivosheev.interview_manager.postgresql_bot.command.IPostgresqlBotCommand
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand

/**
 * Класс с реализацией Postgresql бота.
 */
@Component
@Profile("!test")
class PostgresqlBotComponent(
    @Value("\${postgresql-bot.token}")
    token: String,
    @Value("\${postgresql-bot.name}")
    name: String,
    messageConfig: MessageConfig,
    postgresqlBotCommands: List<IPostgresqlBotCommand>
) : AbstractBotComponent<IBotCommand>(token, name, messageConfig, postgresqlBotCommands)
