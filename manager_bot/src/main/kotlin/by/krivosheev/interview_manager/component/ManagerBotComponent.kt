package by.krivosheev.interview_manager.component

import by.krivosheev.interview_manager.command.IManagerBotCommand
import by.krivosheev.interview_manager.core.component.AbstractBotComponent
import by.krivosheev.interview_manager.core.config.MessageConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand

/**
 * Класс с реализацией Manager бота.
 */
@Component
@Profile("!test")
class ManagerBotComponent(
    @Value("\${manager-bot.token}")
    token: String,
    @Value("\${manager-bot.name}")
    name: String,
    messageConfig: MessageConfig,
    managerBotCommands: List<IManagerBotCommand>
) : AbstractBotComponent<IBotCommand>(token, name, messageConfig, managerBotCommands)
