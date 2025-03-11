package by.krivosheev.interview_manager.core.entity

import by.krivosheev.interview_manager.core.ProfileEnum
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity(name = "Users")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(
        name = "id",
        length = 64,
        nullable = false
    )
    val id: String
) {

    @OneToMany(
        targetEntity = ProfileEntity::class,
        cascade = [
            CascadeType.REMOVE
        ],
        fetch = FetchType.LAZY,
        mappedBy = "userId"
    )
    var profiles: Set<ProfileEntity> = emptySet()

    fun getProfile(type: ProfileEnum) = profiles.find { p: ProfileEntity -> type == p.type }
}
