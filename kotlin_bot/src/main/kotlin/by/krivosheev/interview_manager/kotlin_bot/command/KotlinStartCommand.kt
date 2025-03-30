package by.krivosheev.interview_manager.kotlin_bot.command

import by.krivosheev.interview_manager.core.ProfileEnum.KOTLIN
import by.krivosheev.interview_manager.core.command.StartCommand
import by.krivosheev.interview_manager.core.config.MessageConfig
import by.krivosheev.interview_manager.core.service.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * Класс реализации команды start для Kotlin бота.
 */
@Component
@Profile("!test")
class KotlinStartCommand(
    messageConfig: MessageConfig,
    private val userService: UserService
) : IKotlinBotCommand,
    StartCommand(messageConfig) {

    @Value("\${kotlin-bot.name}")
    private lateinit var botName: String

    override fun getBotName() = botName

    override fun createUserLogic(userId: String) {
        userService.createUserWithProfile(userId, KOTLIN)
    }
}
