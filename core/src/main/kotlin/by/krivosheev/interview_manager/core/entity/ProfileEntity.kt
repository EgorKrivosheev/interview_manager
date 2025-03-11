package by.krivosheev.interview_manager.core.entity

import by.krivosheev.interview_manager.core.ProfileEnum
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes

@Entity(name = "Profiles")
class ProfileEntity(
    @JdbcTypeCode(SqlTypes.VARCHAR)
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
    var type: ProfileEnum
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(
        name = "id",
        length = 80,
        nullable = false
    )
    val id: String = String.format("%s-%s", userId, type)

    @ManyToOne(
        targetEntity = UserEntity::class,
        fetch = FetchType.LAZY
    )
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "id",
        nullable = false,
        insertable = false,
        updatable = false
    )
    val user: UserEntity? = null
}
