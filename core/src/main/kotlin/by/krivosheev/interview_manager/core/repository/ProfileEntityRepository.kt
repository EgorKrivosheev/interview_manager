package by.krivosheev.interview_manager.core.repository

import by.krivosheev.interview_manager.core.entity.ProfileEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfileEntityRepository : CrudRepository<ProfileEntity, String> {
}
