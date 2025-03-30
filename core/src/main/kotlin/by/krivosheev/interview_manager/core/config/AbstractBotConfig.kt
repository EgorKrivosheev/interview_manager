package by.krivosheev.interview_manager.core.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

/**
 * Абстрактный класс регистрации бота.
 */
abstract class AbstractBotConfig {

    protected companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    protected fun <T : TelegramLongPollingBot> register(bot: T) = TelegramBotsApi(DefaultBotSession::class.java)
        .apply {
            logger.info("Регистрация бота: ${bot.botUsername}")

            registerBot(bot)
        }
}
