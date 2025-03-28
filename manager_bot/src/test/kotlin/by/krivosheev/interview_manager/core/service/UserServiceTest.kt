package by.krivosheev.interview_manager.core.service

import by.krivosheev.interview_manager.AbstractServiceTest
import by.krivosheev.interview_manager.core.ProfileEnum
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql
import kotlin.test.assertTrue

class UserServiceTest : AbstractServiceTest() {

    @Autowired
    private lateinit var instance: UserService

    private companion object {
        const val USER_ID = "user_id"
    }

    @ParameterizedTest
    @EnumSource(ProfileEnum::class)
    fun `Assert create user with profile`(profile: ProfileEnum) {
        assertDoesNotThrow { instance.createUserWithProfile(USER_ID, profile) }
        // проверим пользователя
        assertTrue { userEntityRepository.existsById(USER_ID) }
        // проверим профиль
        assertTrue { profileEntityRepository.existsByUserIdAndType(USER_ID, profile) }
    }

    @ParameterizedTest
    @EnumSource(ProfileEnum::class)
    @Sql(
        statements = [
            "insert into users (id) values ('$USER_ID');"
        ]
    )
    fun `Assert create profiles for existed user`(profile: ProfileEnum) {
        assertDoesNotThrow { instance.createUserWithProfile(USER_ID, profile) }
        // проверим профиль
        assertTrue { profileEntityRepository.existsByUserIdAndType(USER_ID, profile) }
    }
}
