package by.krivosheev.interview_manager.core.dto

/**
 * Класс содержащий данные вкладки.
 */
data class RangeDto(
    private val range: String,
    private val majorDimension: String,
    private val values: List<List<String>>
) {

    fun filteredValues() = values.filter {
        it.isNotEmpty() && !it.firstOrNull().isNullOrEmpty()
    }
}
