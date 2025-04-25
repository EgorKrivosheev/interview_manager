package by.krivosheev.interview_manager.core.service

import by.krivosheev.interview_manager.core.ProfileEnum
import by.krivosheev.interview_manager.core.component.GoogleComponent
import by.krivosheev.interview_manager.core.config.MessageConfig
import by.krivosheev.interview_manager.core.dto.QuestionAnswerDto
import by.krivosheev.interview_manager.core.exception.GoogleIntegrationException
import by.krivosheev.interview_manager.core.service.impl.QuestionAnswerServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.mock
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QuestionAnswerServiceTest {

    private companion object {
        private const val EXPECTED_KEY = "Вопрос: 1-java"
        private const val EXPECTED_QUESTION = "Что такое java?"
        private const val EXPECTED_ANSWER = "Это язык программирования."
        private const val EXPECTED_ERROR_MESSAGE = "Извините, что-то пошло не так, попробуйте позже..."
    }

    private val googleComponentMock: GoogleComponent = mock()

    private val instance = QuestionAnswerServiceImpl(MessageConfig(), googleComponentMock)

    private fun buildQuestionAnswerDto() = QuestionAnswerDto(EXPECTED_KEY, EXPECTED_QUESTION, EXPECTED_ANSWER)

    @ParameterizedTest
    @EnumSource(ProfileEnum::class)
    fun `Assert get dto`(profile: ProfileEnum) {
        doReturn(listOf(listOf(EXPECTED_KEY, EXPECTED_QUESTION, EXPECTED_ANSWER)))
            .`when`(googleComponentMock)
            .getQuestions(profile)

        val actual = instance.getRandom(profile)
        // проверим маппинг
        assertThat(actual)
            .isEqualTo(buildQuestionAnswerDto())
    }

    @ParameterizedTest
    @EnumSource(ProfileEnum::class)
    fun `Throw exception when questions is empty`(profile: ProfileEnum) {
        doReturn(emptyList<List<String>>())
            .`when`(googleComponentMock)
            .getQuestions(profile)

        val actual = assertThrows<GoogleIntegrationException> { instance.getRandom(profile) }
        // проверим ошибку
        assertEquals(EXPECTED_ERROR_MESSAGE, actual.message)
    }
}
