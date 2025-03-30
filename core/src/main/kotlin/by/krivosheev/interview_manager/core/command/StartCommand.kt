package by.krivosheev.interview_manager.core.command

import by.krivosheev.interview_manager.core.CommandBotEnum.START
import by.krivosheev.interview_manager.core.config.MessageConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender

/**
 * Абстрактный класс реализации команды start.
 */
abstract class StartCommand(
    private val messageConfig: MessageConfig
) : BotCommand(START.command, START.description) {

    protected companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun execute(
        absSender: AbsSender,
        user: User,
        chat: Chat,
        arguments: Array<out String>
    ) {
        logger.info("Обработка команды start для бота: ${getBotName()}")

        val userId = user.id.toString()
        createUserLogic(userId)

        val chatId = chat.id.toString()

        logger.info("[${getBotName()}-start] - Отправление сообщения пользователю ($userId) в чат: $chatId")

        absSender.executeAsync(SendMessage(chatId, messageConfig.start))
    }

    protected abstract fun getBotName(): String

    protected abstract fun createUserLogic(userId: String)
}
