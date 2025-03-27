package by.krivosheev.interview_manager.core.component

import by.krivosheev.interview_manager.core.ProfileEnum
import by.krivosheev.interview_manager.core.config.MessageConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.mockito.Mockito.*
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QuestionsComponentTest {

    private companion object {
        const val EXPECTED_QUESTION = "Вопрос?"
        const val EXPECTED_ANSWER = "Ответ"
        const val EXPECTED_ERROR_MESSAGE = "Извините, что-то пошло не так, попробуйте позже..."
    }

    private val googleComponentMock: GoogleComponent = mock()

    private var instance = QuestionsComponent(MessageConfig(), googleComponentMock)

    private fun doReturnQuestions(profile: ProfileEnum) {
        doReturn(mapOf(EXPECTED_QUESTION to EXPECTED_ANSWER))
            .`when`(googleComponentMock)
            .getQuestions(profile)
    }

    private fun doThrowNotFoundQuestionsException(
        expectedMessage: String = EXPECTED_ERROR_MESSAGE,
        profile: ProfileEnum = ProfileEnum.JAVA
    ) {
        doThrow(NotFoundQuestionsException(expectedMessage))
            .`when`(googleComponentMock)
            .getQuestions(profile)
    }

    @ParameterizedTest
    @EnumSource(ProfileEnum::class)
    fun `Assert get question-answer dto`(profile: ProfileEnum) {
        doReturnQuestions(profile)

        val actual = instance.getRandomQuestion(profile)
        // проверим вопрос-ответ
        assertThat(actual)
            .isEqualTo(QuestionDto(EXPECTED_QUESTION, EXPECTED_ANSWER))
    }

    @Test
    fun `Throw exception when questions is empty`() {
        doReturn(emptyMap<String, String>())
            .`when`(googleComponentMock)
            .getQuestions(ProfileEnum.JAVA)

        val actual = assertThrows<NotFoundQuestionsException> { instance.getRandomQuestion(ProfileEnum.JAVA) }
        // проверим ошибку
        assertEquals(EXPECTED_ERROR_MESSAGE, actual.message)
    }
}
