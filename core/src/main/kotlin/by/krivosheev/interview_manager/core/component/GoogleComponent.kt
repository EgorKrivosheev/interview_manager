package by.krivosheev.interview_manager.core.component

import by.krivosheev.interview_manager.core.ProfileEnum
import by.krivosheev.interview_manager.core.client.GoogleSheetsClient
import by.krivosheev.interview_manager.core.config.GoogleConfig
import by.krivosheev.interview_manager.core.config.MessageConfig
import by.krivosheev.interview_manager.core.exception.GoogleIntegrationException
import feign.FeignException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component

/**
 * Класс с реализацией для работы с Google таблицами.
 */
@Component
open class GoogleComponent(
    private val messageConfig: MessageConfig,
    private val googleConfig: GoogleConfig,
    private val googleSheetsClient: GoogleSheetsClient
) {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(GoogleComponent::class.java)
    }

    /**
     * Получить список вопросов-ответов по профилю.
     *
     * @exception GoogleIntegrationException если не смогли подключиться к Google таблице.
     */
    @Cacheable(
        cacheNames = [
            "questions"
        ],
        key = "#profile"
    )
    open fun getQuestions(profile: ProfileEnum) = getSheetData(profile)
        .also { logger.info("Запрос списка вопросов-ответов для профиля: $profile") }

    private fun getSheetData(profile: ProfileEnum): List<List<String>> {
        val range = "${profile.value}!A2:C"

        try {
            val rangeDto = googleSheetsClient.getValues(googleConfig.sheetId, range, googleConfig.apiKey)
            return rangeDto.filteredValues()
        } catch (e: FeignException) {
            logger.error("Произошла ошибка интеграции с Google таблицей для профиля: {}", profile, e)

            throw GoogleIntegrationException(messageConfig.error)
        }
    }
}
