package by.krivosheev.interview_manager.core.dto

/**
 * Класс содержащий данные сущности "Вопрос-ответ".
 */
data class QuestionAnswerDto(
    private val key: String,
    private val question: String,
    private val answer: String
) {

    /**
     * Получить текст под MarkdownV2 формат.
     */
    fun getFormattedText() = "${getFormattedKey()}\n${getFormattedQuestion()}\n${getFormattedAnswer()}"

    private fun getFormattedKey() = "❓${key.replace("-", "\\-")}"

    private fun getFormattedQuestion() = "*$question*\n"

    private fun getFormattedAnswer() = "⭐Ответ: ${answer.replace("-", "\\-")
        .replace("+", "\\+")
        .replace("|", "\\|")
        .replace("(", "\\(")
        .replace(")", "\\)")
        .replace(".", "\\.")}"
}
