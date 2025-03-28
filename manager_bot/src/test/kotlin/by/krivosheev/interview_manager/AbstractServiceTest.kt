package by.krivosheev.interview_manager

import by.krivosheev.interview_manager.core.repository.ProfileEntityRepository
import by.krivosheev.interview_manager.core.repository.UserEntityRepository
import io.zonky.test.db.AutoConfigureEmbeddedDatabase
import io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY
import io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseType.POSTGRES
import io.zonky.test.db.AutoConfigureEmbeddedDatabase.RefreshMode.AFTER_EACH_TEST_METHOD
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE
import org.springframework.test.context.ActiveProfiles

@SpringBootTest(webEnvironment = NONE)
@ActiveProfiles("test")
@AutoConfigureEmbeddedDatabase(
    refresh = AFTER_EACH_TEST_METHOD,
    type = POSTGRES,
    provider = ZONKY
)
abstract class AbstractServiceTest {

    @Autowired
    protected lateinit var userEntityRepository: UserEntityRepository

    @Autowired
    protected lateinit var profileEntityRepository: ProfileEntityRepository
}
