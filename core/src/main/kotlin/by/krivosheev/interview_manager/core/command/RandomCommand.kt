package by.krivosheev.interview_manager.core.command

import by.krivosheev.interview_manager.core.CommandBotEnum.RANDOM
import by.krivosheev.interview_manager.core.ProfileEnum
import by.krivosheev.interview_manager.core.component.NotFoundQuestionsException
import by.krivosheev.interview_manager.core.component.QuestionsComponent
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Chat
import org.telegram.telegrambots.meta.api.objects.User
import org.telegram.telegrambots.meta.bots.AbsSender

/**
 * Абстрактный класс реализации команды random.
 */
abstract class RandomCommand(
    private val questionsComponent: QuestionsComponent
) : BotCommand(RANDOM.command, RANDOM.description) {

    protected companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun execute(
        absSender: AbsSender,
        user: User,
        chat: Chat,
        arguments: Array<out String>
    ) {
        logger.info("Обработка команды random для бота: ${getBotName()}")

        val userId = user.id.toString()
        val chatId = chat.id.toString()
        val profile = getProfile()

        try {
            val sendMessage = questionsComponent.getRandomQuestion(profile)
                .run {
                    logger.info("[${getBotName()}-random] - Отправление сообщения пользователю ($userId) в чат: $chatId")

                    SendMessage(chatId, getText())
                }

            absSender.executeAsync(sendMessage)
        } catch (e: NotFoundQuestionsException) {
            absSender.executeAsync(
                SendMessage(chatId, e.message)
                    .also {
                        logger.info("[${getBotName()}-random] - Отправление сообщения об ошибке пользователю ($userId) в чат: $chatId")
                    }
            )
        }
    }

    protected abstract fun getBotName(): String

    protected abstract fun getProfile(): ProfileEnum
}
