package by.krivosheev.interview_manager.core.service

import by.krivosheev.interview_manager.core.ProfileEnum

/**
 * Интерфейс для бизнес-логики сущности "Пользователь".
 */
interface UserService {

    /**
     * Создать пользователя с профилем.
     *
     * @param userId идентификатор пользователя
     * @param profile профиль пользователя
     */
    fun createUserWithProfile(userId: String, profile: ProfileEnum)
}
