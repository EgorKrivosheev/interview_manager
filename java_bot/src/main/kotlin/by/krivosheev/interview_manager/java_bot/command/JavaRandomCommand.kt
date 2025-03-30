package by.krivosheev.interview_manager.java_bot.command

import by.krivosheev.interview_manager.core.ProfileEnum.JAVA
import by.krivosheev.interview_manager.core.command.RandomCommand
import by.krivosheev.interview_manager.core.component.QuestionsComponent
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * Класс реализации команды random для Java бота.
 */
@Component
@Profile("!test")
class JavaRandomCommand(
    questionsComponent: QuestionsComponent
) : IJavaBotCommand,
    RandomCommand(questionsComponent) {

    @Value("\${java-bot.name}")
    private lateinit var botName: String

    override fun getBotName() = botName

    override fun getProfile() = JAVA
}
