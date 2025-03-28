package by.krivosheev.interview_manager.core.repository

import by.krivosheev.interview_manager.core.entity.UserEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserEntityRepository : CrudRepository<UserEntity, String>
