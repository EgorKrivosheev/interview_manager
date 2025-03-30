package by.krivosheev.interview_manager.command

import by.krivosheev.interview_manager.core.command.StartCommand
import by.krivosheev.interview_manager.core.service.UserService
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import org.telegram.telegrambots.meta.api.methods.send.SendMessage

/**
 * Класс реализации команды start для Manager бота.
 */
@Component
@Profile("!test")
class ManagerStartCommand(
    private val userService: UserService
) : StartCommand() {

    @Value("\${manager-bot.name}")
    private lateinit var botName: String

    override fun getBotName() = botName

    override fun createUserLogic(userId: String) {
        userService.createUserWithProfiles(userId)
    }

    override fun createMessage(chatId: String) = SendMessage()
        .apply {
            setChatId(chatId)
            text = "Выберите необходимое направления в меню."
            enableMarkdown(false)
            disableWebPagePreview()
        }
}
