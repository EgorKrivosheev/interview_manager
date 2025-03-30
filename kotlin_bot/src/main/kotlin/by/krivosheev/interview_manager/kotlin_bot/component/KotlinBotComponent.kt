package by.krivosheev.interview_manager.kotlin_bot.component

import by.krivosheev.interview_manager.core.component.AbstractBotComponent
import by.krivosheev.interview_manager.core.config.MessageConfig
import by.krivosheev.interview_manager.kotlin_bot.command.IKotlinBotCommand
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand

/**
 * Класс с реализацией "Kotlin" бота.
 */
@Component
@Profile("!test")
class KotlinBotComponent(
    @Value("\${kotlin-bot.token}")
    token: String,
    @Value("\${kotlin-bot.name}")
    name: String,
    messageConfig: MessageConfig,
    kotlinBotCommands: List<IKotlinBotCommand>
) : AbstractBotComponent<IBotCommand>(token, name, messageConfig, kotlinBotCommands)
