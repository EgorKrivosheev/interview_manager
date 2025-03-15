package by.krivosheev.interview_manager.core.entity

import by.krivosheev.interview_manager.core.ProfileEnum
import jakarta.persistence.*

@Entity(name = "Users")
class UserEntity(
    @Id
    @Column(
        name = "id",
        length = 64,
        nullable = false
    )
    override val id: String,
    @OneToMany(
        targetEntity = ProfileEntity::class,
        cascade = [
            CascadeType.PERSIST,
            CascadeType.REMOVE,
            CascadeType.DETACH
        ],
        fetch = FetchType.LAZY,
        mappedBy = "userId",
        orphanRemoval = true
    )
    val profiles: MutableSet<ProfileEntity> = mutableSetOf()
) : AbstractEntity<String>() {

    fun addProfile(type: ProfileEnum) = profiles.add(ProfileEntity(id, type))

    fun getProfile(type: ProfileEnum) = profiles.find { it.type == type }

    fun removeProfile(type: ProfileEnum) = profiles.removeIf { it.type == type }
}
