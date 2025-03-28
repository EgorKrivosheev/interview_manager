package by.krivosheev.interview_manager.core.service.impl

import by.krivosheev.interview_manager.core.ProfileEnum
import by.krivosheev.interview_manager.core.entity.ProfileEntity
import by.krivosheev.interview_manager.core.entity.UserEntity
import by.krivosheev.interview_manager.core.repository.ProfileEntityRepository
import by.krivosheev.interview_manager.core.repository.UserEntityRepository
import by.krivosheev.interview_manager.core.service.UserService
import jakarta.transaction.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
open class UserServiceImpl(
    private val userEntityRepository: UserEntityRepository,
    private val profileEntityRepository: ProfileEntityRepository
) : UserService {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(UserServiceImpl::class.java)
    }

    @Transactional
    override fun createUserWithProfile(userId: String, profile: ProfileEnum) {
        createUser(userId)
        addProfile(userId, profile)
    }

    private fun createUser(userId: String) = userEntityRepository.save(UserEntity(userId))
        .also { logger.debug("Создание пользователя: {}", userId) }

    private fun addProfile(
        userId: String,
        profile: ProfileEnum
    ) = profileEntityRepository.save(ProfileEntity(userId, profile))
        .also { logger.debug("Создание профиля: {}, для пользователя: {}", profile, userId) }
}
