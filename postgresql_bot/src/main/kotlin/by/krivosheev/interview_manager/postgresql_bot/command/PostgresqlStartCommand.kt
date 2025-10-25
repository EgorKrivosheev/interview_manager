package by.krivosheev.interview_manager.postgresql_bot.command

import by.krivosheev.interview_manager.core.ProfileEnum.POSTGRESQL
import by.krivosheev.interview_manager.core.command.StartCommand
import by.krivosheev.interview_manager.core.config.MessageConfig
import by.krivosheev.interview_manager.core.service.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * Класс реализации команды start для Postgresql бота.
 */
@Component
@Profile("!test")
class PostgresqlStartCommand(
    messageConfig: MessageConfig,
    private val userService: UserService
) : IPostgresqlBotCommand,
    StartCommand(messageConfig) {

    @Value("\${postgresql-bot.name}")
    private lateinit var botName: String

    override fun getBotName() = botName

    override fun createUserLogic(userId: String) = userService.createUserWithProfile(userId, POSTGRESQL)
}
