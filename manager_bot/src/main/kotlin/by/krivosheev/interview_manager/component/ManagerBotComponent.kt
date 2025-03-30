package by.krivosheev.interview_manager.component

import by.krivosheev.interview_manager.command.ManagerStartCommand
import by.krivosheev.interview_manager.core.component.AbstractBotComponent
import by.krivosheev.interview_manager.core.config.MessageConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

/**
 * Класс с реализацией "Manager" бота.
 */
@Component
@Profile("!test")
class ManagerBotComponent(
    @Value("\${manager-bot.token}")
    token: String,
    @Value("\${manager-bot.name}")
    name: String,
    messageConfig: MessageConfig,
    startCommand: ManagerStartCommand
) : AbstractBotComponent<ManagerStartCommand>(token, name, messageConfig, startCommand)
