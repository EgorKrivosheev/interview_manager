package by.krivosheev.interview_manager.core.entity

import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.util.ProxyUtils

@MappedSuperclass
abstract class AbstractEntity<T> {
    @Id
    val id: T? = null

    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true

        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as AbstractEntity<*>

        return this.id != null && this.id == other.id
    }

    override fun hashCode() = id?.hashCode() ?: 50

    override fun toString() = "${this.javaClass.simpleName}(id=$id)"
}
