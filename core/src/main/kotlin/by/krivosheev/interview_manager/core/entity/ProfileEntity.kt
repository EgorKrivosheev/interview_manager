package by.krivosheev.interview_manager.core.entity

import by.krivosheev.interview_manager.core.ProfileEnum
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

/**
 * Класс сущность "Профиль пользователя".
 *
 * @param userId идентификатор пользователя
 * @param type тип профиля
 * @param id идентификатор профиля
 */
@Entity(name = "Profiles")
class ProfileEntity(
    @Column(
        name = "user_id",
        length = 64,
        nullable = false
    )
    val userId: String,
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(
        length = 16,
        nullable = false
    )
    val type: ProfileEnum,
    @Id
    @Column(
        length = 80,
        nullable = false
    )
    override val id: String? = String.format("%s-%s", userId, type.value)
) : AbstractEntity<String>()
