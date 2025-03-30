package by.krivosheev.interview_manager.core.entity

import by.krivosheev.interview_manager.core.ProfileEnum
import jakarta.persistence.*

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
) : AbstractEntity<String>() {

    @OneToMany(
        targetEntity = ProfileEntity::class,
        cascade = [
            CascadeType.PERSIST,
            CascadeType.REMOVE
        ],
        fetch = FetchType.LAZY,
        mappedBy = "userId",
        orphanRemoval = true
    )
    var profiles: MutableSet<ProfileEntity> = mutableSetOf()

    fun getProfile(type: ProfileEnum) = profiles.find { it.type == type }
}
