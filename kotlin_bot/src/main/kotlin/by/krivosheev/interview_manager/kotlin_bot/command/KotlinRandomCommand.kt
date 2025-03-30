package by.krivosheev.interview_manager.kotlin_bot.command

import by.krivosheev.interview_manager.core.ProfileEnum.KOTLIN
import by.krivosheev.interview_manager.core.command.RandomCommand
import by.krivosheev.interview_manager.core.component.QuestionsComponent
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * Класс реализации команды random для Kotlin бота.
 */
@Component
@Profile("!test")
class KotlinRandomCommand(
    questionsComponent: QuestionsComponent
) : IKotlinBotCommand,
    RandomCommand(questionsComponent) {

    @Value("\${kotlin-bot.name}")
    private lateinit var botName: String

    override fun getBotName() = botName

    override fun getProfile() = KOTLIN
}
