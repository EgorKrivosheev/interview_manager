package by.krivosheev.interview_manager

import io.zonky.test.db.AutoConfigureEmbeddedDatabase
import io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseProvider.ZONKY
import io.zonky.test.db.AutoConfigureEmbeddedDatabase.DatabaseType.POSTGRES
import io.zonky.test.db.AutoConfigureEmbeddedDatabase.RefreshMode.AFTER_EACH_TEST_METHOD
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestPropertySource

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureEmbeddedDatabase(
    refresh = AFTER_EACH_TEST_METHOD,
    type = POSTGRES,
    provider = ZONKY
)
@TestPropertySource(
    properties = [
        "spring.jpa.hibernate.ddl-auto=validate"
    ]
)
class InterviewManagerApplicationTests {

    @Test
    fun `Assert validation tables`() {
    }
}
