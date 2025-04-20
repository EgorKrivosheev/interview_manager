package by.krivosheev.interview_manager.core.exception

/**
 * Ошибка интеграции с Google таблицами.
 */
class GoogleIntegrationException(
    override val message: String,
    override val cause: Throwable? = null
) : RuntimeException(message, cause)
