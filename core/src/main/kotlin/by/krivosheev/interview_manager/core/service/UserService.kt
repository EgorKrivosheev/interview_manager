package by.krivosheev.interview_manager.core.service

import by.krivosheev.interview_manager.core.ProfileEnum

interface UserService {

    /**
     * Создать пользователя с профилем.
     *
     * @param userId уникальный идентификатор пользователя
     * @param profile профиль пользователя
     */
    fun createUserWithProfile(userId: String, profile: ProfileEnum)
}
