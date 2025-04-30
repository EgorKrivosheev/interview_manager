package by.krivosheev.interview_manager.spring_bot.component

import by.krivosheev.interview_manager.core.component.AbstractBotComponent
import by.krivosheev.interview_manager.core.config.MessageConfig
import by.krivosheev.interview_manager.spring_bot.command.ISpringBotCommand
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand

/**
 * Класс с реализацией Spring бота.
 */
@Component
@Profile("!test")
class SpringBotComponent(
    @Value("\${spring-bot.token}")
    token: String,
    @Value("\${spring-bot.name}")
    name: String,
    messageConfig: MessageConfig,
    springBotCommands: List<ISpringBotCommand>
) : AbstractBotComponent<IBotCommand>(token, name, messageConfig, springBotCommands)
