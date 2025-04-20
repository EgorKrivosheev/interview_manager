package by.krivosheev.interview_manager.core.dto

/**
 * Класс содержащий данные вкладки.
 */
data class RangeDto(
    val range: String,
    val majorDimension: String,
    val values: List<List<String>>
) {

    fun filteredValues() = values.filter {
        it.isNotEmpty() && !it.firstOrNull().isNullOrEmpty()
    }
}
