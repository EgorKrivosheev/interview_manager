package by.krivosheev.interview_manager.core.component

import by.krivosheev.interview_manager.core.ProfileEnum
import by.krivosheev.interview_manager.core.config.MessageConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class QuestionsComponent(
    private val messageConfig: MessageConfig,
    private val googleComponent: GoogleComponent
) {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(QuestionsComponent::class.java)
    }

    /**
     * Получить случайный вопрос-ответ по профилю.
     *
     * @exception NotFoundQuestionsException если нет вопрос-ответа по профилю.
     */
    fun getRandomQuestion(profile: ProfileEnum): QuestionDto {
        logger.info("Запрос случайного вопроса-ответа для профиля: $profile")

        try {
            val questions = googleComponent.getQuestions(profile)
            val randomQuestion = questions.entries.random()

            return QuestionDto(randomQuestion.key, randomQuestion.value)
        } catch (e: NoSuchElementException) {
            logger.error("Нет вопросов-ответов для профиля: $profile")

            throw NotFoundQuestionsException(messageConfig.error)
        }
    }
}

/**
 * Класс содержащий данные сущности "Вопрос-ответ"
 */
data class QuestionDto(
    val question: String,
    val answer: String
)

/**
 * Ошибка, нет вопросов-ответов
 */
class NotFoundQuestionsException(
    override val message: String
) : RuntimeException(message)
