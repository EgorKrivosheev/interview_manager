package by.krivosheev.interview_manager.core.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

/**
 * Класс сущность "Пользователь".
 *
 * @param id идентификатор пользователя
 */
@Entity(name = "Users")
class UserEntity(
    @Id
    @Column(
        name = "id",
        length = 64,
        nullable = false
    )
    override val id: String
) : AbstractEntity<String>()
