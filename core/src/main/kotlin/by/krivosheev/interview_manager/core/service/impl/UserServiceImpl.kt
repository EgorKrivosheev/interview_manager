package by.krivosheev.interview_manager.core.service.impl

import by.krivosheev.interview_manager.core.ProfileEnum
import by.krivosheev.interview_manager.core.entity.AbstractEntity
import by.krivosheev.interview_manager.core.entity.ProfileEntity
import by.krivosheev.interview_manager.core.entity.UserEntity
import by.krivosheev.interview_manager.core.repository.ProfileEntityRepository
import by.krivosheev.interview_manager.core.repository.UserEntityRepository
import by.krivosheev.interview_manager.core.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

/**
 * Класс реализации бизнес-логики сущности "Пользователь".
 */
@Service
open class UserServiceImpl(
    private val userEntityRepository: UserEntityRepository,
    private val profileEntityRepository: ProfileEntityRepository
) : UserService {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(UserServiceImpl::class.java)

        private fun <T, E> logEntity(entity: E): E
                where T : Any,
                      E : AbstractEntity<T> {
            logger.info("Создание {}", entity.toString())

            return entity
        }
    }

    override fun createUserWithProfile(userId: String, profile: ProfileEnum) {
        createUser(userId)
        addProfile(userId, profile)
    }

    override fun createUserWithProfiles(userId: String) {
        createUser(userId)
        ProfileEnum.entries
            .forEach { addProfile(userId, it) }
    }

    private fun createUser(userId: String) = userEntityRepository.save(UserEntity(userId))
        .also(::logEntity)

    private fun addProfile(
        userId: String,
        profile: ProfileEnum
    ) = profileEntityRepository.save(ProfileEntity(userId, profile))
        .also(::logEntity)
}
