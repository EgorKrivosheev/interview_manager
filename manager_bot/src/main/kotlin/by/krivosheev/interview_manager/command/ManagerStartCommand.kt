package by.krivosheev.interview_manager.command

import by.krivosheev.interview_manager.core.command.StartCommand
import by.krivosheev.interview_manager.core.config.MessageConfig
import by.krivosheev.interview_manager.core.service.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * Класс реализации команды start для Manager бота.
 */
@Component
@Profile("!test")
class ManagerStartCommand(
    messageConfig: MessageConfig,
    private val userService: UserService
) : StartCommand(messageConfig) {

    @Value("\${manager-bot.name}")
    private lateinit var botName: String

    override fun getBotName() = botName

    override fun createUserLogic(userId: String) {
        userService.createUserWithProfiles(userId)
    }
}
