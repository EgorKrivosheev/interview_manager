package by.krivosheev.interview_manager.java_bot.command

import by.krivosheev.interview_manager.core.ProfileEnum.JAVA
import by.krivosheev.interview_manager.core.command.StartCommand
import by.krivosheev.interview_manager.core.config.MessageConfig
import by.krivosheev.interview_manager.core.service.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * Класс реализации команды start для Java бота.
 */
@Component
@Profile("!test")
class JavaStartCommand(
    messageConfig: MessageConfig,
    private val userService: UserService
) : IJavaBotCommand,
    StartCommand(messageConfig) {

    @Value("\${java-bot.name}")
    private lateinit var botName: String

    override fun getBotName() = botName

    override fun createUserLogic(userId: String) {
        userService.createUserWithProfile(userId, JAVA)
    }
}
