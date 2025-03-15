package by.krivosheev.interview_manager.core.entity

import by.krivosheev.interview_manager.core.ProfileEnum
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

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
) : AbstractEntity<String>() {

    @ManyToOne(
        targetEntity = UserEntity::class,
        fetch = FetchType.LAZY,
        optional = false
    )
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "id",
        nullable = false,
        insertable = false,
        updatable = false,
        foreignKey = ForeignKey(name = "fk_profiles_on_user")
    )
    val user: UserEntity? = null
}
