package by.krivosheev.interview_manager.core.component

import by.krivosheev.interview_manager.core.config.MessageConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

/**
 * Абстрактный класс для создания бота с командами.
 *
 * @param token токен бота
 * @param name имя бота
 * @param messageConfig конфигурация текстовых сообщений пользователю
 * @param commands список реализаций команд бота
 */
abstract class AbstractBotComponent<T : IBotCommand>(
    private val token: String,
    private val name: String,
    private val messageConfig: MessageConfig,
    private val commands: List<T>
) : TelegramLongPollingCommandBot(token) {

    protected companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    init {
        commands.forEach {
            logger.info("Регистрация команды ${it.commandIdentifier} для бота: $name")

            register(it)
        }
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
            sendTextMessage(chatId, messageConfig.notFoundCommand)
        }
    }

    /**
     * Отправить текстовое сообщение пользователю.
     *
     * @param chatId идентификатор чата
     * @param text текст сообщения
     */
    protected open fun sendTextMessage(
        chatId: Long,
        text: String
    ): Unit = SendMessage()
        .apply {
            setChatId(chatId)
            setText(text)
            enableMarkdown(false)
            disableWebPagePreview()
        }
        .run {
            logger.info("[$name] - Отправление текстового сообщения в чат: $chatId")

            executeAsync(this)
        }
}
