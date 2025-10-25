package by.krivosheev.interview_manager.postgresql_bot.command

import by.krivosheev.interview_manager.core.ProfileEnum.POSTGRESQL
import by.krivosheev.interview_manager.core.command.RandomCommand
import by.krivosheev.interview_manager.core.service.QuestionAnswerService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * Класс реализации команды random для Postgresql бота.
 */
@Component
@Profile("!test")
class PostgresqlRandomCommand(
    questionAnswerService: QuestionAnswerService
) : IPostgresqlBotCommand,
    RandomCommand(questionAnswerService) {

    @Value("\${postgresql-bot.name")
    private lateinit var botName: String

    override fun getBotName() = botName

    override fun getProfile() = POSTGRESQL
}
