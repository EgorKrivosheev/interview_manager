package by.krivosheev.interview_manager.spring_bot.command

import by.krivosheev.interview_manager.core.ProfileEnum.SPRING
import by.krivosheev.interview_manager.core.command.RandomCommand
import by.krivosheev.interview_manager.core.service.QuestionAnswerService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * Класс реализации команды random для Spring бота.
 */
@Component
@Profile("!test")
class SpringRandomCommand(
    questionAnswerService: QuestionAnswerService
) : ISpringBotCommand,
    RandomCommand(questionAnswerService) {

    @Value("\${spring-bot.name}")
    private lateinit var botName: String

    override fun getBotName() = botName

    override fun getProfile() = SPRING
}
