package by.krivosheev.interview_manager.core.handler

import by.krivosheev.interview_manager.core.CommandBotEnum

interface CommandHandler {

    fun handle(command: CommandBotEnum)

    fun handle(command: CommandBotEnum, args: Array<String>)
}
