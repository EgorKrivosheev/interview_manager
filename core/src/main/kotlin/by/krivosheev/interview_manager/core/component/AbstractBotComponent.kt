package by.krivosheev.interview_manager.core.component

import by.krivosheev.interview_manager.core.config.MessageConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

/**
 * Абстрактный класс для создания бота с командами.
 *
 * @param token токен бота
 * @param name имя бота
 */
abstract class AbstractBotComponent(
    private val messageConfig: MessageConfig,
    private val token: String,
    private val name: String
) : TelegramLongPollingCommandBot(token) {

    protected companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    /**
     * Получить имя бота.
     */
    override fun getBotUsername() = name

    /**
     * Обработать сообщение не являющиеся командой.
     */
    override fun processNonCommandUpdate(update: Update) {
        if (update.hasMessage()) {
            val chatId = update.message.chatId
            sendTextMessage(chatId, messageConfig.notFoundCommand, false)
        }
    }

    /**
     * Отправить текстовое сообщение пользователю.
     *
     * @param chatId идентификатор чата
     * @param text текст сообщения
     * @param enableMarkdown включить поддержку Markdown
     */
    protected open fun sendTextMessage(
        chatId: Long,
        text: String,
        enableMarkdown: Boolean = true
    ): Unit = SendMessage()
        .apply {
            setChatId(chatId)
            setText(text)
            enableMarkdown(enableMarkdown)
            disableWebPagePreview()
        }
        .run {
            logger.info("Отправление текстового сообщения в чат: $chatId")

            execute(this)
        }
}
