package by.krivosheev.interview_manager.spring_bot.command

import by.krivosheev.interview_manager.core.ProfileEnum.SPRING
import by.krivosheev.interview_manager.core.command.StartCommand
import by.krivosheev.interview_manager.core.config.MessageConfig
import by.krivosheev.interview_manager.core.service.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * Класс реализации команды start для Spring бота.
 */
@Component
@Profile("!test")
class SpringStartCommand(
    messageConfig: MessageConfig,
    private val userService: UserService
) : ISpringBotCommand,
    StartCommand(messageConfig) {

    @Value("\${spring-bot.name}")
    private lateinit var botName: String

    override fun getBotName() = botName

    override fun createUserLogic(userId: String) = userService.createUserWithProfile(userId, SPRING)
}
