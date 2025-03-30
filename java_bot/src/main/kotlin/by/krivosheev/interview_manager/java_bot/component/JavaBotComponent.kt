package by.krivosheev.interview_manager.java_bot.component

import by.krivosheev.interview_manager.core.component.AbstractBotComponent
import by.krivosheev.interview_manager.core.config.MessageConfig
import by.krivosheev.interview_manager.java_bot.command.IJavaBotCommand
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand

/**
 * Класс с реализацией "Java" бота.
 */
@Component
@Profile("!test")
class JavaBotComponent(
    @Value("\${java-bot.token}")
    token: String,
    @Value("\${java-bot.name}")
    name: String,
    messageConfig: MessageConfig,
    javaBotCommands: List<IJavaBotCommand>
) : AbstractBotComponent<IBotCommand>(token, name, messageConfig, javaBotCommands)
