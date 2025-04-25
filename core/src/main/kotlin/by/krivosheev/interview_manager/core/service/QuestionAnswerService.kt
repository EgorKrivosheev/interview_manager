package by.krivosheev.interview_manager.core.service

import by.krivosheev.interview_manager.core.ProfileEnum
import by.krivosheev.interview_manager.core.dto.QuestionAnswerDto
import by.krivosheev.interview_manager.core.exception.GoogleIntegrationException

/**
 * Интерфейс для бизнес-логики сущности "Вопрос-ответ".
 */
interface QuestionAnswerService {

    /**
     * Получить случайный вопрос-ответ по профилю.
     *
     * @param profile профиль пользователя
     * @return сущность "вопрос-ответ"
     * @exception GoogleIntegrationException если нет вопрос-ответа по профилю.
     */
    fun getRandom(profile: ProfileEnum): QuestionAnswerDto
}
