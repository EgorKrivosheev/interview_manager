package by.krivosheev.interview_manager.core.service.impl

import by.krivosheev.interview_manager.core.ProfileEnum
import by.krivosheev.interview_manager.core.component.GoogleComponent
import by.krivosheev.interview_manager.core.config.MessageConfig
import by.krivosheev.interview_manager.core.dto.QuestionAnswerDto
import by.krivosheev.interview_manager.core.exception.GoogleIntegrationException
import by.krivosheev.interview_manager.core.service.QuestionAnswerService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 * Класс реализации бизнес-логики сущности "Вопрос-ответ".
 */
@Service
class QuestionAnswerServiceImpl(
    private val messageConfig: MessageConfig,
    private val googleComponent: GoogleComponent
) : QuestionAnswerService {

    private companion object {
        private const val KEY_INDEX = 0
        private const val QUESTION_INDEX = 1
        private const val ANSWER_INDEX = 2

        private val logger: Logger = LoggerFactory.getLogger(QuestionAnswerServiceImpl::class.java)
    }

    override fun getRandom(profile: ProfileEnum): QuestionAnswerDto {
        logger.info("Запрос случайного вопроса-ответа для профиля: $profile")

        try {
            return googleComponent.getQuestions(profile)
                .random()
                .let { QuestionAnswerDto(it[KEY_INDEX], it[QUESTION_INDEX], it[ANSWER_INDEX]) }
        } catch (e: RuntimeException) {
            logger.warn("Нет вопросов-ответов для профиля: $profile")

            throw GoogleIntegrationException(messageConfig.error)
        }
    }
}
