package by.krivosheev.interview_manager.core.component

import by.krivosheev.interview_manager.core.ProfileEnum
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

@Component
open class GoogleComponent {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(QuestionsComponent::class.java)
    }

    /**
     * Получить список вопросов-ответов по профилю.
     */
    @Cacheable(
        cacheNames = [
            "questions"
        ],
        key = "#profile"
    )
    open fun getQuestions(profile: ProfileEnum): Map<String, String> {
        logger.info("Запрос списка вопросов-ответов для профиля: $profile")
        // TODO: добавить получение вопросов из гугл таблицы
        return mapOf(
            "Question №1?" to "Answer",
            "Question №2?" to "Answer",
            "Question №3?" to "Answer",
            "Question №4?" to "Answer",
            "Question №5?" to "Answer",
            "Question №6?" to "Answer",
            "Question №7?" to "Answer",
            "Question №8?" to "Answer",
            "Question №9?" to "Answer",
            "Question №10?" to "Answer"
        )
    }
}
